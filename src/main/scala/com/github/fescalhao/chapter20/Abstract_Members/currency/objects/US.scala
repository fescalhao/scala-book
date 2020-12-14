package com.github.fescalhao.chapter20.Abstract_Members.currency.objects

import com.github.fescalhao.chapter20.Abstract_Members.currency.classes.abs.AbstractCurrencyZone

object US extends AbstractCurrencyZone {

  abstract class Dollar extends AbstractCurrency {
    override def designation: String = "USD"
  }
  override type Currency = Dollar
  override def make(cents: Long): Dollar = {
    new Dollar {
      override val amount: Long = cents
    }
  }
  val Cent: Currency = make(1)
  val Dollar: Currency = make(100)
  val CurrencyUnit: Dollar = Dollar

}
