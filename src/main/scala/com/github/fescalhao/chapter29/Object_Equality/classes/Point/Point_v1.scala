package com.github.fescalhao.chapter29.Object_Equality.classes.Point

class Point_v1(val x: Int, val y: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Point_v1 => this.x == that.x && this.y == that.y
    case _ => false
  }
}
