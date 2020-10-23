package com.github.fescalhao.chapter3

import scala.collection.immutable.HashSet
import scala.collection.mutable

object examples extends App {

  val s = func_example1(Array("A","B","C"))
  assert(s == "A, B, C")

// --------------------------------- Array ---------------------------------
  // Example: param_example()
  def param_example(): Unit = {
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
  def create_array(): Unit = {
    val num = Array("zero", "one", "two")
    num.foreach(x => println(x))

    val numVerbose = Array.apply("three", "four", "five")
    numVerbose.foreach(x => println(x))
  }
// ------------------------------------------------------------------------

// --------------------------------- List ---------------------------------
  // Example: create_list()
  def create_list(): Unit = {
    val list = List(1,2,3)
    list.foreach(x => println(x))
  }
  // Example: concat_list()
  def concat_list(): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    val list3 = list1 ::: list2

    // list1 and list2 were not mutated. list3 is a new List
    println(list1)
    println(list2)
    println(list3)
  }
  // Example: add_elem_to_list()
  def add_elem_to_list(): Unit = {
    val list = List("apple","car")
    val newList = "orange" :: list
    val nilList = 4 :: 5 :: 6 :: Nil

    println(newList.sortWith((x,y) => x.length < y.length))
    println(newList)
    println(nilList)
  }
// ------------------------------------------------------------------------

// --------------------------------- Tuple --------------------------------
  // Example: new_tuple()
  def new_tuple(): Unit = {
    val pair = (99, "whatever", true)
    println(pair._1)
    println(pair._2)
    println(pair._3)
  }
// ------------------------------------------------------------------------

// --------------------------------- Set ----------------------------------
  // Example: new_set()
  def new_set(): Unit = {
    var jetSet = Set("Boing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Boing"))
  }
  // Example: new_hash_set()
  def new_hash_set(): Unit = {
    val hashSet = HashSet("A", "B")
    println(hashSet + "C")
  }
// ------------------------------------------------------------------------

// ---------------------------------- Map ---------------------------------
// Example: new_map()
  def new_map(): Unit = {
    // Mutable map
    val myMap = mutable.Map[Int, String]()
    myMap += (1 -> "A")
    myMap += (2 -> "B")
    myMap += (3 -> "C")
    println(myMap(2))

    // Immutable map
    val roman = Map(
      1 -> "I",
      2 -> "II",
      3 -> "III",
      4 -> "IV",
      5 -> "V"
    )
    // Maps do not guarantee order
    roman.foreach(entry => println(entry._2))
  }
//  ------------------------------------------------------------------------

//  --------------------- Functional Programming Style ---------------------
  // Example: print(func_example1(Array("A","B","C")))
  def func_example1(args : Array[String]) = {
    args.mkString(", ")
  }
}
