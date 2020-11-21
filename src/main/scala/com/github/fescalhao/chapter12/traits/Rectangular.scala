// Traits

package com.github.fescalhao.chapter12.traits

import com.github.fescalhao.chapter12.classes.Point

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left: Int = topLeft.x
  def right: Int = bottomRight.x
  def top: Int = topLeft.y
  def bottom: Int = bottomRight.y

  def width: Int = right - left
  def height: Int = top - bottom
}
