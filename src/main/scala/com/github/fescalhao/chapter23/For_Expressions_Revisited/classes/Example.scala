package com.github.fescalhao.chapter23.For_Expressions_Revisited.classes

class Example {
  def executeExamples(): Unit = {
    println("--------------------------- Filter Person ---------------------------")
    filterPerson()
    println("--------------------------- Queens Problem ---------------------------")
    queensProblem()
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
}
