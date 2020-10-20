package com.github.fescalhao.chapter3

object examples extends App {
  add_elem_to_beginning()

// --------------------------------- Array ---------------------------------
  // Example: param_example()
  def param_example() = {
    val greetings = new Array[String](3)
    greetings(0) = "Hello"
    greetings(1) = ","
    greetings(2) = "World!"

    greetings.foreach(x => println(x))
    // OR
    for(i <- 0 to 2) {
      println(greetings(i))
    }
  }

  // Example: create_array()
  def create_array() = {
    val num = Array("zero", "one", "two")
    num.foreach(x => println(x))

    val numVerbose = Array.apply("three", "four", "five")
    numVerbose.foreach(x => println(x))
  }
// ------------------------------------------------------------------------

// --------------------------------- List ---------------------------------
  // Example: create_list()
  def create_list() = {
    val list = List(1,2,3)
    list.foreach(x => println(x))
  }

  def concat_list() = {
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    val list3 = list1 ::: list2

    // list1 and list2 were not mutated. list3 is a new List
    println(list1)
    println(list2)
    println(list3)
  }

  def add_elem_to_beginning() = {
    val list = List(2,3)
    val newList = 1 :: list
    val emptyList = List(Nil)

    println(newList)
  }
}
