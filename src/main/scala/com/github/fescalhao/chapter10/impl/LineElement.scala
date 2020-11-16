// Composition and Inheritance

package com.github.fescalhao.chapter10.impl

import com.github.fescalhao.chapter10.abs.Element

protected class LineElement(s: String) extends Element{
  val contents: Array[String] = Array(s)
  override def height: Int = 1
  override def width: Int = s.length
}
