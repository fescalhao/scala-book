// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15.Case_Classes_And_Pattern_Matching.classes

import com.github.fescalhao.chapter10.Composition_And_Inheritance.abs.Element
import com.github.fescalhao.chapter10.Composition_And_Inheritance.impl.ElementFactory

class ExprFormatter {
  private val opGroups = Array(
    Set("|", "||"),
    Set("&", "&&"),
    Set("^"),
    Set("==", "!="),
    Set("<", "<=", ">=", ">"),
    Set("+", "-"),
    Set("*", "/")
  )

  private val precedence = {
    val assocs = {
      for {
        i <- opGroups.indices
        op <- opGroups(i)
      } yield op -> i
    }
    assocs.toMap
  }

  private val unaryPrecedence = opGroups.length
  private val fractionalPrecedence = -1

  private def format(e: Expr, enclPrec: Int): Element = {
    e match {
      case Var(name) => ElementFactory.elem(name)

      case Number(num) =>
        def stripDot(s:String) =
          if (s endsWith ".0")
            s.substring(0, s.length - 2)
          else
            s
        ElementFactory.elem(stripDot(num.toString))

      case UnOp(operator, arg) => ElementFactory.elem(operator) beside format(arg, unaryPrecedence)

      case BinOp("/", left, right) =>
        val top = format(left, fractionalPrecedence)
        val bot = format(right, fractionalPrecedence)
        val line = ElementFactory.elem('-', 1, top.width max bot.width)
        val frac = top above line above bot
        if (enclPrec != fractionalPrecedence) frac
        else ElementFactory.elem(" ") beside frac beside ElementFactory.elem(" ")

      case BinOp(operator, left, right) =>
        val opPrec = precedence(operator)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside ElementFactory.elem(s" $operator ") beside r
        if (enclPrec <= opPrec) oper
        else ElementFactory.elem("(") beside oper beside ElementFactory.elem(")")
    }
  }

  def format(e: Expr): Element = format(e, 0)
}
