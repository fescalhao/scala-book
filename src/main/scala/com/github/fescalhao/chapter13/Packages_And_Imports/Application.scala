// Packages and Imports

package com.github.fescalhao.chapter13.Packages_And_Imports

import com.github.fescalhao.chapter13.Packages_And_Imports.classes.Fruits

object Application {
  def main(args: Array[String]): Unit = {
    val fruits = Fruits
    println(fruits.Apple)

    showFruit(fruits.Orange)
  }
}
