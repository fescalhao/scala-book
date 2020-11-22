// Assertions and Tests

package com.github.fescalhao.chapter14

import com.github.fescalhao.chapter14.classes.MathOps

object Application extends App {
  val mathOps = new MathOps
  println(mathOps.divide(10, 0))
}
