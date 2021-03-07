package com.github.fescalhao.chapter32.Futures_And_Concurrency.classes

import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}

class Example {
  def executeExamples(): Unit = {
    println("------------------------------- Working with Futures -------------------------------")
    futures()
    println("\n-------------------- Transforming Futures with FOR expressions ---------------------")
    futuresFor()
    println("\n--------------------- Failed, Successful, FromTry and Promises ---------------------")
    creatingTheFuture()
    println("\n-------------------------------- Filter and Collect --------------------------------")
    filterCollect()
    println("\n--------------------- Failed, FallbackTo, Recover and RecoverWith ---------------------")
    dealingWithFailure()
    println("\n------------------------------------ Transform -------------------------------------")
    transform()
    println("\n------------------- Zip, FoldLeft, ReduceLeft, Sequence and Traverse ------------------")
    futureZip()
    println("\n------------------- Foreach, OnComplete and AndThen ------------------")
    sideEffects()
    println("\n------------------- Testing with Futures ------------------")
    testingFuture()
  }

  def futures(): Unit = {
    val fut = Future {
      Thread.sleep(5000)
      21 + 21
    }

    val result = {
      fut.map(x => x + 1)
    }

    println(s"Result: ${result.value}")
  }

  def futuresFor(): Unit = {
    /*
     For expressions serialize their transformations.
     Create the 'Futures' before the expressions so they can run in parallel.
     The code bellow will take at least twice as long to execute:

     val result = for {
        x <- Future { Thread.sleep(5000); 21 + 21 }
        y <- Future { Thread.sleep(5000); 23 + 23 }
     } yield x + y

    */

    val fut1 = Future {
      Thread.sleep(5000)
      21 + 21
    }
    val fut2 = Future {
      Thread.sleep(5000)
      23 + 23
    }

    val result = for {
      x <- fut1
      y <- fut2
    } yield x + y

    println(s"Result: ${result.value}")
  }

  def creatingTheFuture(): Unit = {
    val pro = Promise[Int]
    val fut = pro.future
    fut.value
    pro.success(42)
    fut.value


    Future.successful { 21 + 21 }
    Future.failed { new Exception("Bummer!") }
    Future.fromTry(Success { 21 + 21 })
    Future.fromTry(Failure { new Exception("Bummer!") })
  }

  def filterCollect(): Unit = {
    val fut = Future { 42 }
    val valid = fut.filter(res => res > 0)
    val invalid = fut.filter(res => res < 0)
    val collectValid = fut collect { case res if res > 0 => res + 10}
    val collectInvalid = fut collect { case res if res < 0 => res + 10}

    println(s"Valid: ${valid.value}")
    println(s"Invalid: ${invalid.value}")
    println(s"Collect valid: ${collectValid.value}")
    println(s"Collect invalid: ${collectInvalid.value}")
  }

  def dealingWithFailure(): Unit = {
    val failure = Future { 42 / 0 }
    val expectedFailure = failure.failed
    val success = Future { 42 / 1 }
    val fallback = failure.fallbackTo(success)
    val recovered = failure recover {
      case ex: ArithmeticException => -1
    }
    val alsoRecovered = failure recoverWith {
      case ex: ArithmeticException => Future { 100 + 100 }
    }

    println(s"Failure: ${failure.value}")
    println(s"Expected failure: ${expectedFailure.value}")
    println(s"Fallback to success: ${fallback.value}")
    println(s"Recover: ${recovered.value}")
    println(s"Also Recover: ${alsoRecovered.value}")
  }

  def transform(): Unit = {
    val success = Future { 42 / 1 }
    val failure = Future { 42 / 0 }
    val first = success.transform(
      res => res * -1,
      ex => new Exception("see cause", ex)
    )

    val second = failure.transform(
      res => res * -1,
      ex => new Exception("see cause", ex)
    )

    val nonNegative = failure.transform {
      case Success(res) => Success(res.abs + 1)
      case Failure(_) => Success(0)
    }

    println(s"Transform 1: ${first.value}")
    println(s"Transform 2: ${second.value}")
    println(s"Transform 3: ${nonNegative.value}")
  }

  def futureZip(): Unit = {
    val failure = Future { 42 / 0 }
    val success = Future { 42 / 1 }
    val recovered = failure recover {
      case ex: ArithmeticException => -1
    }
    val zippedSuccess = success zip recovered
    val zippedFailure = success zip failure
    val fortyTwo = Future { 21 + 21 }
    val fortySix = Future { 23 + 23 }
    val futureNums = List(fortyTwo, fortySix)
    val folded = Future.foldLeft(futureNums)(0){
      (acc, num) => acc + num
    }
    val futureList = Future.sequence(futureNums) // List[Future[Int]] to Future[List[Int]]
    val traversed = Future.traverse(List(1,2,3)){ i => Future(i)}

    println(s"Zipped: ${zippedSuccess.value}")
    println(s"Failed zip: ${zippedFailure.value}")
    println(s"FoldLeft: ${folded.value}")
    println(s"Sequence: ${futureList.value}")
    println(s"Traversed: ${traversed.value}")
  }

  def sideEffects(): Unit = {
    val failure = Future { 42 / 0 }
    val success = Future { 42 / 1 }

    failure.foreach(ex => println(ex))

    failure onComplete {
      case Success(res) => println(res)
      case Failure(ex) => println(ex)
    }

    success onComplete {
      case Success(res) => println(res)
      case Failure(ex) => println(ex)
    }

    // Guarantee success will be executed first
    success andThen {
      case Success(res) => println(res)
      case Failure(ex) => println(ex)
    }
  }

  def testingFuture(): Unit = {
    val fut = Future {
      Thread.sleep(5000)
      21 + 21
    }

    val await = Await.result(fut, 15.seconds) // blocks

    println(s"Testing 1: ${await should be (42)}")
    println(s"Testing 2: ${fut.futureValue should be (42)}")
  }
}
