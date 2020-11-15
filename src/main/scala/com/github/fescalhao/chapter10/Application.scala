package com.github.fescalhao.chapter10

import com.github.fescalhao.chapter10.abs.Element
import com.github.fescalhao.chapter10.impl.ElementFactory.elem

object Application extends App {

  println(spiral(13, 0))

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
}
