// Assertions and Tests

package com.github.fescalhao.chapter14.Assertions_And_Tests.classes.test

import com.github.fescalhao.chapter10.Composition_And_Inheritance.impl.ElementFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ElementSpec extends AnyFlatSpec with Matchers {
  "A UnitformElement" should
    " have a width equal to the passed value" in {
    val ele = ElementFactory.elem('x', 3, 2)
    ele.width should be (2)
  }

  it should "have a height equal to the passed value" in {
    val ele = ElementFactory.elem('x', 3, 2)
    ele.height should be (3)
  }

  it should "throw an IAE if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      ElementFactory.elem('x', 3, -2)
    }
  }
}
