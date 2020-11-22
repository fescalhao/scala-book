// Packages and Imports

package com.github.fescalhao

import com.github.fescalhao.chapter13.classes.Fruit

package object chapter13 {
  def showFruit(fruit: Fruit): Unit = {
    import fruit._
    println(s"$name's are $color")
  }
}
