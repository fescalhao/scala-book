package com.github.fescalhao.chapter3

object examples extends App {
  param_example()

//  --------------------------------- Parameterize arrays with types ---------------------------------
  // Example: param_example()
  def param_example() = {
    val greetings = new Array[String](3)
    greetings(0) = "Hello"
    greetings(1) = ","
    greetings(2) = "World!"

    greetings.foreach(x => println(x))
    // OR
    for(i <- 0 to 2) {
      println(greetings(i))
    }
  }
}
