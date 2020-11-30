// Scala's Hierarchy

package com.github.fescalhao.chapter11.Scalas_Hierarchy

import com.github.fescalhao.chapter11.Scalas_Hierarchy.classes.{Dollar, Example}
import com.github.fescalhao.chapter11.Scalas_Hierarchy.classes.html.HtmlFactory

object Application extends App {
  val example = new Example
  example.comparison()

  val money = new Dollar(15.54)
  println(money.amount)
  println(money)

  println(HtmlFactory.title("chap:cls", "bold", "Value Classes"))

}
