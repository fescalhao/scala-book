// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15

import com.github.fescalhao.chapter15.classes.{BinOp, Examples, Expr, ExprFormatter, Number, UnOp, Var}

object Application extends App {

  val example = Examples()
//  example.executeExamples()

  val f = new ExprFormatter

  val e1 = BinOp(
    "*",
    BinOp("+", Var("x"), Number(1)),
    BinOp("/", Number(1), Number(2)),
  )

  val e2 = BinOp(
    "+",
    BinOp("/", Var("x"), Number(2)),
    BinOp("/", Number(1.5), Var("x"))
  )

  val e3 = BinOp("/", e1, e2)

  def show(expr: Expr) = s"${println(f.format(expr))}\n\n"

  for (e <- Array(e1, e2, e3))
    show(e)
}
