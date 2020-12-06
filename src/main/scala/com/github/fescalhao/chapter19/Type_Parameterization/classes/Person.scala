package com.github.fescalhao.chapter19.Type_Parameterization.classes

class Person(val firstName: String, val lastName: String) extends Ordered[Person] {

  override def compare(that: Person): Int = {
    val lastNameComparison = lastName.compareToIgnoreCase(that.lastName)
    if (lastNameComparison != 0)
      lastNameComparison
    else
      firstName.compareToIgnoreCase(that.firstName)
  }

  override def toString: String = s"$firstName $lastName"
}
