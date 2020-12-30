package com.github.fescalhao.chapter24.Collections_In_Depth.classes

import scala.collection.mutable

class SetExample {
  val myIntSet: Set[Int] = Set(6, 12, 3, 2, 14, 9, 3, 8, 6, 12, 10)
  val myStringSet: Set[String] = Set("f", "y", "g", "e", "a", "b", "a", "g")
  val myIntMutableSet: mutable.Set[Int] = mutable.Set(1, 3, 2, 4)

  def executeExamples(): Unit = {
    println("------------------- Set - Test Operations -------------------")
    testOperations()
    println("----------------- Set - Addition Operations -----------------")
    additionOperations()
    println("------------------ Set - Removal Operations -----------------")
    removalOperations()
    println("---------------------- Set - Operations ---------------------")
    setOperations()
    println("------------------- Set - Update Operation ------------------")
    updateOperation()
    println("------------------- Set - Clone Operation ------------------")
    cloneOperation()
  }

  def testOperations(): Unit = {
    println(s"$myStringSet:")
    println(s"\tcontains: ${myStringSet.contains("e")}")
    println(s"\tapply: ${myStringSet("g")}") // the same as myStringSet.contains("e")
    println(s"\tsubsetOf: ${myStringSet.subsetOf(Set("y", "g"))}")
  }

  def additionOperations(): Unit = {
    println(s"$myIntSet:")
    println(s"\tincl: ${myIntSet + 18}")
    println(s"\tconcat: ${myIntSet ++ Seq(404, 747)}")
    println
    println(s"$myIntMutableSet:")
    println(s"\taddOne: ${myIntMutableSet += 27}")
    println(s"\taddAll: ${myIntMutableSet ++= Seq(404, 747, 69)}")
    println(s"\tadd: ${myIntMutableSet.add(27)}") // returns true if the element was not previously contained within the Set
  }

  def removalOperations(): Unit = {
    println(s"$myIntSet:")
    println(s"\texcl: ${myIntSet - 2}")
    println(s"\tremoveAll: ${myIntSet -- Seq(18, 9, 6, 14)}")
    println(s"\tempty: ${myIntSet.empty}")
    println
    println(s"$myIntMutableSet:")
    println(s"\tsubtractOne: ${myIntMutableSet -= 27}")
    println(s"\tsubtractAll: ${myIntMutableSet --= Seq(4, 3, 2, 1)}")
    println(s"\tremove: ${myIntMutableSet.remove(404)}") // returns true if the element was previously contained within the Set
    println(s"\tfilterInPlace: ${myIntMutableSet.filterInPlace(_ > 100)}")
    println(s"\tclear: ${myIntMutableSet.clear()}")
  }

  def setOperations(): Unit = {
    val myOtherStringSet: Set[String] = Set("h", "l", "g", "y", "j")

    println(s"$myStringSet and $myOtherStringSet:")
    println(s"\tintersect: ${myStringSet & myOtherStringSet}")
    println(s"\tunion: ${myStringSet | myOtherStringSet}")
    println(s"\tdiff: ${myStringSet &~ myOtherStringSet}")
  }

  def updateOperation(): Unit = {
    // xs(x) = b
    // If b is true then adds x to xs otherwise removes x from xs
    println(s"$myIntMutableSet:")
    println(s"\tupdate: ${myIntMutableSet(1) = myIntMutableSet.isEmpty; myIntMutableSet}")
  }

  def cloneOperation(): Unit = {
    println(s"$myIntMutableSet:")
    println(s"\tclone: ${myIntMutableSet.clone()}")
  }

}
