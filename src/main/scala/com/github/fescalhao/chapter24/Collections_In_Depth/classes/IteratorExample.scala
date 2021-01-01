package com.github.fescalhao.chapter24.Collections_In_Depth.classes

class IteratorExample {
  val myIntList: List[Int] = List(1 to 14: _*)
  val myIntList2: List[Int] = List(102 to 120 by 2: _*)

  def executeExamples(): Unit = {
    println("-------------------------- Iterator - Abstract Methods -------------------------")
    abstractMethods()
    println("\n---------------------------- Iterator - Variations ----------------------------")
    variations()
    println("\n----------------------------- Iterator - Copying ------------------------------")
    copying()
    println("\n--------------------------- Iterator - Duplication ----------------------------")
    duplication()
    println("\n---------------------------- Iterator - Additions -----------------------------")
    additions()
    println("\n------------------------------- Iterator - Maps -------------------------------")
    maps()
    println("\n---------------------------- Iterator - Size Info -----------------------------")
    sizeInfo()
    println("\n------------------------ Iterator - Element Retrieval -------------------------")
    elementRetrieval()
    println("\n--------------------------- Iterator - Subiterators ---------------------------")
    subiterators()
    println("\n--------------------------- Iterator - Subdivisions ---------------------------")
    subdivisions()
    println("\n------------------------ Iterator - Element Conditions ------------------------")
    elementConditions()
    println("\n------------------------------- Iterator - Folds ------------------------------")
    folds()
    println("\n------------------------------ Iterator - Zippers -----------------------------")
    zippers()
    println("\n------------------------------ Iterator - Update ------------------------------")
    update()
    println("\n---------------------------- Iterator - Comparison ----------------------------")
    comparison()
    println("\n----------------------------- Iterator - Strings ------------------------------")
    strings()
  }

  def abstractMethods(): Unit = {
    println(s"$myIntList:")
    println(s"\tnext: ${myIntList.iterator.next()}")
    println(s"\thasNext: ${myIntList.iterator.hasNext}")

  }

  def variations(): Unit = {
    println(s"$myIntList:")
    println(s"\tbuffered: ${myIntList.iterator.buffered.mkString(" | ")}")
    println(s"\tgrouped: ${myIntList.iterator.grouped(3).mkString(" | ")}")
    println(s"\tsliding: ${myIntList.iterator.sliding(2, 2).mkString(" | ")}")
  }

  def copying(): Unit = {
    val myIntArray: Array[Int] = new Array[Int](10)
    println(s"$myIntList:")
    println(s"\tcopyToArray: ${myIntList.iterator.copyToArray(myIntArray, 2, 6); myIntArray.mkString(" | ")}")
  }

  def duplication(): Unit = {
    val (it1, it2) = myIntList.iterator.duplicate: (Iterator[Int], Iterator[Int])
    println(s"$myIntList:")
    println(s"\tduplication - it1: ${it1.mkString(" | ")}")
    println(s"\tduplication - it2: ${it2.mkString(" | ")}")
  }

  def additions(): Unit = {
    println(s"$myIntList and $myIntList2:")
    println(s"\t++: ${(myIntList ++ myIntList2).mkString(" | ")}")
    println(s"\tpadTo: ${myIntList.padTo(15, -1)}")
  }

  def maps(): Unit = {
    println(s"$myIntList:")
    println(s"\tmap: ${myIntList.iterator.map(_ * 2).mkString(" | ")}")
    println(s"\tflatMap: ${myIntList.iterator.flatMap(x => List(x - 1, x, x + 1)).mkString(" | ")}")
    println(s"\tcollect: ${myIntList.iterator.collect({case i: Int if i % 2 == 0 => i}).mkString(" | ")}")
  }

  def sizeInfo(): Unit = {
    println(s"$myIntList:")
    println(s"\tisEmpty: ${myIntList.iterator.isEmpty}")
    println(s"\tnonEmpty: ${myIntList.iterator.nonEmpty}")
    println(s"\tlength: ${myIntList.iterator.length}")
    println(s"\tsize: ${myIntList.iterator.size}")
    println(s"\tknownSize: ${myIntList.iterator.knownSize}")
  }

