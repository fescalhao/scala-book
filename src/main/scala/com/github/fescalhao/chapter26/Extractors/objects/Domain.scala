package com.github.fescalhao.chapter26.Extractors.objects

object Domain {
  // The injection method (optional)
  def apply(parts: String*): String = {
    parts.reverse.mkString(".")
  }

  // The extraction method (mandatory)
  def unapplySeq(whole: String): Option[Seq[String]] = {
    Some(whole.split("\\.").reverse.toSeq)
  }
}
