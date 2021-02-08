package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}
import scala.collection.{AbstractIterator, StrictOptimizedSeqOps, mutable}

final class RNA private (val groups: Array[Int], val length: Int)
  extends IndexedSeq[RNABase]
    with IndexedSeqOps[RNABase, IndexedSeq, RNA]
    with StrictOptimizedSeqOps[RNABase, IndexedSeq, RNA] { rna =>

  import RNA._

  override def apply(i: Int): RNABase = {
    if (i < 0 || length <= i)
      throw new IndexOutOfBoundsException
    RNABase.fromInt(groups(i / N) >> (i % N * S) & M)
  }

  override def className: String = "RNA"

  override protected def fromSpecific(coll: IterableOnce[RNABase]): RNA = fromSeq(coll.iterator.toSeq)

  override protected def newSpecificBuilder: mutable.Builder[RNABase, RNA] = iterableFactory.newBuilder[RNABase].mapResult(fromSeq)

  override def empty: RNA = fromSeq(Seq.empty)

  def appended(base: RNABase): RNA = (newSpecificBuilder ++= this += base).result()

  def appendedAll(suffix: IterableOnce[RNABase]): RNA = strictOptimizedConcat(suffix, newSpecificBuilder)

  def concat(suffix: IterableOnce[RNABase]): RNA = strictOptimizedConcat(suffix, newSpecificBuilder)

  def flatMap(f: RNABase => IterableOnce[RNABase]): RNA = strictOptimizedFlatMap(newSpecificBuilder, f)

  def map(f: RNABase => RNABase): RNA = strictOptimizedMap(newSpecificBuilder, f)

  def prepended(base: RNABase): RNA = (newSpecificBuilder += base ++= this).result()

  def prependedAll(prefix: Iterable[RNABase]): RNA = (newSpecificBuilder ++= prefix ++= this).result()

  @inline def ++ (suffix: IterableOnce[RNABase]): RNA = concat(suffix)

  override def iterator: Iterator[RNABase] = new AbstractIterator[RNABase] {
    private var i = 0
    private var b = 0

    override def hasNext: Boolean = i < rna.length

    override def next(): RNABase = {
      b = if (i % N == 0) groups(i / N) else b >>> S
      i += 1
      RNABase.fromInt(b & M)
    }
  }
}

object RNA {
  // Number of bits necessary to represent a group
  private val S = 2

  // Number of groups that fit in a Int
  private val N = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: collection.Seq[RNABase]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- buf.indices) {
      groups(i / N) |= RNABase.toInt(buf(i)) << (i % N * S)
    }
    new RNA(groups, buf.length)
  }

  def apply(bases: RNABase*): RNA = fromSeq(bases)

  def empty: RNA = fromSeq(Seq.empty)

  def newBuilder: mutable.Builder[RNABase, RNA] = mutable.ArrayBuffer.newBuilder[RNABase].mapResult(fromSeq)

  def fromSpecific(it: IterableOnce[RNABase]): RNA = it match {
    case seq: collection.Seq[RNABase] => fromSeq(seq)
    case _ => fromSeq(mutable.ArrayBuffer.from(it))
  }
}
