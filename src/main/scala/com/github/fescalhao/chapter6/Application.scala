// Functional Objects

package com.github.fescalhao.chapter6

object Application extends App {
  val r1 = new Rational(10, 15)
  val r2 = new Rational(4, 30)
  val r3 = new Rational(15, 6)
  println(r1)
  println(r1 + r2)
  println(r1 + 5)
  println(r1 < r3)
  println(r1 + r1 * r2)
  println(2 * r1) // It works because of intToRational(n: Int)

  implicit def intToRational(n: Int): Rational = new Rational(n)
}

