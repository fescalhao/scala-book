package com.github.fescalhao.chapter23.For_Expressions_Revisited.classes

class Example {
  def executeExamples(): Unit = {
    println("--------------------------- Filter Person ---------------------------")
    filterPerson()
    println("--------------------------- Queens Problem ---------------------------")
    queensProblem()
    println("--------------------------- Querying Books ---------------------------")
    queryingBook()
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
    val books: List[Book] = List (
      Book("Structure and Interpretation of Computer Programs", "Abelson, Harold", "Sussman, Gerald J."),
      Book("Principles of Compiler Design", "Aho, Alfred", "Ullman, Jeffrey"),
      Book("Programming in Modula-2", "Wirth, Niklaus"),
      Book("Elements of ML Programming", "Ullman, Jeffrey"),
      Book("The Java Language Specification", "Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")
    )

    def removeDuplicates[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) Nil
      else {
        xs.head :: removeDuplicates(
          xs.tail filter(x => x != xs.head)
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
    println("----- Filtered books whos authors have written at least 2 books -----")
    println(removeDuplicates(filteredBooksAtLeastTwoBooks).mkString("\n"))
  }
}
