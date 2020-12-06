package com.github.fescalhao.chapter19.Type_Parameterization

import com.github.fescalhao.chapter19.Type_Parameterization.classes.Queue

object Application extends App {
  val list1 = Queue(1, 2, 3, 4, 5, 6)
  println(list1.head)
  println(list1.tail)
  println(list1.enqueue(6))
}
