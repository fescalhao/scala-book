package com.github.fescalhao.chapter30.Object_Equality.classes.Point

class Point_v3(var x: Int, var y: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Point_v3 => (that canEqual this) && (this.x == that.x) && (this.y == that.y)
    case _ => false
  }

  override def hashCode(): Int = (x, y).##

  def canEqual(other: Any): Boolean = other.isInstanceOf[Point_v3]
}
