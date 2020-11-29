// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15.classes

class Examples() {

  def executeExamples(): Unit = {
    val expr = UnOp("+", UnOp("abs", Var("x")))

    println(simplifyTop(expr))
    println("-------------------")
    println(simplifyAll(expr))
    println("-------------------")
    checkOpKind(expr)
    println("-------------------")
    println(describe(5))
    println("-------------------")
    println(isPi)
    println("-------------------")
    println(isList(expr))
    println("-------------------")
    println(generalSize(List(1, 2, 3)))
    println("-------------------")
    checkArgumentType()
    println("-------------------")
    println(describe2(Number(2)))
    println("-------------------")
    capitals()
    println("-------------------")
    variablePatter()
    println("-------------------")
    caseSequences()
    println("-------------------")
    forPattern()
  }

  private def simplifyTop(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("+", e, Number(1)) => e
      case _ => expr
    }
  }

  private def simplifyAll(expr: Expr): Expr = {
    expr match {
      case UnOp("-", UnOp("-", e)) => simplifyAll(e)
      case BinOp("+", e, Number(0)) => simplifyAll(e)
      case BinOp("*", e, Number(1)) => simplifyAll(e)
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case UnOp(op, e) => UnOp(op, simplifyAll(e))
      case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
      case _ => expr
    }
  }

  private def checkOpKind(expr: Expr): Unit = {
    expr match {
      case BinOp(_, _, _) => println("It's a binary operation")
      case UnOp(_, _) => println("It's a unary operation")
      case _ => println("Operation not recognized")
    }
  }

  private def describe(x: Any): String = {
    x match {
      case 5 => "five"
      case true => "true"
      case "hello" => "hi!"
      case Nil => "empty list"
      case _ => "something else"
    }
  }

  private def isPi: String = {
    val pi = math.Pi
    math.E match {
      case `pi` => s"strange math? Pi = $pi"
      case _ => "OK"
    }
  }

  private def isList(x: Any): String = {
    x match {
      case List(_*) => "Found a List!"
      case _ => "Not yet!"
    }
  }

  private def generalSize(x: Any): Int = {
    x match {
      case s: String => s.length
      case m: Map[_, _] /*or Map[k,v]*/ => m.size
      case l: List[Any] => l.size
      case a: Array[Any] => a.length
      case _ => -1
    }
  }

  private def checkArgumentType(): Unit = {
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

  private def simplifyAdd(expr: Expr): Expr = {
    expr match {
      case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
      case _ => expr
    }
  }

  // Gives us a compiler warning that not every possible match is present. It happens because the abstract class Expr is sealed. (sealed abstract class Expr)
  private def describe2(expr: Expr): String = {
    (expr: @unchecked) match {
      case Number(_) => "It's a number"
      case Var(_) => "It's a variable"
    }
  }

  private def capitals(): Unit ={
    val capitals: Map[String,String] = Map("France" -> "Paris", "Japan" -> "Tokyo")

    println(show(capitals get "Japan"))
    println(show(capitals get "North Pole"))

    def show(key: Option[String]): String = {
      key match {
        case Some(s) => s
        case None => "?"
      }
    }
  }

  private def variablePatter(): Unit = {
    val myTuple = (123, "abc")
    val (myNumber, myString) = myTuple
    println(myTuple)
    println(myNumber)
    println(myString)

    // Usable with Case Classes
    val myExpr = UnOp("abs", Var("x"))
    val UnOp(op, value) = myExpr
    println(myExpr)
    println(op)
    println(value)
  }

  private def caseSequences(): Unit = {
    val withDefault: Option[Int] => Int = {
      case Some(i) => i
      case None => 0
    }

    println(withDefault(Some(10)))
    println(withDefault(None))

    val second: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }

    val list = List()
    if (second.isDefinedAt(list))
      println(second(list))
  }

  private def forPattern(): Unit = {
    val capitals: Map[String,String] = Map("France" -> "Paris", "Japan" -> "Tokyo")
    for ((country, city) <- capitals)
      println(s"The capital of $country is $city")

    val fruits = List(Some("Orange"), None, Some("Apple"))
    for (fruit <- fruits) {
      println(fruit)
    }
  }
}
