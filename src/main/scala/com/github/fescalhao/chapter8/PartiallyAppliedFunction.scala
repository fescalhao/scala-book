//Functions and Closures

package com.github.fescalhao.chapter8

object PartiallyAppliedFunction extends App {
  val n = scala.util.Random.nextInt(10)
  println(s"N values is: $n")

  def sum(a: Int, b: Int, c: Int): Int = a+b+c

  val x = sum _
  println(x(2,2,n))

  val y = sum(2, _: Int, 4)
  println(y(n))
}