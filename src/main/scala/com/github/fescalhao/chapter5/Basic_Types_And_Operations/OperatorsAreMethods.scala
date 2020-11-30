// Basic Types and Operations

package com.github.fescalhao.chapter5.Basic_Types_And_Operations

import scala.language.postfixOps

object OperatorsAreMethods extends App {
  var sum : Int = 1 + 2
  println(sum)
  sum = 1.+(5)
  println(sum)

  val s = "Hello,world!"
  println(s indexOf 'o')
  println(s indexOf ('o', 5))

  println(s.toLowerCase)
  println(s toLowerCase)
}
