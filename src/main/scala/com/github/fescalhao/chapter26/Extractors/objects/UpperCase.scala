package com.github.fescalhao.chapter26.Extractors.objects

object UpperCase {
  def unapply(s: String): Boolean = {
    s.toUpperCase == s
  }
}
