package com.github.fescalhao.chapter26.Extractors.objects

object Twice {
  def apply(s: String): String = s + s

  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half.toLowerCase == s.substring(length).toLowerCase) Some(half) else None
  }
}
