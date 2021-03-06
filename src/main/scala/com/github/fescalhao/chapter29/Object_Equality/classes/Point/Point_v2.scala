package com.github.fescalhao.chapter29.Object_Equality.classes.Point

class Point_v2(val x: Int, val y: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Point_v2 => this.x == that.x && this.y == that.y
    case _ => false
  }

  override def hashCode(): Int = (x, y).##
}
