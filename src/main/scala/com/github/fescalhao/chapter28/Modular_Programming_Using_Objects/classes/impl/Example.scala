package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock.{SimpleBrowser, SimpleDatabase}

class Example {
  def executeExamples(): Unit = {
    println("------------------------------ Test Mock 1 ------------------------------")
    testMock1()
//    println("\n----------------------------- Twice -------------------------------")
//    twice()
  }

  def testMock1(): Unit = {
    val apple: Food = SimpleDatabase.foodName("Apple").get
    val foodList: String = SimpleBrowser.displayCategoryFood("Misc") match {
      case Some(f) => f.mkString(", ")
      case None => "No food for this category"
    }

    println(s"Fruit: $apple")
    println(s"Recipes using $apple: ${SimpleBrowser.recipesUsing(apple).mkString(", ")}")
    println(s"Misc Category: $foodList")
  }
}
