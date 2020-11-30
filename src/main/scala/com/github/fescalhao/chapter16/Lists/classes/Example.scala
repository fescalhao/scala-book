package com.github.fescalhao.chapter16.Lists.classes

import scala.annotation.tailrec

class Example {

  def executeExamples(): Unit = {
    listOperation()
    println("----------------------------------------------------------------------------")
    insertionSort()
    println("----------------------------------------------------------------------------")
    listPattern()
    println("----------------------------------------------------------------------------")
    firstOrderMethodsOfListClass()
    println("----------------------------------------------------------------------------")
    higherOrderMethodsOfLisClass()
    println("----------------------------------------------------------------------------")
    methodsOfListObject()
    println("----------------------------------------------------------------------------")
    MultiListProcess()
    println("----------------------------------------------------------------------------")
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

  def firstOrderMethodsOfListClass(): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = list1 ::: list2
    val list4 = List(list1, list2)
    val stringList: List[String] = List("a", "b", "c", "d")
    val fruits = List("Apple", "Orange", "Pear")
    val unsorted = List(13, 5, 313, 24, 1, 65, 7, 79)

    concat()
    size()
    elements()
    backwards()
    prefixSufix()
    elementSelection()
    flattening()
    zip()
    display()
    convert()
    sortWithMerge()

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
      println(s"Flattened $fruits chars: ${fruits.map(_.toCharArray).flatten}")
    }

    def zip(): Unit = {
      val stringZipped = stringList.indices zip stringList

      println(s"Zipping $stringList and ${stringList.indices.toList}: ${stringZipped}")
      println(s"Zipping $fruits with method .zipWithIndex: ${fruits.zipWithIndex}")
      println(s"Unzipping ${stringZipped}: ${stringZipped.unzip}")
    }

    def display(): Unit = {
      val sb = new StringBuilder

      println(s"$list3 toString: ${list3.toString}")
      println(list3 mkString(s"->[", " - ", "]<-"))
      println(list3 mkString)
      println(list3.addString(sb, "->{", ";", "}<-"))
    }

    def convert(): Unit = {
      val arr: Array[Int] = list3.toArray
      val arr2: Array[Int] = new Array[Int](10)
      val it = fruits.iterator
      list3.copyToArray(arr2, 3, 3)

      println(s"${arr.mkString("Array(", ", ", ")")} is an array now")
      println(s"Back to list: ${arr.toList}")
      println(s"Copied part of $list3 to Array: ${arr2.mkString("Array(", ", ", ")")}")
      println(s"Using iterator on $fruits: ${it.next} -> ${it.next} -> ${it.next}")
    }

    def sortWithMerge(): Unit = {

      def msort[T](xs: List[T])
                  (less: (T, T) => Boolean) : List[T] = {

        def merge(xs: List[T], ys: List[T]): List[T] =
          (xs, ys) match {
            case (Nil, _) => ys
            case (_, Nil) => xs
            case (x :: xs1, y :: ys1) =>
              if (less(x, y)) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }

        val n = xs.length / 2
        if (n == 0) xs
        else {
          val (ys, zs) = xs splitAt n
          merge(msort(ys)(less), msort(zs)(less))
        }
      }

      val sortedList = msort(unsorted)(_ < _)
      val reverseSortedList = msort(unsorted)(_ > _)
      println(s"Sorted list $sortedList with method msort")
      println(s"Reverse sorted list $reverseSortedList with method msort")
    }
  }

  def higherOrderMethodsOfLisClass(): Unit = {
    val myIntList = List(1, 2, 3, 4, 5, 6)
    val myStringList = List("the", "quick", "brown", "fox")
    val myUnsortedList = List(5, 45, 6, 87, 1, 645, 12)

    mappingOver()
    filtering()
    predicatesOver()
    folding()
    sorting()

    def mappingOver(): Unit = {

      /*

      Block used to check the diference between map and flatMap:

      val isMap = myIntList map (i => List.range(1,i))
      val isMap2 = myIntList map (i => List.range(1,i) map (j => (i,j)))
      val isFlatMap = myIntList flatMap  (i => List.range(1,i) map (j => (i,j)))
      println(isMap)
      println(isMap2)
      println(isFlatMap)

      */

      val flatMapWithIndexOf = myStringList flatMap (s => s.toCharArray map (j => (j, s.indexOf(j))))
      var sum = 0
      myIntList.foreach(sum += _)

      println(s"Mapping $myIntList to sum 1 to each value: ${myIntList map (_ + 1)}")
      println(s"Mapping $myStringList to get the length of each value: ${myStringList map (_.length)}")
      println(s"Mapping $myStringList to reverse each value: ${myStringList map (_.toArray.reverse.mkString)}")
      println(s"FlatMapping $myStringList to get the index of each letter: $flatMapWithIndexOf")
      println(s"Sum up all values from $myIntList with foreach: $sum")
    }

    def filtering(): Unit = {
      println(s"Filtering even numbers from $myIntList: ${myIntList filter (_ % 2 == 0)}")
      println(s"Partitioning numbers from $myIntList: ${myIntList partition (_ % 2 == 0)}")
      println(s"Finding 'quick' from $myStringList: ${myStringList find (_ == "quick")}") // Returns None if no element matches the predicate
      println(s"Take while lesser than 3 from $myIntList: ${myIntList takeWhile (_ < 3)}")
      println(s"Drop while lesser than 3 from $myIntList: ${myIntList dropWhile (_ < 3)}")
      println(s"Span $myIntList from value 3: ${myIntList span (_ < 3)}") // (takeWhile, dropWhile)
    }

    def predicatesOver(): Unit = {
      println(s"All element from $myIntList are greater than zero: ${myIntList forall (_ > 0)}")
      println(s"There are elements greater than 6 in $myIntList: ${myIntList exists (_ > 6)}")
    }

    def folding(): Unit = {
      println(s"foldLeft $myStringList to concatenate each element with the next: ${myStringList.foldLeft("At the beginning ->")(_ + " " + _)}")
      println(s"foldRight $myStringList to concatenate each element with the next: ${myStringList.foldRight("<- At the end")(_ + " " + _)}")
      println(s"Reverse $myIntList with foldLeft: ${reverse(myIntList)}")

      def reverse[T](list: List[T]): List[T] = {
        list.foldLeft(List[T]()) { (newList, elem) => elem :: newList }
      }
    }

    def sorting(): Unit = {
      println(s"Sorting $myUnsortedList in ascending order: ${myUnsortedList.sortWith(_ < _)}")
      println(s"Sorting $myStringList in descending order: ${myStringList.sortWith(_ > _)}")
    }
  }

  def methodsOfListObject(): Unit = {
    println(s"Apply: ${List.apply(1, 2, 3, 4)}")
    println(s"Range: ${List.range(2, 10, 2)}")
    println(s"Fill 1D: ${List.fill(5) {"X"}}")
    println(s"Fill 2D: ${List.fill(2, 5) {"X"}}")
    println(s"Tabulate: ${List.tabulate(5)(x => x + x)}")
    println(s"Concatenate: ${List(1, 2, 3) concat List(4, 5, 6)}")
  }

  def MultiListProcess(): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(10,20,30)
    val zipMapList = (list1 lazyZip list2) map (_ * _)
    val forAllList = (list1 lazyZip list2) forall(_ < _)
    val existsList = (list1 lazyZip list2) exists (_ * 100 < _)

    println(s"Zip and Map from lists $list1 and $list2: $zipMapList")
    println(s"Zip and forAll from lists $list1 and $list2: $forAllList")
    println(s"Zip and exists from lists $list1 and $list2: $existsList")
  }
}
