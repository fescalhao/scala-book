package com.github.fescalhao.chapter19.Type_Parameterization.traits

trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >: T](elem: U): Queue[U]
}
