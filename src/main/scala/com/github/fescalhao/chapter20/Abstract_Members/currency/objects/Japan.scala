package com.github.fescalhao.chapter20.Abstract_Members.currency.objects

import com.github.fescalhao.chapter20.Abstract_Members.currency.classes.abs.AbstractCurrencyZone

object Japan extends AbstractCurrencyZone {
  abstract class Yen extends AbstractCurrency {
    override def designation: String = "JPY"
  }
  override type Currency = Yen
  override def make(yen: Long): Yen = {
    new Yen {
      override val amount: Long = yen
    }
  }
  val Yen: Yen = make(1)
  override val CurrencyUnit: Yen = Yen
}
