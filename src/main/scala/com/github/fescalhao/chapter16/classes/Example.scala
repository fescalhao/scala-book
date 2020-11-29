package com.github.fescalhao.chapter16.classes

import scala.annotation.tailrec

class Example {

  def executeExamples(): Unit = {
    listOperation()
    println("-------------------")
    insertionSort()
    println("-------------------")
    listPattern()
    println("-------------------")
    firstOrderMethods()
    println("-------------------")
  }

  def listOperation(): Unit = {
    val myList = List(1, 2, 3, 4, 5)
    println(myList.head) // only for non-empty lists
    println(myList.tail) // only for non-empty lists
    println(myList.tail.head) // only for non-empty lists
    println(myList.isEmpty)
  }

  def insertionSort(): Unit = {
    val myList = List(153, 5, 8, 3, 4, 7, 12, 1)
    println(isort(myList))

    def isort(list: List[Int]): List[Int] = {
      if (list.isEmpty) Nil
      else insert(list.head, isort(list.tail))
    }

    def insert(elem: Int, list: List[Int]): List[Int] = {
      if (list.isEmpty || elem <= list.head) elem :: list
      else list.head :: insert(elem, list.tail)
    }
  }

  def listPattern(): Unit = {
    val fruits = List("Orange", "Apple", "Pear")

    val List(f1, f2, f3) = fruits
    println(s"$f1 / $f2 / $f3")

    val a :: rest = fruits
    println(s"$a / $rest")

    val myList = List(13, 5, 313, 24, 1, 65, 7, 79)
    println(isort(myList))

    def isort(list: List[Int]): List[Int] = {
      list match {
        case List() => List()
        case headElem :: tailList => insert(headElem, isort(tailList))
      }
    }

    def insert(elem: Int, list: List[Int]): List[Int] = {
      list match {
        case List() => List(elem)
        case headElem :: tailList =>
          if (elem <= headElem) elem :: list
          else headElem :: insert(elem, tailList)
      }
    }
  }

  def firstOrderMethods(): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = list1 ::: list2
    val list4 = List(list1, list2)
    val stringList: List[String] = List("a", "b", "c", "d")
    val fruits = List("Apple", "Orange", "Pear")

    concat()
    size()
    elements()
    backwards()
    prefixSufix()
    elementSelection()
    flattening()
    zip()

    def concat(): Unit = {
      println(s"$list1 and $list2 concatenated to $list3")
      println(s"$list1 and $list2 concatenated to ${append(list1, list2)} using method 'append'")

      def append[T](list1: List[T], list2: List[T]): List[T] = {
        list1 match {
          case List() => list2
          case x :: xs => x :: append(xs, list2)
        }
      }
    }

    def size(): Unit = {
      println(s"$list3 length is ${list3.length}")
    }

    def elements(): Unit = {
      println(s"First element of list $list3 is ${list3.head} and the remaining elements are ${list3.tail}")
      println(s"Last element of list $list3 is ${list3.last} and the remaining elements are ${list3.init}")
    }

    def backwards(): Unit = {
      println(s"$list3 backwards: ${list3.reverse}")
      println(s"$list3 backwards: ${rev(list3)} using method 'rev'")

      def rev[T](list: List[T]): List[T] = {
        list match {
          case List() => List()
          case elem :: tailList => rev(tailList) ::: List(elem)
        }
      }
    }

    def prefixSufix(): Unit = {
      println(s"Take 3 elements from $list3: ${list3 take 3}")
      println(s"Drop 3 elements from $list3: ${list3 drop 3}")
      println(s"Split elements at index 2 from $list3: ${list3 splitAt 3}. It's a (Tuple(List,List))")
    }

    def elementSelection(): Unit = {
      // apply is a combination of drop and head
      // list3 apply 3 is equals to (list3 drop 3).head
      println(s"Apply on index 2 for list $list3: list3.apply(2) or list3(2) -> ${list3 apply 2}. (It's rare in Scala)")
      println(s"$stringList has the following range using stringList.indices: ${stringList.indices}")
      println(s"A for loop using stringList.indices as well! It's actually (stringList.indices - 1)")
      for (i <- stringList.indices)
        println(s"  $i: ${stringList(i)}")
    }

    def flattening(): Unit = {
      println(s"Flattened $list4: ${list4.flatten}")
      println(s"Flattened $fruits chars: ${fruits.flatMap(_.toCharArray)}")
    }

    def zip(): Unit = {
      val stringZipped = stringList.indices zip stringList

      println(s"Zipping $stringList and ${stringList.indices.toList}: ${stringZipped}")
      println(s"Zipping $fruits with method .zipWithIndex: ${fruits.zipWithIndex}")
      println(s"Unzipping ${stringZipped}: ${stringZipped.unzip}")
    }

  }
}
