// Composition and Inheritance

package com.github.fescalhao.chapter10.abs

import com.github.fescalhao.chapter10.impl.ElementFactory

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val thisWiden = this widen that.width
    val thatWiden = that widen this.width
    ElementFactory.elem(thisWiden.contents ++ thatWiden.contents)
  }

  def beside(that: Element): Element = {
    val thisHeighten = this heighten that.height
    val thatHeighten = that heighten this.height
    ElementFactory.elem(
      for ((l1, l2) <- thisHeighten.contents zip thatHeighten.contents) yield l1 + l2
    )
  }

  def widen(w: Int): Element = {
    if(w <= width) this
    else {
     val left = ElementFactory.elem(' ', height, (w - width) / 2)
     val right = ElementFactory.elem(' ', height, w - width - left.width)
     left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if(h <= height) this
    else {
      val top = ElementFactory.elem(' ', (h - height) / 2, width)
      val bottom = ElementFactory.elem(' ', h - height - top.height, width)
      top above this above bottom
    }
  }

  override def toString: String = contents mkString "\n"
}
