// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15

import com.github.fescalhao.chapter15.classes.abs.Expr
import com.github.fescalhao.chapter15.classes.impl.{BinOp, Number, UnOp, Var}

object Application extends App {

  val expr = BinOp("+", Var("x"), Number(3))

  println(simplifyTop(expr))
  checkOpKind(expr)
  println(describe(5))
  println(isPi)
  println(isList(expr))
  println(generalSize(List(1,2,3)))

  def simplifyTop(expr: Expr) : Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("+", e, Number(1)) => e
    case _ => expr
  }

  def checkOpKind(expr: Expr): Unit = {
    expr match {
      case BinOp(_,_,_) => println("It's a binary operation")
      case UnOp(_,_) => println("It's a unary operation")
      case _ => println("Operation not recognized")
    }
  }

  def describe(x: Any): String = {
    x match {
      case 5 => "five"
      case true => "true"
      case "hello" => "hi!"
      case Nil => "empty list"
      case _ => "something else"
    }
  }

  def isPi: String = {
    val pi = math.Pi
    math.E match {
      case `pi` => s"strange math? Pi = $pi"
      case _ => "OK"
    }
  }

  def isList(x: Any): String = {
    x match {
      case List(_*) => "Found a List!"
      case _ => "Not yet!"
    }
  }

  def generalSize(x: Any): Int = {
    x match {
      case s: String => s.length
      case m: Map[_,_] /*or Map[k,v]*/ => m.size
      case l: List[Any] => l.size
      case a: Array[Any] => a.length
      case _ => -1
    }
  }
}
