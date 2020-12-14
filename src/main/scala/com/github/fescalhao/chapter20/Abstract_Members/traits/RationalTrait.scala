package com.github.fescalhao.chapter20.Abstract_Members.traits

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0, "Denominator can not be zero")
  private val g = gcd(numerArg, denomArg)
  val numer: Int = numerArg / g
  val denom: Int = denomArg / g
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  override def toString: String = {
    denom match {
      case 1 => s"$numer"
      case _ => s"$numer / $denom"
    }
  }

}