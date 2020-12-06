package com.github.fescalhao.chapter19.Type_Parameterization.classes

import com.github.fescalhao.chapter19.Type_Parameterization.traits._

private class QueueImpl[T] (
              private val leading: List[T],
              private val trailing: List[T]
              ) extends Queue[T] {

  private def mirror: QueueImpl[T] = {
    if (leading.isEmpty)
      new QueueImpl[T](trailing.reverse, Nil)
    else
      this
  }

  def head: T = mirror.leading.head

  def tail: QueueImpl[T] = {
    val q = mirror
    new QueueImpl[T](q.leading.tail, q.trailing)
  }

  def enqueue(elem: T): QueueImpl[T] = {
    new QueueImpl[T](leading, elem :: trailing)
  }

  override def toString: String = s"${(leading ::: trailing.reverse).mkString(", ")}"
}

object Queue {
  def apply[T](list: T*): Queue[T] = new QueueImpl[T](list.toList, Nil)
}
