//Functions and Closures

package com.github.fescalhao.chapter8.Functions_And_Closures

object SpecialFunction extends App {

  // Test
  boom(10)

  // Example1: repeatedParams("a", "b", "c", "d")
  // Example2: val seq = Seq("a", "b", "c", "d")
  //           repeatedParams(seq: _*)
  def repeatedParams(args: String*): Unit = {
    for (arg <- args)
      println(arg)
  }
  // Example: namedArguments(100, 10) | namedArguments(time = 10, distance = 10)
  def namedArguments(distance: Float, time: Float): Float = {
    distance / time // speed = distance / time
  }
  /*
  Example: defaultParams() |
           defaultParams(3) |
           defaultParams(num = 3) |
           defaultParams(denom = 3) |
           defaultParams(num = 10, denom = 2) |
           defaultParams(10, 2)
  */
  def defaultParams(num: Int = 1, denom: Int = 1): Unit = {
    require(denom != 0, "Denominator can't be zero")
    println(num / denom)
  }

  def boom(x: Int): Int = {
    if (x == 0) throw new Exception("Boom!")
    else {
      println(x)
      boom(x - 1)
    }
  }
}
