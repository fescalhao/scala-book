package com.github.fescalhao.chapter24.Collections_In_Depth.classes

class Example {
  val myIntList: List[Int] = List(4,7,8,9,10)

  def executeExamples(): Unit = {
    println("--------------------------- Iteration Operations ---------------------------")
    iterationOperations()
    println("---------------------------- Copying Operations ----------------------------")
    copyingOperations()
    println("------------------------------ Size Operations -----------------------------")
    sizeOperations()
    println("----------------------- Element Retrieval Operations -----------------------")
    elementRetrievalOperations()
    println("-------------------- Subcollection Retrieval Operations --------------------")
    subcollectionRetrievalOperations()
  }

  def iterationOperations(): Unit = {
    val git = myIntList grouped 4
    val sit = myIntList sliding 2

    println(s"$myIntList:")
    println("------------- grouped -------------")
    println(s"\tFirst group is: ${git.next()}")
    println(s"\tSecond group is: ${git.next()}")
    println("------------- sliding -------------")
    println(s"\tFirst sliding is: ${sit.next()}")
    println(s"\tSecond sliding is: ${sit.next()}")
    println(s"\tThird sliding is: ${sit.next()}")
  }

  def copyingOperations(): Unit = {
    val myIntArray = Array[Int](6)
    println(s"$myIntList copied to Array: ${myIntList.copyToArray(myIntArray)}")
  }

  def sizeOperations(): Unit = {
    val myLazyList: LazyList[Int] = LazyList.cons(0, myIntList.to(LazyList))
    println(s"$myIntList:")
    println(s"\tisEmpty: ${myIntList.isEmpty}")
    println(s"\tnonEmpty: ${myIntList.nonEmpty}")
    println(s"\tsize: ${myIntList.size}")
    println(s"$myLazyList:")
    println(s"\tGetting third element: ${myLazyList(2)}")
    println(s"\tsizeIs.it: ${myLazyList.sizeIs.it}")
  }

  def elementRetrievalOperations(): Unit = {
    println(s"$myIntList:")
    println(s"\thead: ${myIntList.head}")
    println(s"\tlast: ${myIntList.last}")
    println(s"\theadOption: ${myIntList.headOption}")
    println(s"\tlastOption: ${myIntList.lastOption}")
    println(s"\theadOption for Nil: ${Nil.headOption}")
    println(s"\tlastOption for Nil: ${Nil.lastOption}")
    println(s"\tfind: ${myIntList.find(_ % 2 == 0)}")
  }

  def subcollectionRetrievalOperations(): Unit = {
    println(s"$myIntList:")
    println(s"\ttakeWhile: ${myIntList.takeWhile(_ < 9)}")
    println(s"\ttail: ${myIntList.tail}")
    println(s"\tinit: ${myIntList.init}")
    println(s"\tslice: ${myIntList.slice(1, 3)}")
    println(s"\ttake: ${myIntList.take(2)}")
    println(s"\tdrop: ${myIntList.drop(2)}")
    println(s"\tfilter: ${myIntList.filter(_ % 2 == 0)}")
    println(s"\tdropWhile: ${myIntList.dropWhile(_ < 8)}")
    println(s"\tfilterNot: ${myIntList.filterNot(_ % 2 == 0)}")
    println(s"\twithFilter + map: ${myIntList.withFilter(_ % 2 == 0).map(x => x)}")
  }

}
