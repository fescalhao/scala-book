// Basic Types and Operations

package com.github.fescalhao.chapter5.Basic_Types_And_Operations

object Operations extends App {

  // Test
  precedenceAndAssociativity()

  // Example: arithmetic()
  def arithmetic(): Unit = {
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

  // Example: relationalAndLogical()
  def relationalAndLogical(): Unit = {
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

  // Example: bitwise()
  def bitwise(): Unit = {
    println(1 & 2)
    println(1 | 2)
    println(1 ^ 3)
    println(~1)

    println(-1 >> 31)
    println(-1 >>> 31)
    println(-1 << 31)
  }

  // Example: objectEquality()
  def objectEquality(): Unit = {
    println(1 == 2)
    println(1 != 2)
    println(2 == 2)
    println(List(1, 2, 3) == List(1, 2, 3))
    println(List(1, 2, 3) == List(1, 2, 4))
    println(1 == 1.0)
    println(List(1, 2, 3) == "hello")
    println(List(1, 2, 3) == null)
    println(("hel" + "lo") == "hello")
  }

  def precedenceAndAssociativity(): Unit = {
    println(2 + 2 * 7)
    println((2 + 2) * 7)
    println(2 << 2 + 2)
    println(2 + 2 << 2)
    println(1 :: 2 :: Nil)
    println(Nil.::(2).::(1)) // Same as above
  }
}