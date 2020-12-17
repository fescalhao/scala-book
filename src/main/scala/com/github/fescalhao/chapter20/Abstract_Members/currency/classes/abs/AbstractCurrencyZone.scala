package com.github.fescalhao.chapter20.Abstract_Members.currency.classes.abs

import com.github.fescalhao.chapter20.Abstract_Members.currency.objects.Converter

abstract class AbstractCurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  val CurrencyUnit: Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def +(that: Currency): Currency = { make(this.amount + that.amount) }
    def *(value: Double): Currency = { make((this.amount * value).toLong) }
    def -(that: Currency): Currency = { make(this.amount - that.amount) }
    def /(value: Double): Currency = { make((this.amount / value).toLong) }
    def /(that: Currency): Double = { this.amount.toDouble / that.amount }

    def from(other: AbstractCurrencyZone#AbstractCurrency): Currency = {
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)
      ))
    }

    private def decimals(n: Long): Int = {
      if (n == 1) 0 else 1 + decimals(n / 10)
    }

    override def toString: String = {
      ((amount.toDouble / CurrencyUnit.amount.toDouble)
        formatted ("%." + decimals(CurrencyUnit.amount) + "f")
        + " " + designation)
    }
  }
}
