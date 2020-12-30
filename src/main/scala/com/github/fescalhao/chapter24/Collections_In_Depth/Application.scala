package com.github.fescalhao.chapter24.Collections_In_Depth

import com.github.fescalhao.chapter24.Collections_In_Depth.classes._

object Application extends App {
  println("----------------------------------------------------------------------------")
  println("|                              ITERABLE TRAIT                              |")
  println("----------------------------------------------------------------------------")
  val iterableTraitExample = new IterableTraitExample
  iterableTraitExample.executeExamples()

  println
  println("----------------------------------------------------------------------------")
  println("|                                    SEQ                                   |")
  println("----------------------------------------------------------------------------")
  val seqExample = new SeqExample
  seqExample.executeExamples()

  println
  println("----------------------------------------------------------------------------")
  println("|                                    SET                                   |")
  println("----------------------------------------------------------------------------")
  val setExample = new SetExample
  setExample.executeExamples()

  println
  println("----------------------------------------------------------------------------")
  println("|                                    MAP                                   |")
  println("----------------------------------------------------------------------------")
  val mapExample = new MapExample
  mapExample.executeExamples()
}
