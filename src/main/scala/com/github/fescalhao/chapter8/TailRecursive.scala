//Functions and Closures

package com.github.fescalhao.chapter8

object TailRecursive extends App {
  // Test
  bang(3)

  // Not optimized! It's not tail recursive because it performs an increment operation after the recursive call
  def boom(x: Int): Int = {
    if (x == 0) throw new Exception("Boom!")
    else {
      println(x)
      boom(x - 1) + 1
    }
  }

  // Optimized! The last operation is the recursive call
  def bang(x: Int): Int = {
    if (x == 0) throw new Exception("Bang!")
    else {
      println(x)
      bang(x - 1)
    }
  }
}
