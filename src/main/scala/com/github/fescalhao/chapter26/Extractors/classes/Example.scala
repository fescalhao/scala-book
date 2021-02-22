package com.github.fescalhao.chapter26.Extractors.classes

import com.github.fescalhao.chapter26.Extractors.objects.{Domain, Email, ExtendedEmail, Twice, UpperCase}

class Example {

  def executeExamples(): Unit = {
    println("------------------------------ Email ------------------------------")
    email()
    println("\n----------------------------- Twice -------------------------------")
    twice()
    println("\n-------------------------- userTwiceUpper -------------------------")
    userTwiceUpper()
    println("\n-------------------------- isTomInDotCom --------------------------")
    isTomInDotCom()
    println("\n-------------------------- extendedEmail --------------------------")
    extendedEmail()
    println("\n--------------------------- decimalRegex --------------------------")
    decimalRegex()
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

  def isTomInDotCom(): Unit = {

    def check(email: String): Boolean = {
      email match {
        case Email("tom", Domain("com", _*)) => true
        case _ => false
      }
    }

    println(s"tom@hotmail.com -> ${check("tom@hotmail.com")}")
    println(s"john@hotmail.com -> ${check("john@hotmail.com")}")
    println(s"tom@hotmail.org -> ${check("tom@hotmail.org")}")
  }

  def extendedEmail(): Unit = {
    val email = "myUser@this.is.my.domain.com"
    val ExtendedEmail(user, topDomain, subDomain @ _*) = email
    println(s"Email: $email")
    println(s"\tuser: $user")
    println(s"\ttopDomain: $topDomain")
    println(s"\tsubDomain: $subDomain")
  }

  def decimalRegex(): Unit = {
    // .r = new Regex()
    val Decimal = """(-)?(\d+)(\.\d*)?""".r
    val input = "99 to -1.0 by -3"

    for (s <- Decimal findAllIn input)
      println(s)

    println("-------------")
    val Decimal(sign, intPart, decPart) = "-12.56"
    println(s"sign: $sign")
    println(s"intPart: $intPart")
    println(s"decPart: $decPart")

    println("-------------")
    for (Decimal(s, i, d) <- Decimal findAllIn input) {
      println(s"sign: $s | intPart: $i | decPart: $d")
    }
  }
}
