package com.github.fescalhao.chapter30.Object_Equality.objects

import com.github.fescalhao.chapter30.Object_Equality.traits.Tree

object EmptyTree extends Tree[Nothing]{
  override def elem: Nothing = throw new NoSuchElementException("EmptyTree.elem")

  override def left: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.left")

  override def right: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.right")
}
