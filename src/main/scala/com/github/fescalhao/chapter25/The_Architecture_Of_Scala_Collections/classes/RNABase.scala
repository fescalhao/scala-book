package com.github.fescalhao.chapter25.The_Architecture_Of_Scala_Collections.classes

abstract class RNABase

case object A extends RNABase

case object U extends RNABase

case object G extends RNABase

case object C extends RNABase


object RNABase {
  val fromInt: Int => RNABase = Array(A, U, G, C)
  val toInt: RNABase => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}