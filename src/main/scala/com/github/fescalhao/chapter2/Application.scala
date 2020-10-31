package com.github.fescalhao.chapter2

object Application extends App {

  for_example(Array("a","b","c"))

// ------------------------------- Val/Var -------------------------------
  // Example: val_var()
  def val_var = {
    // You can't reassign val variables
    val msg = "Hello World"
    println(msg)
    //  msg = "Again" produces an error

    // You can reassign var variables
    var msg2 = "WoW"
    msg2 = "Such programming!"
    println(msg2)
  }
// ------------------------------------------------------------------------

// ------------------------------- Function -------------------------------
  // Parameter type is required
  // Example: println(max(4,6))
  def max(x: Int, y: Int): Int = {
    if(x>y) x else y
  }

  // Scala's Unit type corresponds to Void type in Java
  // Example: greet()
  def greet() = {
    println("Hello")
  }
// ------------------------------------------------------------------------

// --------------------------------- Loop ---------------------------------
  // While
  // Example: while_example(10)
  def while_example(num: Int) = {
    var i = 0
    while (i < num) {
      println(s"Number: ${num}")
      i += 1
    }
  }

  // Foreach
  // Example: foreach_example(Array("a","b","c"))
  def foreach_example(args: Array[String]) = {
    args.foreach((arg: String) => println(arg))
  }

  // For
  // Example: for_example(Array("a","b","c"))
  def for_example(args: Array[String]) = {
    // arg is a val not a var
    for(arg <- args) {
      println(arg)
    }
  }

}



