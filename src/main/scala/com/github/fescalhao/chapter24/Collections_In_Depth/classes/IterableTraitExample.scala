package com.github.fescalhao.chapter24.Collections_In_Depth.classes

class IterableTraitExample {
  val myIntList: List[Int] = List(4,7,8,9,10)

  def executeExamples(): Unit = {
    println("--------------------------- Iteration Operations ---------------------------")
    iterationOperations()
    println("\n---------------------------- Copying Operations ----------------------------")
    copyingOperations()
    println("\n------------------------------ Size Operations -----------------------------")
    sizeOperations()
    println("\n----------------------- Element Retrieval Operations -----------------------")
    elementRetrievalOperations()
    println("\n-------------------- Subcollection Retrieval Operations --------------------")
    subcollectionRetrievalOperations()
    println("\n-------------------------- Subdivision Operations --------------------------")
    subdivisionOperations()
    println("\n------------------------- Element Test Operations --------------------------")
    elementTestOperations()
    println("\n----------------------------- Fold Operations ------------------------------")
    foldOperations()
    println("\n------------------------------ Zip Operations ------------------------------")
    zipOperations()
    println("\n---------------------------- String Operations -----------------------------")
    stringOperations()
    println("\n------------------------------ View Operation ------------------------------")
    viewOperation()
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
    println(s"\tsizeIs < 4: ${myLazyList.sizeIs < 4}")
    println(s"\tsizeIs.it after checking if it's size is lower than 4: ${myLazyList.sizeIs.it}")
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

  def subdivisionOperations(): Unit = {
    val myAnyList: List[Any] = List("a", 2, "c", 5, "h")

    println(s"$myIntList:")
    println(s"\tgroupBy: ${myIntList.groupBy(_ % 2 == 0)}")
    println(s"\tgroupMap: ${myIntList.groupMap(_ % 2 == 0){x => x + 1}}")
    println(s"\tgroupMapReduce: ${myIntList.groupMapReduce(_ % 2 == 0)(x => x + 1)((x, y) => x + y)}")
    println(s"\tsplitAt: ${myIntList.splitAt(3)}")
    println(s"\tspan: ${myIntList.span(_ < 8)}")
    println(s"$myAnyList:")
    println(s"\tpartition: ${myAnyList.partition {
      case i: Int => true
      case s: String  => false
    }}")
    println(s"\tsplitAt: ${myAnyList.partitionMap {
      case i: Int => Left(i)
      case s: String => Right(s)
    }}")
  }

  def elementTestOperations(): Unit = {
    println(s"$myIntList:")
    println(s"\texists: ${myIntList.exists(_ > 12)}")
    println(s"\tforall: ${myIntList.forall(_ < 12)}")
    println(s"\tcount: ${myIntList.count(_ % 2 == 0)}")
  }

  def foldOperations(): Unit = {
    println(s"$myIntList:")
    println(s"\tfoldLeft: ${myIntList.foldLeft(0)((x, y) => if (y % 2 == 0) x + y else x)}")
    println(s"\tfoldRight: ${myIntList.foldRight(List(): List[Int])((x, y) => if (x % 2 != 0) y :+ x else y)}")
    println(s"\treduceLeft: ${myIntList.reduceLeft((x, y) => y - x)}")
    println(s"\treduceRight: ${myIntList.reduceRight((x, y) => (y - x) * 3)}")
    println(s"\tsum: ${myIntList.sum}")
    println(s"\tproduct: ${myIntList.product}")
    println(s"\tmin: ${myIntList.min}")
    println(s"\tmax: ${myIntList.max}")
  }

  def zipOperations(): Unit = {
    val myStringList: List[String] = List("a", "b", "c", "d", "e", "f", "g", "h")
    println(s"$myIntList and $myStringList:")
    println(s"\tzip: ${myIntList zip myStringList}")
    println(s"\tlazyZip: ${myIntList lazyZip myStringList}")
    println(s"\tzipAll: ${myIntList zipAll(myStringList, -1, "null")}")
    println(s"\tzipWithIndex: ${myStringList.zipWithIndex}")
  }

  def stringOperations(): Unit = {
    println(s"$myIntList:")
    println(s"\taddString: ${myIntList.addString(new StringBuilder, "<", "|", ">")}")
    println(s"\tmkString: ${myIntList.mkString(":")}")
  }

  def viewOperation(): Unit = {
    println(s"$myIntList:")
    println(s"\tview: ${myIntList.view}")
  }

}
