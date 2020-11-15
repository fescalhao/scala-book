package com.github.fescalhao.chapter10.abs

import com.github.fescalhao.chapter10.impl.ElementFactory

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    ElementFactory.elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    ElementFactory.elem(
      for ((l1, l2) <- this1.contents zip that1.contents) yield l1 + l2
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
