package com.github.fescalhao.chapter29.Object_Equality.classes.Point

class Point_v4(val x: Int, val y: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Point_v4 => (that canEqual this) && (this.x == that.x) && (this.y == that.y)
    case _ => false
  }

  override def hashCode(): Int = (x, y).##

  def canEqual(other: Any): Boolean = other.isInstanceOf[Point_v4]
}
