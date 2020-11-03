// Control Abstraction

package com.github.fescalhao.chapter9

object Exists extends App {
  val numList: List[Int] = List(1,2,3,4,5,6)
  println(isOdd(numList))
  println(containsNeg(numList))

  def matchera(op: Int => Boolean, item: Int): Boolean = op(item)

  def exists(list: List[Int], matcher: Int => Boolean):List[Int] = {
    for (item <- list if matcher(item)) yield item
  }

  def isOdd(list: List[Int]): List[Int] = {
      exists(list, _ % 2 == 1)
  }

  def containsNeg(list: List[Int]): Boolean = {
    exists(list, _ < 0).nonEmpty
  }
}
