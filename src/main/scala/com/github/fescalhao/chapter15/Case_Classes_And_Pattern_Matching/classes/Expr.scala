// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15.Case_Classes_And_Pattern_Matching.classes

sealed abstract class Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class Number(num: Double) extends Expr
case class Var(name: String) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
