package com.github.fescalhao.chapter24.Collections_In_Depth.classes

import scala.collection.mutable

class SeqExample {
  val myIntSeq: Seq[Int] = Seq(6, 12, 3, 2, 14, 9, 3, 8, 6, 12, 10)
  val myStringSeq: Seq[String] = Seq("f", "y", "g", "e", "a", "b", "a", "g")
  val myTupleSeq: Seq[(String, Int)] = Seq(("John", 23), ("Sophia", 19), ("Peter", 29), ("Carol", 32), ("Bill", 9))
  val myIntIndexedSeq: mutable.IndexedSeq[Int] = mutable.IndexedSeq(4, 6, 2, 18, 7, 12, 9, 1, 16)

  // These operations work for Array, ArraySeq and Vector as well

  def executeExamples(): Unit = {
    println("------------------- Seq - Indexing and Length Operations -------------------")
    indexAndLengthOperations()
    println("\n----------------------- Seq - Index Search Operations ----------------------")
    indexSearchOperations()
    println("\n------------------------- Seq - Addition Operations ------------------------")
    additionOperations()
    println("\n-------------------------- Seq - Update Operations -------------------------")
    updateOperations()
    println("\n-------------------------- Seq - Sorting Operations ------------------------")
    sortingOperations()
    println("\n------------------------- Seq - Reversal Operations ------------------------")
    reversalOperations()
    println("\n------------------------ Seq - Comparison Operations -----------------------")
    comparisonOperations()
    println("\n------------------------- Seq - Multiset Operations ------------------------")
    multisetOperations()
    println("\n---------------------- Mutable Indexed Seq - Operations --------------------")
    mutableIndexedSeqOperations()
  }

  def indexAndLengthOperations(): Unit = {
    println(s"$myStringSeq:")
    println(s"\tapply(2): ${myStringSeq(2)}")
    println(s"\tisDefinedAt(2): ${myStringSeq.isDefinedAt(2)}")
    println(s"\tlength: ${myStringSeq.length}")
    println(s"\tindeces: ${myStringSeq.indices}")
    println(s"\tlengthCompare: ${myStringSeq.lengthCompare(myIntSeq)}")
    println(s"\tlengthIs > 3: ${myStringSeq.lengthIs > 3}")
  }

  def indexSearchOperations(): Unit = {
    println(s"$myStringSeq:")
    println(s"\tindexOf(a): ${myStringSeq.indexOf("a")}")
    println(s"\tlastIndexOf(a): ${myStringSeq.lastIndexOf("a")}")
    println(s"\tindexOfSlice(Seq(g), 4): ${myStringSeq.indexOfSlice(Seq("g"), 4)}")
    println(s"\tlastIndexOfSlice(Seq(a)): ${myStringSeq.lastIndexOfSlice(Seq("a"))}")
    println(s"\tindexWhere: ${myStringSeq.indexWhere(x => x == "e")}")
    println(s"\tlastIndexWhere: ${myStringSeq.lastIndexWhere(x => x == "a")}")
    println(s"\tsegmentLength: ${myStringSeq.segmentLength(_ != "e")}")
  }

  def additionOperations(): Unit = {
    println(s"$myStringSeq:")
    println(s"\tprepend: ${"u" +: myStringSeq}")
    println(s"\tprependAll: ${Seq("u", "j") ++: myStringSeq}")
    println(s"\tappend: ${myStringSeq :+ "u"}")
    println(s"\tappendAll: ${myStringSeq :++ Seq("u", "j")}")
    println(s"\tpadTo: ${myStringSeq.padTo(15, "x")}")
  }

  def updateOperations(): Unit = {
    println(s"$myStringSeq:")
    println(s"\tupdate: ${myStringSeq.updated(3, "updated!")}")
    println(s"\tpatch: ${myStringSeq.patch(0, Seq("x", "y", "z"), 4)}")
  }

  def sortingOperations(): Unit = {
    println(s"$myTupleSeq:")
    println(s"\tsorted: ${myTupleSeq.sorted}")
    println(s"\tsortWith: ${myTupleSeq.sortWith(_._2 > _._2)}")
    println(s"\tsortBy: ${myTupleSeq.sortBy(x => x._2)}")
  }

  def reversalOperations(): Unit = {
    println(s"$myStringSeq:")
    println(s"\treverse: ${myStringSeq.reverse}")
    println(s"\treverseIterator: ${myStringSeq.reverseIterator}")
  }

  def comparisonOperations(): Unit = {
    println(s"$myIntSeq:")
    println(s"\tstartsWith: ${myIntSeq.startsWith(Seq(12), 1)}")
    println(s"\tendsWith: ${myIntSeq.endsWith(Seq(9))}")
    println(s"\tcontains: ${myIntSeq.contains(7)}")
    println(s"\tcorresponds: ${myIntSeq.corresponds(Seq(0, -1, -3, -3, -12, -5))((x, y) => (x + y) > 0)}")
    println(s"\tcontainsSlice: ${myIntSeq.containsSlice(Seq(3, 2))}")
    println(s"\tsearch: ${myIntSeq.search(14)}")
  }

  def multisetOperations(): Unit = {
    println(s"$myIntSeq:")
    println(s"\tintersect: ${myIntSeq.intersect(Seq(4, 12, 6, 10, 8, 14))}")
    println(s"\tdiff: ${myIntSeq.diff(Seq(4, 12, 6, 10, 8, 14))}")
    println(s"\tdistinct: ${myIntSeq.distinct}")
    println(s"\tdistinctBy: ${myIntSeq.distinctBy(_ % 3)}")
  }

  def mutableIndexedSeqOperations(): Unit = {
    println(s"$myIntIndexedSeq:")
    println(s"\tmapInPlace: ${myIntIndexedSeq.mapInPlace(_ * 2)}")
    println(s"\tsortInPlace: ${myIntIndexedSeq.sortInPlace()}")
    println(s"\tsortInPlaceBy: ${myIntIndexedSeq.sortInPlaceBy(x => x + (x % 2))}")
    println(s"\tsortInPlaceWith: ${myIntIndexedSeq.sortInPlaceWith(_ > _)}")
  }
}
