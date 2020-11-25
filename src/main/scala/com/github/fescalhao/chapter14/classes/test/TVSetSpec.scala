package com.github.fescalhao.chapter14.classes.test

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

class TVSetSpec extends AnyFeatureSpec with GivenWhenThen {
  Feature("TV power button") {
    Scenario("User presses power button when TV is off") {
      Given("a TV set that is seitched off")
      When("the power button is pressed")
      Then("the TV shoud switch on")
      pending
    }
  }

}
