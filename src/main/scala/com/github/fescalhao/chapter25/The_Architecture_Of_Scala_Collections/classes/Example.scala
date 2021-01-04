package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

class Example {

  def executeExamples(): Unit = {
    println("------------------------------ Capped ------------------------------")
    capped()
  }

  def capped(): Unit = {
    var capped = new Capped[Int](4)
    capped = capped :+ 1 :+ 5 :+ 2 :+ 6

    println(capped)
    println(s"length: ${capped.length}")
    println(s"lastOption: ${capped.lastOption}")
    println(s"take: ${capped.take(3)}")
  }
}
