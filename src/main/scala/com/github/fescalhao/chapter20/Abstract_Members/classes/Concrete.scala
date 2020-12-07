package com.github.fescalhao.chapter20.Abstract_Members.classes

import com.github.fescalhao.chapter20.Abstract_Members.traits.Abstract

class Concrete(num: Int) extends Abstract {
  type T = Int
  def transform(x: T): T = current + x
  val initial: T = 10
  var current: T = initial + num
}
