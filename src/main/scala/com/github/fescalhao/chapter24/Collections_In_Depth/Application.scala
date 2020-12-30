package com.github.fescalhao.chapter24.Collections_In_Depth

import com.github.fescalhao.chapter24.Collections_In_Depth.classes.{IterableTraitExample, SeqExample}

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
}
