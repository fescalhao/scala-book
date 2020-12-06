package com.github.fescalhao.chapter19.Type_Parameterization

import com.github.fescalhao.chapter19.Type_Parameterization.classes.{Library, Person, Publication, Queue, Sort}

object Application extends App {
  println("---------------------------------- Queue ----------------------------------")
  val list1 = Queue(1, 2, 3, 4, 5, 6)
  println(list1.head)
  println(list1.tail)
  println(list1.enqueue(6))

  println("------------------------------- Book Example ------------------------------")
  def getTitle(p: Publication): String = p.title
  Library.printBookList(getTitle)

  println("------------------------------- Person / Sort -----------------------------")
  val personList = List[Person](
      new Person("Larry", "Wall"),
      new Person("Anders", "Hejlsberg"),
      new Person("Guido", "van Rossum"),
      new Person("Alan", "Key"),
      new Person("Yukihiro", "Matsumoto"),
  )

  val sortThings = new Sort
  val sortedPerson: String = sortThings.orderedMergeSort(personList).mkString("\n\t","\n\t", "")
  println(s"Sorted personList: ${sortedPerson}")
}
