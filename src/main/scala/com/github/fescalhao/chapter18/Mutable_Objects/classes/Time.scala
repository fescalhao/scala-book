package com.github.fescalhao.chapter18.Mutable_Objects.classes

class TimeGetterSetterExplicit {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int): Unit = { h = x }

  def minute: Int = m
  def minute_=(x: Int): Unit = { m = x }
}

class TimeGetterSetterImplicit {
  var hour = 12
  var minute = 0
}

class TimeMyGetterSetter {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int): Unit = {
    require(0 <= x && x < 24, "Hours must be between 0 and 23")
    h = x
  }

  def minute: Int = m
  def minute_=(x: Int): Unit = {
    require(0 <= x && x < 60, "Minutes must be between 0 and 59")
    m = x
  }
}