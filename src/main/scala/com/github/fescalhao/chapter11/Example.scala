// Scala's Hierarchy

package com.github.fescalhao.chapter11

class Example {

  def comparison(): Unit = {
    val x = new String("abc")
    val y = new String("abc")

    println(s"x value: $x")
    println(s"y value: $y")
    println("------------")
    println(s"x == y: ${x == y}") // Comparing types
    println(s"x equals y: ${x equals y}") // Comparing types
    println(s"x eq y: ${x eq y}") // Comparing object reference
    println(s"x ne y: ${x ne y}") // Comparing object reference
  }

}
