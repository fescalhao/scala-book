package com.github.fescalhao.chapter26.Extractors.classes

import com.github.fescalhao.chapter26.Extractors.objects.{Email, Twice, UpperCase}

class Example {

  def executeExamples(): Unit = {
    println("------------------------------ Email ------------------------------")
    email()
    println("\n----------------------------- Twice -------------------------------")
    twice()
    println("\n-------------------------- userTwiceUpper -------------------------")
    userTwiceUpper()
  }

  def email(): Unit = {
    val email1 = Email("user1", "mydomain")
    val email2 = Email("user2", "mydomain")
    val user1 = email1 match {
      case Email(u, d) => u
      case _ => "Not found"
    }

    println(s"Email1: $email1")
    println(s"Email2: $email2")
    println(s"Unapply user3@mydomain: ${Email.unapply("user3@mydomain")}")
    println(s"User1: $user1")
  }

  def twice(): Unit = {
    val ding = "ding"
    val twice = Twice(ding)

    println(s"Twice: $twice")
  }

  def userTwiceUpper(): Unit = {
    val email = "DIdi@hotmail.com"
    val pattern = email match {
      case Email(Twice(x@UpperCase()), domain) => s"match: $x in domain $domain"
      case _ => "No match!"
    }
    println(pattern)
  }
}
