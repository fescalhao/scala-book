package com.github.fescalhao.chapter24.Collections_In_Depth.classes

import scala.collection.mutable

class MapExample {
  val fruitMap: Map[Int, String] = Map(
    1 -> "Orange",
    2 -> "Apple",
    3 -> "Pear",
    4 -> "Pineapple",
    5 -> "Peach"
  )

  val mutableAnimalMap: mutable.Map[Int, String] = mutable.Map(
    1 -> "Cow",
    2 -> "Frog",
    3 -> "Bird",
    4 -> "Cat",
    5 -> "Dog"
  )

  def executeExamples(): Unit = {
    println("-------------------------- Map - LookUp Operations -------------------------")
    lookupOperations()
    println("\n---------------------- Map - Subcollection Operations ----------------------")
    subcollectionOperations()
    println("\n------------------- Map - Addition And Update Operations -------------------")
    additionAndUpdateOperations()
    println("\n--------------- Map - Transformation and Cloning Operations ----------------")
    transformationAndCloningOperations()
    println("\n------------------------- Map - Removal Operations -------------------------")
    removalOperations()
  }

  def lookupOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tget: ${fruitMap.get(2)}")
    println(s"\tapply: ${fruitMap(4)}")
    println(s"\tgetOrElse: ${fruitMap.getOrElse(6, "There is no such fruit")}")
    println(s"\tcontains: ${fruitMap.contains(5)}")
    println(s"\tisDefinedAt: ${fruitMap.isDefinedAt(5)}") // same as fruitMap.contains(5)
  }

  def subcollectionOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tkeys: ${fruitMap.keys}")
    println(s"\tkeySet: ${fruitMap.keySet}")
    println(s"\tkeysIterator: ${fruitMap.keysIterator}")
    println(s"\tvalues: ${fruitMap.values}")
    println(s"\tvaluesIterator: ${fruitMap.valuesIterator}")
  }

  def additionAndUpdateOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tupdated: ${fruitMap + (6 -> "Grape")}")
    println(s"\tconcat: ${fruitMap ++ Map(6 -> "Grape", 7 -> "Papaya")}")
    println(s"\tupdatedWith: ${fruitMap.updatedWith(2)(f => Option(s"$f Juice!"))}")
    println
    println(s"$mutableAnimalMap:")
    println(s"\tupdate: ${mutableAnimalMap(5) = "Fish"; mutableAnimalMap}")
    println(s"\taddOne: ${mutableAnimalMap += (6 -> "Snake")}")
    println(s"\taddAll: ${mutableAnimalMap ++= Map(7 -> "Turtle", 8 -> "Fox")}")
    println(s"\tput: ${mutableAnimalMap.put(8, "Spider")}")
    println(s"\tgetOrElseUpdate: ${mutableAnimalMap.getOrElseUpdate(4, "Lion")}")
    println(s"\tgetOrElseUpdate: ${mutableAnimalMap.getOrElseUpdate(9, "Lion")}")
    println(s"\tupdateWith: ${mutableAnimalMap.updateWith(8){ a => Option(s"The $a killed a guy!") }; mutableAnimalMap}")
  }

  def transformationAndCloningOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tview.filterKeys(p).toMap: ${fruitMap.view.filterKeys(_ % 2 == 0).toMap}")
    println(s"\tview.mapValues(p).toMap: ${fruitMap.view.mapValues(_.length > 5).toMap}")
    println(s"$mutableAnimalMap:")
    println(s"\tmapValuesInPlace: ${mutableAnimalMap.mapValuesInPlace((n, a) => a.toUpperCase)}")
    println(s"\tclone: ${mutableAnimalMap.clone()}")
  }

  def removalOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tremoved: ${fruitMap - 3}")
    println(s"\tremovedAll: ${fruitMap -- List(2, 5)}")
    println(s"$mutableAnimalMap:")
    println(s"\tsubtractOne: ${mutableAnimalMap -= 8}")
    println(s"\tsubtractAll: ${mutableAnimalMap --= List(9, 4)}")
    println(s"\tremove: ${mutableAnimalMap.remove(5)}")
    println(s"\tfilterInPlace: ${mutableAnimalMap.filterInPlace((n, a) => n % 2 == 0)}")
    println(s"\tclear: ${mutableAnimalMap.clear()}")
  }
}
