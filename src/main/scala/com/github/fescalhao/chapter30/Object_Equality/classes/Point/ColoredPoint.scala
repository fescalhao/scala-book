package com.github.fescalhao.chapter30.Object_Equality.classes.Point

import com.github.fescalhao.chapter30.Object_Equality.objects.Color


class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends Point_v4(x, y) {
  override def equals(other: Any): Boolean = other match {
    case that: ColoredPoint => (that canEqual this) && super.equals(that) && this.color == that.color
    case _ => false
  }

  override def hashCode(): Int = (super.hashCode(), color).##

  override def canEqual(other: Any): Boolean = other.isInstanceOf[ColoredPoint]
}
