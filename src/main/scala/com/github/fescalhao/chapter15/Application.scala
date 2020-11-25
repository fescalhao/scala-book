// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15

import com.github.fescalhao.chapter15.classes.{BinOp, Expr, Number, UnOp, Var}

object Application extends App {

  val expr = UnOp("+", UnOp("abs", Var("x")))

  println(simplifyTop(expr))
  checkOpKind(expr)
  println(describe(5))
  println(isPi)
  println(isList(expr))
  println(generalSize(List(1, 2, 3)))
  checkArgumentType()
  println(describe2(Number(2)))

  def simplifyTop(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("+", e, Number(1)) => e
      case _ => expr
    }
  }

  def simplifyAll(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", e)) => simplifyAll(e)
      case BinOp("+", e, Number(0)) => simplifyAll(e)
      case BinOp("*", e, Number(1)) => simplifyAll(e)
      case UnOp(op, e) => UnOp(op, simplifyAll(e))
      case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case _ => expr
    }
  }

  def checkOpKind(expr: Expr): Unit = {
    expr match {
      case BinOp(_, _, _) => println("It's a binary operation")
      case UnOp(_, _) => println("It's a unary operation")
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
      case m: Map[_, _] /*or Map[k,v]*/ => m.size
      case l: List[Any] => l.size
      case a: Array[Any] => a.length
      case _ => -1
    }
  }

  def checkArgumentType(): Unit = {
    val intMap = Map[Int, Int](1 -> 1)
    val stringMap = Map[String, String]("abc" -> "abc")
    val intArray = Array(1, 2, 3, 4)
    val stringArray = Array("a", "b", "c", "d")

    // Argument type is not checked in pattern matching
    println(isIntIntMap(intMap))
    println(isIntIntMap(stringMap))

    // The only exception is for Array since arrays store their element type within them
    println(isIntArray(intArray))
    println(isIntArray(stringArray))

    def isIntIntMap(x: Any): Boolean = {
      x match {
        case m: Map[Int, Int] => true
        case _ => false
      }
    }

    def isIntArray(x: Any): Boolean = {
      x match {
        case a: Array[Int] => true
        case _ => false
      }
    }
  }

  def simplifyAdd(expr: Expr): Expr = {
    expr match {
      case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
      case _ => expr
    }
  }

  def describe2(expr: Expr): String = {
    expr match {
      case Number(_) => "It's a number"
      case Var(_) => "It's a variable"
    }
  }
}
