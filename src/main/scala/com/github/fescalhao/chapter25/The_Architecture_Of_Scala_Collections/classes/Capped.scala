package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

import scala.collection._

final class Capped[A] private(val capacity: Int, val length: Int, offset: Int, elems: Array[Any])
  extends immutable.Iterable[A]
    with IterableOps[A, Capped, Capped[A]]
    with StrictOptimizedIterableOps[A, Capped, Capped[A]] {
  self =>

  def this(capacity: Int) = this(capacity, length = 0, offset = 0, elems = Array.ofDim(capacity))

  def appended[B >: A](elem: B): Capped[B] = {
    val newElems = Array.ofDim[Any](capacity)
    Array.copy(elems, 0, newElems, 0, capacity)
    val (newOffset, newLength) = {
      if (length == capacity) {
        newElems(offset) = elem
        ((offset + 1) % capacity, length)
      } else {
        newElems(length) = elem
        (offset, length + 1)
      }
    }
    new Capped[B](capacity, newLength, newOffset, newElems)
  }

  @inline def :+[B >: A](elem: B): Capped[B] = appended(elem)

  def apply(i: Int): A = elems((i + offset) % capacity).asInstanceOf[A]

  override def view: IndexedSeqView[A] = new IndexedSeqView[A] {
    override def apply(i: Int): A = self(i)

    override def length: Int = self.length
  }

  override def iterator: Iterator[A] = view.iterator

  override def iterableFactory: IterableFactory[Capped] = new CappedFactory(capacity)

  override protected def fromSpecific(coll: IterableOnce[A]): Capped[A] = iterableFactory.from(coll)

  override protected def newSpecificBuilder: mutable.Builder[A, Capped[A]] = iterableFactory.newBuilder

  override def empty: Capped[A] = iterableFactory.empty

  override def className: String = "Capped"

  override def knownSize: Int = length
}

class CappedFactory(capacity: Int) extends IterableFactory[Capped] {
  override def from[A](source: IterableOnce[A]): Capped[A] = source match {
    case capped: Capped[A] if capped.capacity == capacity => capped
    case _ => (newBuilder[A] ++= source).result()
  }

  override def empty[A]: Capped[A] = new Capped[A](capacity)

  override def newBuilder[A]: mutable.Builder[A, Capped[A]] = {
    new mutable.ImmutableBuilder[A, Capped[A]](empty) {
      override def addOne(elem: A): this.type = {
        elems = elems :+ elem
        this
      }
    }
  }
}
