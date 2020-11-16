// Composition and Inheritance

package com.github.fescalhao.chapter10.impl

import com.github.fescalhao.chapter10.abs.Element

protected class UniformElement(
                      ch: Char,
                      override val height: Int,
                      override val width: Int,
                      spaces: Int
                    ) extends Element {

  def this(ch: Char, height: Int, width: Int) = this(ch, height, width, 0)

  private val line: String = if (spaces == 0) ch.toString * width else (ch.toString + ' ') * (width - 1) + ch.toString
  def contents: Array[String] = Array.fill(height)(line)
}
