package com.github.fescalhao.chapter19.Type_Parameterization.classes

import com.github.fescalhao.chapter19.Type_Parameterization.traits._

private class QueueImpl[+T] (
              private[this] var leading: List[T],
              private[this] var trailing: List[T]
              ) extends Queue[T] {

  private def mirror(): Any = {
    if (leading.isEmpty) {
      while (trailing.nonEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    } else
      this
  }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: QueueImpl[T] = {
    mirror()
    new QueueImpl[T](leading.tail, trailing)
  }

  // Now 'U' is a supertype of 'T'
  def enqueue[U >: T](elem: U): QueueImpl[U] = {
    new QueueImpl[U](leading, elem :: trailing)
  }

  override def toString: String = s"${(leading ::: trailing.reverse).mkString(", ")}"
}

object Queue {
  def apply[T](list: T*): Queue[T] = new QueueImpl[T](list.toList, Nil)
}
