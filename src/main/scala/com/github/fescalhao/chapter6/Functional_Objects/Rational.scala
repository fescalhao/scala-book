// Functional Objects

package com.github.fescalhao.chapter6.Functional_Objects

import scala.annotation.tailrec

class Rational(n: Int, d: Int) {
  require(d != 0, "You can't choose a value of ZERO for the Denominator")

  private val g = gcd(n.abs, d.abs)
  val num : Int = n / g
  val denom : Int = d / g

  def this(n: Int) = this(n,1)

  def +(rat: Rational) : Rational = {
    new Rational(
      this.num * rat.denom + rat.num * this.denom,
      this.denom * rat.denom
    )
  }

  def +(n: Int) : Rational = {
    new Rational(this.num + n * this.denom, this.denom)
  }

  def -(rat: Rational): Rational = {
    new Rational(
      this.num * rat.denom - rat.num * this.denom,
      this.denom * rat.denom
    )
  }

  def -(n: Int): Rational = {
    new Rational(this.num - n * this.denom, this.denom)
  }

  def *(rat: Rational) : Rational = {
    new Rational(
      this.num * rat.num,
      this.denom * rat.denom
    )
  }

  def *(n: Int) : Rational = {
    new Rational(this.num * n, this.denom)
  }

  def /(rat: Rational) : Rational = {
    new Rational(
      this.num * rat.denom,
      this.denom * rat.num
    )
  }

  def /(n: Int): Rational = {
    new Rational(this.num, this.denom * n)
  }

  def <(rat: Rational) : Boolean = {
      this.num * rat.denom < rat.num * this.denom
  }

  def >(rat: Rational) : Rational = {
    if (this.<(rat)) rat else this
  }

  // Greatest Common Divisor
  @tailrec
  private def gcd(n1: Int, n2: Int) : Int = {
    if (n2 == 0) n1 else gcd(n2, n1 % n2)
  }

  override def toString: String = s"${this.num}/${this.denom}"
}

