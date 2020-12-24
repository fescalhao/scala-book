package com.github.fescalhao.chapter23.For_Expressions_Revisited.classes

import com.github.fescalhao.chapter23.For_Expressions_Revisited.objects.Demo

class Example {
  val books: List[Book] = List(
    Book("Structure and Interpretation of Computer Programs", "Abelson, Harold", "Sussman, Gerald J."),
    Book("Principles of Compiler Design", "Aho, Alfred", "Ullman, Jeffrey"),
    Book("Programming in Modula-2", "Wirth, Niklaus"),
    Book("Elements of ML Programming", "Ullman, Jeffrey"),
    Book("The Java Language Specification", "Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")
  )

  def executeExamples(): Unit = {
    println("--------------------------- Filter Person ---------------------------")
    filterPerson()
    println("--------------------------- Queens Problem ---------------------------")
    queensProblem()
    println("--------------------------- Querying Books ---------------------------")
    queryingBook()
    println("------------------- Translation of For Expressions -------------------")
    translationOfForExpressions()
  }

  def filterPerson(): Unit = {
    val lara = Person("Lara", isMale = false)
    val bob = Person("Bob", isMale = true)
    val julie = Person("Julie", isMale = false, lara, bob)
    val personList = List(lara, bob, julie)

    val motherAndChildrenMap = {
      personList.
        withFilter(p => !p.isMale).
        flatMap(p => p.children.map(c => (p.name, c.name)))
    }

    val motherAndChildrenFor = {
      for {
        p <- personList
        if !p.isMale
        c <- p.children
      } yield (p.name, c.name)
    }

    println(s"Using filter/flatMap/map: $motherAndChildrenMap")
    println(s"Using for: $motherAndChildrenFor")
  }

  def queensProblem(): Unit = {

    def queens(size: Int): List[List[(Int, Int)]] = {

      def placeQueens(k: Int): List[List[(Int, Int)]] = {
        if (k == 0) List(List())
        else {
          for {
            queens <- placeQueens(k - 1)
            column <- 1 to size
            queen = (k, column)
            if isSafe(queen, queens)
          } yield queen :: queens
        }
      }

      def isSafe(queen: (Int, Int), queens: List[(Int, Int)]): Boolean = {
        queens forall (q => !inCheck(queen, q))
      }

      def inCheck(q1: (Int, Int), q2: (Int, Int)): Boolean = {
        q1._1 == q2._1 || // same row
          q1._2 == q2._2 || // same column
          (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal
      }

      placeQueens(size)
    }

    def format(board: List[(Int, Int)]): String = {
      val size = board.size
      val formattedBoard = for {
        i <- 1 to size
      } yield {
        val row = for {
          column <- 1 to size
          pos = if (board(size - i) == Tuple2(i, column)) "O" else "X"
        } yield pos
        row.mkString(" ")
      }
      formattedBoard.mkString("", "\n", "\n" + ("---" * size))
    }

    val n: Int = 4
    println("Every possible solution with Cardinal Points at the board")
    println("---------------------------------------------------------")
    queens(n).foreach(println(_))
    println("---------------------------------------------------------")
    println("Every possible solution with a 'image' of the board")
    println("---------------------------------------------------------")
    queens(n).foreach(q => println(format(q)))
  }

  def queryingBook(): Unit = {

    def removeDuplicates[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else {
        xs.head :: removeDuplicates(
          xs.tail filter (x => x != xs.head)
        )
      }
    }

    val filteredBooksByAuthor = for {
      b <- books
      a <- b.authors
      if a startsWith "Gosling"
    } yield b.title
    println("----- Filtered books by author -----")
    println(filteredBooksByAuthor.mkString("\n"))

    val filteredBooksByTitle = for {
      b <- books
      if b.title contains "Program"
    } yield b.title
    println("----- Filtered books by title -----")
    println(filteredBooksByTitle.mkString("\n"))

    val filteredBooksAtLeastTwoBooks = for {
      b1 <- books
      b2 <- books
      if b1.title != b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1
    println("----- Filtered books whose authors have written at least 2 books -----")
    println(removeDuplicates(filteredBooksAtLeastTwoBooks).mkString("\n"))
  }

  def translationOfForExpressions(): Unit = {

    def removeDuplicatesAgain[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else {
        xs.head :: removeDuplicatesAgain(
          xs.tail filter (x => x != xs.head)
        )
      }
    }

    val myList: List[Int] = List(1, 2, 3, 4, 5)
    val myList2: List[Int] = List(2, 4, 6)
    val myList3: List[List[Int]] = List(myList, myList2, List(7, 8), List(10))

    val for1 = for (i <- myList) yield i * 2
    val trans1 = myList map (x => x * 2)

    val for2 = for (i <- myList; if i % 2 == 0) yield i * 2
    val trans2 = myList withFilter (i => i % 2 == 0) map (_ * 2)

    val for3 = for (i <- myList; y <- myList2) yield s"$i + $y = ${i + y}"
    val trans3 = myList flatMap (i => myList2 map (y => s"$i + $y = ${i + y}"))

    val for4 = removeDuplicatesAgain(
      for {
        b1 <- books
        b2 <- books
        if b1.title != b2.title
        a1 <- b1.authors
        a2 <- b2.authors
        if a1 == a2
      } yield a1)

    val trans4 = removeDuplicatesAgain(
      books flatMap (
        b1 => books withFilter (b2 => b1.title != b2.title) flatMap (
          b2 => b1.authors flatMap (
            a1 => b2.authors withFilter (a2 => a1 == a2) map (
              _ => a1))
          )
        )
    )

    val for5 = for {
      x :: xs <- myList3
    } yield x

    val trans5 = myList3 withFilter {
      case x :: xs => true
      case _ => false
    } map {
      case x :: xs => x
    }

    val for6 = for {
      x <- myList
      y = x - 1
      if y > 2
    } yield x * y

    val trans6 = for {
      (x, y) <- for {
        x <- myList
      } yield (x, x - 1)
      if y > 2
    } yield x * y

    var sum: Int = 0
    for {
      xs <- myList3
      x <- xs
    } sum += x

    var sum2: Int = 0
    myList3 foreach (
      xs => xs foreach (
        x => sum2 += x
      )
    )

    val trans8 = Demo.myMap(
      Demo.myFilter(
        myList,
        (x: Int) => { x % 2 == 0 }
      ),
      (x: Int) => { x * 2 }
    )

    println(s"Translation 1 using for: $for1")
    println(s"Translation 1 using map: $trans1")
    println(s"Translation 2 using for: $for2")
    println(s"Translation 2 using map + withFilter: $trans2")
    println(s"Translation 3 using for: $for3")
    println(s"Translation 3 using flatMap + map: $trans3")
    println(s"Translation 4 using for: $for4")
    println(s"Translation 4 using flatMap + withFilter + map: $trans4")
    println(s"Translation 5 using for: $for5")
    println(s"Translation 5 using withFilter + match: $trans5")
    println(s"Translation 6 using for: $for6")
    println(s"Translation 6 using for + tuple: $trans6")
    println(s"Translation 7 using for with side effects: $sum")
    println(s"Translation 7 using foreach: $sum2")
    println(s"Translation 8 using filter + map to for: $trans8")
  }
}