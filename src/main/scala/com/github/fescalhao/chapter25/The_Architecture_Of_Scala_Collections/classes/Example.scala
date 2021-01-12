package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

class Example {

  def executeExamples(): Unit = {
    println("------------------------------ Capped ------------------------------")
    capped()
    println("-------------------------------- RNA -------------------------------")
    rna()
  }

  def capped(): Unit = {
    var capped = new Capped[Int](4)
    capped = capped :+ 1 :+ 5 :+ 2 :+ 6

    println(capped)
    println(s"length: ${capped.length}")
    println(s"lastOption: ${capped.lastOption}")
    println(s"take: ${capped.take(3)}")
  }

  def rna(): Unit = {
    val rna = RNA(A, U, G, U, C, G, A, C)

    println(rna)
    println(s"length: ${rna.length}")
    println(s"lastOption: ${rna.filter(_ != G)}")
    println(s"take: ${rna.take(3)}")
  }
}