  def elementRetrieval(): Unit = {
    println(s"$myIntList:")
    println(s"\tfind: ${myIntList.iterator.find(_ > 5)}")
    println(s"\tindexOf: ${myIntList.iterator.indexOf(4)}")
    println(s"\tindexWhere: ${myIntList.iterator.indexWhere(_ > 8)}")
  }

  def subiterators(): Unit = {
    println(s"$myIntList:")
    println(s"\ttake: ${myIntList.iterator.take(4).mkString(" | ")}")
    println(s"\tdrop: ${myIntList.iterator.drop(8).mkString(" | ")}")
    println(s"\tslice: ${myIntList.iterator.slice(3, 7).mkString(" | ")}")
    println(s"\ttakeWhile: ${myIntList.iterator.takeWhile(_ < 6).mkString(" | ")}")
    println(s"\tdropWhile: ${myIntList.iterator.dropWhile(_ < 6).mkString(" | ")}")
    println(s"\tfilter: ${myIntList.iterator.filter(_ % 2 == 0).mkString(" | ")}")
    println(s"\tfilterNot: ${myIntList.iterator.filter(_ % 2 == 0).mkString(" | ")}")
    println(s"\twithFilter: ${myIntList.iterator.withFilter(_ % 2 == 1).mkString(" | ")}") // same as filter
    println(s"\tdistinct: ${myIntList.iterator.distinct.mkString(" | ")}")
  }

  def subdivisions(): Unit = {
    val (itDoes, itDoesNot): (Iterator[Int], Iterator[Int]) = myIntList.iterator.partition(_ % 2 == 0)

    println(s"$myIntList:")
    println(s"\tpartition - itDoes: ${itDoes.mkString(" | ")}")
    println(s"\tpartition - itDoesNot: ${itDoesNot.mkString(" | ")}")
  }

  def elementConditions(): Unit = {
    println(s"$myIntList:")
    println(s"\tforall: ${myIntList.iterator.forall(_ < 20)}")
    println(s"\texists: ${myIntList.iterator.exists(_ > 20)}")
    println(s"\tcount: ${myIntList.iterator.count(_ % 2 == 0)}")
  }

  def folds(): Unit = {
    println(s"$myIntList:")
    println(s"\tfoldLeft: ${myIntList.iterator.foldLeft(0){ (x, y) => if (y % 2 == 0) x + y else x }}")
    println(s"\tfoldRight: ${myIntList.iterator.foldRight(0){ (x, y) => if (x > 5) x + y else y }}")
    println(s"\treduceLeft: ${myIntList.iterator.reduceLeft( (x, y) => if (y % 2 == 0) x + y else x) }")
    println(s"\treduceRight: ${myIntList.iterator.reduceRight( (x, y) => if (x > 5) x + y else y )}")
    println(s"\tsum: ${myIntList.iterator.sum}")
    println(s"\tproduct: ${myIntList.iterator.product}")
    println(s"\tmin: ${myIntList.iterator.min}")
    println(s"\tmax: ${myIntList.iterator.max}")
  }

  def zippers(): Unit = {
    println(s"$myIntList and $myIntList2:")
    println(s"\tzip: ${myIntList.iterator.zip(myIntList2.iterator).mkString(" | ")}")
    println(s"\tzipAll: ${myIntList.iterator.zipAll(myIntList2.iterator, -1, -100).mkString(" | ")}")
    println(s"\tzipWithIndex: ${myIntList2.iterator.zipWithIndex.mkString(" | ")}")
  }

  def update(): Unit = {
    println(s"$myIntList:")
    println(s"\tpatch: ${myIntList.iterator.patch(3, Iterator(-1, -2, -3), 3).mkString(" | ")}")
  }

  def comparison(): Unit = {
    println(s"$myIntList and $myIntList2:")
    println(s"\tsameElements: ${myIntList.iterator.sameElements(myIntList2)}")
  }

  def strings(): Unit = {
    println(s"$myIntList:")
    println(s"\taddString: ${myIntList.iterator.addString(new StringBuilder, "[", " - ", "]")}")
    println(s"\tmkString: ${myIntList.iterator.mkString("[", " - ", "]")}")
  }
}
