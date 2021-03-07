package com.github.fescalhao.chapter30.Object_Equality.traits

trait Tree[+T] {
  def elem: T
  def left: Tree[T]
  def right: Tree[T]
}
