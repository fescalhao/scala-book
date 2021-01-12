package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}
import scala.collection.mutable

final class RNA private (val groups: Array[Int], val length: Int)
  extends IndexedSeq[RNABase]
    with IndexedSeqOps[RNABase, IndexedSeq, RNA] {

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
}
