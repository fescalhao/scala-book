package com.github.fescalhao.chapter20.Abstract_Members.traits

import scala.annotation.tailrec

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  lazy val numer: Int = numerArg / g
  lazy val denom: Int = denomArg / g

  @tailrec
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString: String = {
    denom match {
      case 1 => s"$numer"
      case _ => s"$numer / $denom"
    }
  }
}
