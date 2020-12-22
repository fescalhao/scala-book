// Built-in Control Structures

package com.github.fescalhao.chapter7.Built_in_Control_Structures

import java.io.File

object Application extends App {

  // Test
  println(nestedLoop())

  // Example: ifExample()
  def ifExample() = {
    val num = math.random() * 10
    val s = if (num < 5)
              "Lesser than 5"
            else if (num > 5)
              "Greater than 5"
            else
              "Equals to 5"
    s
  }
  // Example: gcdLoop(10,5)
  def gcdLoop(n1: Long, n2: Long): Long = {
    var a = n1
    var b = n2
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
  // Example: listFiles()
  def listFiles() : Unit = {
    val files = new File(".").listFiles()
    for (file <- files)
      println(file)
  }
  // Example: forWithRange
  def forWithRange(): Unit = {
    // 1 to 5
    for (i <- 1 to 5)
      println(s"Iteration: $i")

    println("------------------------")

    // 1 to 4
    for (i <- 1 until 5)
      println(s"Iteration: $i")
  }
  //Example: filterList()
  def filterList(): Unit = {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    for (num <- list if num % 2 == 0)
      println(num)
  }
  // Example: nestedLoop() | nestedLoop(true | false)
  def nestedLoop(functional: Boolean = true): List[Int] = {
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    val nestedList: List[List[Int]] = List(list1,list2)

    if (functional)
      // functional style
      for {
            list <- nestedList // nested loop
            num <- list // nested loop
            isEven = num % 2 == 0 // variable assigned inside the for expression
            if isEven // filter the result based on the variable 'isEven'
      } yield {num: Int}
    else {
      // the above code does the same as the imperative style bellow
      var otherList: List[Int] = List()
      for (list <- nestedList) {
        for (num <- list) yield {
          val isEven = num % 2 == 0
          if (isEven) {
            otherList = num :: otherList
          }
        }
      }
      otherList.sortWith((n1,n2) => n1 < n2): List[Int]
    }
  }
  // Example: tryCatch()
  def tryCatch(): Unit = {
    val n: Int = 16
    val half =
      if (n % 2 == 0)
        n / 2
      else
        throw new RuntimeException("n must be even")
    println(half)

    val d = 0
    val div =
      try {
        n / d
      } catch {
        case _: ArithmeticException => s"Can't divide $n by $d"
      } finally {
        println(s"n = $n and d = $d")
      }
    println(div)
  }
  // Example: tryFinallyWithReturn()
  def tryFinallyWithReturn(): Int = {
    try 1 finally return 2
  }
  // Example: tryFinally()
  def tryFinally(): Int = {
    try 1 finally 2
  }

  // Example: matchExample(5)
  def matchExample(n: Int): Unit = {
    val choice =
      n match {
        case 0 => "Zero"
        case 1 => "One"
        case 2 => "Two"
        case 3 => "Three"
        case _ => "I can only count to 3"
      }

    println(choice)
  }

  def imperativeStyle(): Unit = {
    var i = 1

    while (i <= 10) {
      var j = 1

      while (j <= 10) {
        val prod = (i * j).toString
        var k = prod.length

        while (k < 4) {
          print(" ")
          k += 1
        }

        print(prod)
        j += 1
      }

      println()
      i += 1
    }
  }

  def functionalStyle(): Unit = {

    def makeRowSeq(row: Int): Seq[String] = {
      for {col <- 1 to 10} yield {
        val prod = (col * row).toString
        val padding = " " * (4 - prod.length)
        padding + prod
      }
    }

    def makeRow(row: Int): String = makeRowSeq(row).mkString

    val tableSeq: Seq[String] =
      for {row <- 1 to 10}
        yield makeRow(row)

    println(tableSeq.mkString("\n"))
  }
}
