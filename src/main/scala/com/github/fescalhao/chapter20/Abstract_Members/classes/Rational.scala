package com.github.fescalhao.chapter20.Abstract_Members.classes

import com.github.fescalhao.chapter20.Abstract_Members.traits.RationalTrait

class Rational(val n: Int, val d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {
  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }
}
