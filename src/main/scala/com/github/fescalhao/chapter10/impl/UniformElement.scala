package com.github.fescalhao.chapter10.impl

import com.github.fescalhao.chapter10.abs.Element

protected class UniformElement(
                      ch: Char,
                      override val height: Int,
                      override val width: Int
                    ) extends Element {

  private val line: String = ch.toString * width
  def contents: Array[String] = Array.fill(height)(line)
}
