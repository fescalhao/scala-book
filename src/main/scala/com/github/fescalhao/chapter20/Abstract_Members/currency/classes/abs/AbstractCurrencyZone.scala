package com.github.fescalhao.chapter20.Abstract_Members.currency.classes.abs

abstract class AbstractCurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  val CurrencyUnit: Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def +(that: Currency): Currency = { make(this.amount + that.amount) }
    def *(value: Double): Currency = { make((this.amount * value).toLong) }
    override def toString: String = s"$amount $designation"
  }
}
