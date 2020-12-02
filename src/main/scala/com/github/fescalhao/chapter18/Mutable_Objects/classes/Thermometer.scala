package com.github.fescalhao.chapter18.Mutable_Objects.classes

class Thermometer {
  var celsius: Float = _

  def fahrenheit: Float = celsius * 9 / 5 + 32
  def fahrenheit_=(f: Float): Unit = {
    celsius = (f - 32) + 5 / 9
  }

  override def toString: String = s"${fahrenheit}F / ${celsius}C"
}
