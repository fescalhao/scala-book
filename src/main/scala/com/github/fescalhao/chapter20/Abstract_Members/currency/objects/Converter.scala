package com.github.fescalhao.chapter20.Abstract_Members.currency.objects

object Converter {
  val exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0, "EUR" -> 0.7596, "JPY" -> 1.211),
    "EUR" -> Map("EUR" -> 1.0, "USD" -> 1.316, "JPY" -> 1.594),
    "JPY" -> Map("JPY" -> 1.0, "USD" -> 0.8257, "EUR" -> 0.6272)
  )
}
