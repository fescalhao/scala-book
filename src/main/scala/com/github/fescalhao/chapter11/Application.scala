// Scala's Hierarchy

package com.github.fescalhao.chapter11

import com.github.fescalhao.chapter11.classes.html.HtmlFactory
import com.github.fescalhao.chapter11.classes.{Dollar, Example}

object Application extends App {
  val example = new Example
  example.comparison()

  val money = new Dollar(15.54)
  println(money.amount)
  println(money)

  println(HtmlFactory.title("chap:cls", "bold", "Value Classes"))

}
