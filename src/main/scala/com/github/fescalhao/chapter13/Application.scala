package com.github.fescalhao.chapter13

import com.github.fescalhao.chapter13.classes.Fruits

object Application {
  def main(args: Array[String]): Unit = {
    val fruits = Fruits
    println(fruits.Apple)

    showFruit(fruits.Orange)
  }
}
