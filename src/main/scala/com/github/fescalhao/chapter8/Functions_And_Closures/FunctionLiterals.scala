//Functions and Closures

package com.github.fescalhao.chapter8.Functions_And_Closures

object FunctionLiterals extends App {

  // Test
  increase()

  // Example: increase()
  def increase(): Unit = {
    var increase: Int => Int = x => x + 1
    println(increase(10))

    println("-----------------")

    increase = x => {
      println("Function Literal")
      x + 2
    }
    println(increase(10))
  }
  // Example: foreach()
  def foreach(): Unit = {
    val list: List[Int] = List(-5,-2,4,5,7,9,12,54)
    list.foreach(x => println(x))
    println("-----------------")

    // Filter all values lesser than zero and then print them
    list.filter(x => x < 0).foreach(x => println(x))
    println("-----------------")

    // Using placeholder
    list.filter(_ < 0).foreach(println(_))
  }
}