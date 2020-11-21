// Traits

package com.github.fescalhao.chapter12.classes

import com.github.fescalhao.chapter12.traits.Rectangular

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  def topRight: Point = new Point(bottomRight.x, topLeft.y)
  def bottomLeft: Point = new Point(topLeft.x, bottomRight.y)

  override def toString: String = Array(s"Top point on the left: $topLeft",
                                        s"Top point on the right: $topRight",
                                        s"Bottom point on the left: $bottomLeft",
                                        s"Bottom point on the right: $bottomRight").mkString("\n")
}
