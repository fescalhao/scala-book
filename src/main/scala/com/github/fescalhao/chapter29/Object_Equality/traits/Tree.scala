package com.github.fescalhao.chapter29.Object_Equality.traits

trait Tree[+T] {
  def elem: T
  def left: Tree[T]
  def right: Tree[T]
}
