// Basic Types and Operations

package com.github.fescalhao.chapter5


object Operations extends App {

  // Test
  RelationalAndLogical()

  // Example: Arithmetic()
  def Arithmetic(): Unit = {
    println(1.2 + 2.3)
    println(3 - 1)
    println('c' - 'a')
    println(2L * 3L)
    println(11 / 4)
    println(11 % 4)
    println(11.0f / 4.0f)
    println(11.0f % 4.0f)
    println(1 + -3)
    println(+3)
    println(-(1 + -3))
  }

  // Example: RelationalAndLogical()
  def RelationalAndLogical() : Unit = {
    val toBe = true

    println(1 > 2)
    println(1 < 2)
    println(1.0 <= 1.0)
    println(3.5f >= 3.6f)
    println('a' >= 'A')
    println(!(1 < 2))

    println(toBe || !toBe)
    println(toBe && !toBe)
  }

  // Example: Bitwise
  def Bitwise() : Unit = {
    println(1 & 2)
    println(1 | 2)
    println(1 ^ 3)
    println(~1)
  }
}
