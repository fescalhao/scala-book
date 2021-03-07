package com.github.fescalhao.chapter30.Object_Equality.classes

import com.github.fescalhao.chapter30.Object_Equality.traits.Tree

class Branch[+T](
                  val elem: T,
                  val left: Tree[T],
                  val right: Tree[T]
                ) extends Tree[T] {

  override def equals(other: Any): Boolean = other match {
    case that: Branch[t] => (that canEqual this) &&
                            that.elem == this.elem &&
                            that.left == this.left &&
                            that.right == this.right
    case _ => false
  }

  override def hashCode(): Int = (elem, left, right).##

  def canEqual(other: Any): Boolean = other.isInstanceOf[Branch[_]]
}
