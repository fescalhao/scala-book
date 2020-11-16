// Composition and Inheritance

package com.github.fescalhao.chapter10

import com.github.fescalhao.chapter10.abs.Element
import com.github.fescalhao.chapter10.impl.ElementFactory.elem

object Application extends App {

  println(test())

  def spiral(edges: Int, direction: Int): Element = {
    val space = elem(" ")
    val corner = elem("+")

    if (edges == 1) {
      corner
    } else {
      val sp = spiral(edges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', sp.height, 1)
      def horizontalBar = elem('-', 1, sp.width)

      if (direction == 0) {
        (corner beside horizontalBar) above (sp beside space)
      } else if (direction == 1) {
        (sp above space) beside (corner above verticalBar)
      } else if (direction == 2) {
        (space beside sp) above (horizontalBar beside corner)
      } else {
        (verticalBar above corner) beside (space above sp)
      }
    }
  }

  def triangle(layers: Int): Element = {
    val space = elem(" ")

    if (layers == 1) {
      space beside elem("*")
    } else {
      val layer = elem('*', 1, layers, 1)
      def tr = triangle(layers - 1)
      space beside (tr above layer)
    }
  }

  def square(size: Int): Element = {
   elem('@', size, size, 1)
  }

  def test(): Element = {
    val elem1 = elem(Array("hello", "world"))
    val elem2 = elem(Array("ping", "pong"))
    elem1 above elem2
  }
}
