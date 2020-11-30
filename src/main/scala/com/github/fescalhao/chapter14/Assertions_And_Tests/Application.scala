// Assertions and Tests

package com.github.fescalhao.chapter14.Assertions_And_Tests

import com.github.fescalhao.chapter14.Assertions_And_Tests.classes.MathOps

object Application extends App {
  val mathOps = new MathOps
  println(mathOps.divide(10, 0))
}
