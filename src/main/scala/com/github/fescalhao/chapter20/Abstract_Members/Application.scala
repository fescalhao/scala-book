package com.github.fescalhao.chapter20.Abstract_Members

import com.github.fescalhao.chapter20.Abstract_Members.classes.Concrete

object Application extends App {
  val concrete = new Concrete(2)
  println(concrete.current)
  println(concrete.transform(5))
  println(concrete.current)
}
