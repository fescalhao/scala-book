package com.github.fescalhao.chapter26.Extractors.objects

object ExtendedEmail {
  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1).split("\\.").reverse.toSeq)
    } else {
      None
    }
  }
}
