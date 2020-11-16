// Composition and Inheritance

package com.github.fescalhao.chapter10.impl

object ElementFactory {
  def elem(contents: Array[String]) = new ArrayElement(contents)

  def elem(ch: Char, height: Int, width: Int) = new UniformElement(ch, height, width)

  def elem(ch: Char, height: Int, width: Int, spaces: Int) = new UniformElement(ch, height, width, spaces)

  def elem(line: String) = new LineElement(line)
}
