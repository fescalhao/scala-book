// Control Abstraction

package com.github.fescalhao.chapter9

object Twice extends App {
  def twice(op: Double => Double, x: Double): Double = op(op(x))
  println(twice(_ + 2, 5))
}
