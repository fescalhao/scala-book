package com.github.fescalhao.chapter20.Abstract_Members.traits

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
