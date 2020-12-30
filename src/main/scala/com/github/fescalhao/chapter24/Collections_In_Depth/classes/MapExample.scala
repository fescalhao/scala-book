package com.github.fescalhao.chapter24.Collections_In_Depth.classes

class MapExample {
  val fruitMap: Map[Int, String] = Map(
    1 -> "Orange",
    2 -> "Apple",
    3 -> "Pear",
    4 -> "Pineapple",
    5 -> "Peach"
  )

  def executeExamples(): Unit = {
    println("-------------------------- Map - LookUp Operations -------------------------")
    lookupOperations()
    println("---------------------- Map - Subcollection Operations ----------------------")
    subcollectionOperations()
    println("---------------------- Map - Transformation Operations ---------------------")
    transformationOperations()
    println("------------------- Map - Addition And Update Operations -------------------")
    additionAndUpdateOperations()
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

  def transformationOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tview.filterKeys(p).toMap: ${fruitMap.view.filterKeys(_ % 2 == 0).toMap}")
    println(s"\tview.mapValues(p).toMap: ${fruitMap.view.mapValues(_.length > 5).toMap}")
  }

  def additionAndUpdateOperations(): Unit = {
    println(s"$fruitMap:")
    println(s"\tupdated: ${fruitMap + (6 -> "Grape")}")
    println(s"\tconcat: ${fruitMap ++ Map(6 -> "Grape", 7 -> "Papaya")}")
    println(s"\tupdatedWith: ${fruitMap.updatedWith(2)(f => Option(s"$f Juice!"))}")
  }
}
