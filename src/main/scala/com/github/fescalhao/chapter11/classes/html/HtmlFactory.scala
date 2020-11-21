// Scala's Hierarchy

package com.github.fescalhao.chapter11.classes.html

object HtmlFactory {
  def title(anchor: String, style: String, text: String) : Html = {
    val html = new Html()
    html.title(new Anchor(anchor), new Style(style), new Text(text))
  }
}
