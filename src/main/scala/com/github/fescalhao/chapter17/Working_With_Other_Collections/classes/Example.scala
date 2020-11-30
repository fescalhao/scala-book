package com.github.fescalhao.chapter17.Working_With_Other_Collections.classes

import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class Example {

  def executeExamples(): Unit = {
    sequences()
    println("----------------------------------------------------------------------------")
    setAndMaps()
    println("----------------------------------------------------------------------------")
  }

  private def sequences(): Unit = {

    lists()
    arrays()
    listBuffers()
    arrayBuffers()
    stringOps()


    def lists(): Unit = {
      val colors = List("red", "blue", "yellow", "green")
      println(s"$colors has head = ${colors.head} and tail = ${colors.tail}")
    }

    def arrays(): Unit = {
      val fiveInts = Array[Int](5)
      val fiveToOne = Array(5, 4, 3, 2, 1)
      fiveInts(0) = fiveToOne(4)
      println(s"When you know the array's size but not the elements: ${fiveInts.mkString("Array(", ", ", ")")}")
      println(s"When you know the array's elements: ${fiveToOne.mkString("Array(", ", ", ")")}")
    }

    def listBuffers(): Unit = {
      val buf = new ListBuffer[Int]
      buf += 1
      buf += 2
      0 +=: buf
      -1 +=: buf

      println(buf)
    }

    def arrayBuffers(): Unit = {
      val arrBuf = new ArrayBuffer[String]()
      arrBuf += "c"
      arrBuf += "d"
      "b" +=: arrBuf
      "a" +=: arrBuf

      println(s"$arrBuf has length of ${arrBuf.length} and element at index 2 is ${arrBuf(2)}")
    }

    def stringOps(): Unit = {

      val name = "Bruce Wayne"

      def hasUpperCase(s: String): Boolean = {
        s.exists(_.isUpper)
      }

      println(s"$name has a uppercase letter: ${hasUpperCase(name)}")
    }
  }

  private def setAndMaps(): Unit = {

    println("----------- Set -----------")
    sets()
    println("----------- Map -----------")
    maps()
    println("--------- Sorting ---------")
    sorting()

    def sets(): Unit = {
      val text = "See Spot run. Run, Spot. Run!"
      val wordsArray = text.split("[ !,.]+")
      val words = mutable.Set.empty[String]
      val mySet = Set(1, 2, 3)
      val mySet2 = Set(3, 4, 5)

      wordsArray.foreach(w => {
        words += w.toLowerCase
      })

      println(s"${wordsArray.mkString("Array(", ", ", ")")} converted to mutable.Set: $words")
      println(s"Adding 5 to $mySet: ${mySet + 5} -> Returns a new Set")
      println(s"Removing 3 from $mySet: ${mySet - 3} -> Returns a new Set")
      println(s"Adding 6 and 7 to $mySet: ${mySet ++ List(6, 7)} -> Returns a new Set")
      println(s"Removing 1 and 2 from $mySet: ${mySet -- List(1, 2)} -> Returns a new Set")
      println(s"Intersection of $mySet and $mySet2: ${mySet & mySet2} -> Returns a new Set")
      println(s"$mySet size: ${mySet.size}")
      println(s"$mySet contains element 3: ${mySet.contains(3)}")
      println(s"Adding 'dog' to $words: ${words += "dog"}")
      println(s"Removing 'dog' from $words: ${words -= "dog"}")
      println(s"Adding 'fish' and 'bird' to $words: ${words ++= List("fish", "bird")}")
      println(s"Removing 'fish' and 'bird' from $words: ${words --= List("fish", "bird")}")
      println(s"Removing all elements from $words: ${words.clear()}")
    }

    def maps(): Unit = {
      val myText = "See Spot run. Run, Spot. Run!"
      val myMap = Map[Int, String](
        1 -> "Apple",
        2 -> "Orange",
        3 -> "Pear"
      )
      val myMutableMap = mutable.Map(
        "one" -> 1,
        "two" -> 2,
        "three" -> 3
      )

      println(s"Number of times each word appears in '$myText': ${countWords(myText)}")
      println(s"Adding 'Lemon' to $myMap: ${myMap + (4 -> "Lemon")} -> Returns a new Map")
      println(s"Removing key 3 from $myMap: ${myMap - 3} -> Returns a new Map")
      println(s"Adding 'Lemon' and 'Pineapple' to $myMap: ${myMap ++ List(4 -> "Lemon", 5 -> "Pineapple")} -> Returns a new Map")
      println(s"Removing keys 1 and 2 from $myMap: ${myMap -- List(1, 2)} -> Returns a new Map")
      println(s"$myMap size: ${myMap.size}")
      println(s"$myMap contains key 3: ${myMap.contains(3)}")
      println(s"$myMap keys: ${myMap.keys} -> Iterable[K]")
      println(s"$myMap keySet: ${myMap.keySet} -> Set[K]")
      println(s"$myMap values: ${myMap.values} -> Iterable[V]")
      println(s"$myMap is empty: ${myMap.isEmpty}")
      println(s"Adding 4 to $myMutableMap: ${myMutableMap += ("four" -> 4)}")
      println(s"Removing 2 from $myMutableMap: ${myMutableMap -= "two"}")
      println(s"Adding 5 and 6 to $myMutableMap: ${myMutableMap ++= List("five" -> 5, "six" -> 6)}")
      println(s"Removing 1 and 3 from $myMutableMap: ${myMutableMap --= List("one", "three")}")

      def countWords(text: String): mutable.Map[String, Int] = {
        val count = mutable.Map.empty[String, Int]
        text.toLowerCase.split("[ !,.]+").foreach(word => {
          val wordCount =
            if (count.contains(word)) count(word)
            else 0
          count += (word -> (wordCount + 1))
        })
        count
      }
    }

    def sorting(): Unit = {
      val treeSet = TreeSet(4, 6, 2, 7, 9, 1, 3, 2, 5)
      val treeMap = TreeMap(3 -> "a", 1 -> "c", 2 -> "b")

      println(s"Ordered Set: $treeSet")
      println(s"Ordered Map: $treeMap")
    }
  }
}
