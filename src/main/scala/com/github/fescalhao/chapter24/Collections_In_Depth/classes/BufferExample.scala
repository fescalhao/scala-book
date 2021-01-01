package com.github.fescalhao.chapter24.Collections_In_Depth.classes

import scala.collection.mutable.ListBuffer

class BufferExample {
  val myIntListBuffer: ListBuffer[Int] = ListBuffer(4, 6, 2, 18, 7, 12, 9, 1, 16)

  def executeExamples(): Unit = {
    println("---------------------------- Buffer - Operations ---------------------------")
    bufferOperations()
  }

  def bufferOperations(): Unit = {
    println(s"$myIntListBuffer:")
    println(s"\tappend: ${myIntListBuffer += 22}")
    println(s"\tappendAll: ${myIntListBuffer ++= List(22, 31, 29)}")
    println(s"\tprepend: ${14 +=: myIntListBuffer}")
    println(s"\tprependAll: ${List(99, 102) ++=: myIntListBuffer}")
    println(s"\tinsert: ${myIntListBuffer.insert(3, 404); myIntListBuffer}")
    println(s"\tinsertAll: ${myIntListBuffer.insertAll(6, Seq(777, 666)); myIntListBuffer}")
    println(s"\tpadToInPlace: ${myIntListBuffer.padToInPlace(25, -1)}")
    println(s"\tsubtractOne: ${myIntListBuffer -= 22}")
    println(s"\tsubtractAll: ${myIntListBuffer --= Seq(-1, -1, -1)}")
    println(s"\tremove: ${myIntListBuffer.remove(0, 3); myIntListBuffer}")
    println(s"\ttrimStart: ${myIntListBuffer.trimStart(3); myIntListBuffer}")
    println(s"\ttrimEnd: ${myIntListBuffer.trimEnd(3); myIntListBuffer}")
    println(s"\tpatchInPlace: ${myIntListBuffer.patchInPlace(3, List(-2,-3,-4), 3)}")
    println(s"\tclone: ${myIntListBuffer.clone()}")
    println(s"\tclear: ${myIntListBuffer.clear(); myIntListBuffer}")
  }
}
