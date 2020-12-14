package com.github.fescalhao.chapter20.Abstract_Members.objects

object Demo {
  val x: String = {
    println("Initializing x")
    "done X"
  }

  lazy val y: String = {
    println("Initializing y")
    "done Y"
  }
}
