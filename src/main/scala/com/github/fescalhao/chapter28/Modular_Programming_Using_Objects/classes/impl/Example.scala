package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock.browser.{SimpleBrowser, StudentBrowser}
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock.database.{SimpleDatabase, StudentDatabase}

class Example {
  def executeExamples(): Unit = {
    println("------------------------------ Test Mock 1 ------------------------------")
    testMock1()
    println("\n----------------------------- Test Mock 2 -------------------------------")
    testMock2()
  }

  def testMock1(): Unit = {
    val apple: Food = SimpleDatabase.foodName("Apple").get
    val miscFoodList: String = SimpleBrowser.displayCategoryFood("Misc") match {
      case Some(f) => f.mkString(", ")
      case None => "No food for Misc category"
    }
    val fruitFoodList: String = SimpleBrowser.displayCategoryFood("Fruit") match {
      case Some(f) => f.mkString(", ")
      case None => "No food for Fruit category"
    }

    println(s"Fruit: $apple")
    println(s"Recipes using $apple: ${SimpleBrowser.recipesUsing(apple).mkString(", ")}")
    println(s"Misc Category: $miscFoodList")
    println(s"Fruit Category: $fruitFoodList")
  }

  def testMock2(): Unit = {
    val frozen: Food = StudentDatabase.foodName("FrozenFood").get
    val foodList: String = StudentBrowser.displayCategoryFood("Frozen") match {
      case Some(f) => f.mkString(", ")
      case None => "No food for this category"
    }

    println(s"Frozen Food: $frozen")
    println(s"Recipes using $frozen: ${StudentBrowser.recipesUsing(frozen).mkString(", ")}")
    println(s"Misc Category: $foodList")
  }
}
