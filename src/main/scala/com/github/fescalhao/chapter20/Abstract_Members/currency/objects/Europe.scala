package com.github.fescalhao.chapter20.Abstract_Members.currency.objects

import com.github.fescalhao.chapter20.Abstract_Members.currency.classes.abs.AbstractCurrencyZone

object Europe extends AbstractCurrencyZone {
  abstract class Euro extends AbstractCurrency {
    override def designation: String = "EUR"
  }
  type Currency = Euro
  def make(cents: Long): Euro = {
    new Euro {
      override val amount: Long = cents
    }
  }
  val Cent: Euro = make(1)
  val Euro: Euro = make(100)
  val CurrencyUnit: Euro = Euro
}
