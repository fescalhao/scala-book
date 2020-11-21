// Scala's Hierarchy

package com.github.fescalhao.chapter11.classes.html

protected class Html(val value: String = "") extends AnyVal {
  def title(anchor: Anchor, style: Style, text: Text) : Html = {
    new Html(
      s"<a id='${anchor.value}'>" +
        s"<h1 class='${style.value}'>" +
        text.value +
        "</h1></a>"
    )
  }
  override def toString: String = value
}
