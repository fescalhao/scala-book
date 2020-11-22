// Assertions and Tests

package com.github.fescalhao.chapter14.classes

class MathOps {
  def divide(n1: Double, n2: Double): Double = { n1 / n2 } ensuring(n2 > 0, "Choose a number greater than zero")
}
