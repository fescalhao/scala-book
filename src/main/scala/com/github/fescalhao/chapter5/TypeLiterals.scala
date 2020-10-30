// Basic Types and Operations

package com.github.fescalhao.chapter5

object TypeLiterals extends App {

  // Test
  stringLiterals()

  // Example: integerLiterals()
  def integerLiterals(): Unit = {
    val integerLiterals = (
    "0x5 (Int)" -> 0x5,
    "0xcafebabe (Int)" -> 0xcafebabe,
    "31 (Int)" -> 31,
    "35L (Long)" -> 35L,
    "1.2345 (Double)" -> 1.2345,
    "1.2345e1 (Double | e1 = pow(10,1))" -> 1.2345e1,
    "1.2345e4 (Double | e4 = pow(10,4))" -> 1.2345e4,
    "1.2345F (Float)" -> 1.2345F,
    "3e5f (Float)" -> 3e5f,
    "3e5 (Double)" -> 3e5,
    "3e5D (Double)" -> 3e5D
    )

    integerLiterals
      .productIterator
      .map(_.asInstanceOf[(String, AnyVal)])
      .foreach(x => println(x._1 + ": " + x._2))
  }

  // Example: characterLiterals()
  def characterLiterals(): Unit = {
    val characterLiterals = (
      "A (Char)" -> 'A',
      "D (Char)" -> '\u0044',
      "\\ (Char)" -> '\\'
    )

    characterLiterals
      .productIterator
      .map(_.asInstanceOf[(String, Char)])
      .foreach(x => println(x._1 + ": " + x._2))
  }

  // Example: stringLiterals()
  def stringLiterals(): Unit = {

    println("hello")
    println("\\\"\'")
    println("""Raw String! " and \ are not escaped.
            We have linebreaks too""")
    println("""|Raw String! " and \ are not escaped.
               |We have linebreaks too""".stripMargin)
  }

  // Example: booleanLiterals()
  def booleanLiterals(): Unit = {
    println(true)
    println(false)
  }
}
