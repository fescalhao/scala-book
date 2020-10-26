// Basic Types and Operations

package com.github.fescalhao.chapter5

object StringInterpolation extends App{
  val name = "Felipe"
  // Curly braces are optional with a sigle variable but required when you have an expression
  println(s"Hello, ${name}!")

  println(s"The answer is ${5*6}")

  // Raw does not recognize escape characters
  println(raw"No\\\\escape!")

  val pi = f"${math.Pi}%.5f"
  println(pi)
}
