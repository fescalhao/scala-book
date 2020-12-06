package com.github.fescalhao.chapter19.Type_Parameterization.classes

class Publication(val title: String)
class Book(val bookTitle: String) extends Publication(bookTitle)

object Library {
  val books: Set[Book] = Set(
    new Book("Programming in Scala"),
    new Book("The Dark Tower"),
    new Book("The Lord Of The Rings")
  )

  def printBookList(info: Book => AnyRef): Unit = {
    for (book <- books)
      println(info(book))
  }
}
