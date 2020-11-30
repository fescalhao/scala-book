// Packages and Imports

package com.github.fescalhao.chapter13

import com.github.fescalhao.chapter13.Packages_And_Imports.classes.Fruit

package object Packages_And_Imports {
  def showFruit(fruit: Fruit): Unit = {
    import fruit._
    println(s"$name's are $color")
  }
}
