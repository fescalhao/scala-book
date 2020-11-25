// Assertions and Tests

package com.github.fescalhao.chapter14.classes.test

import com.github.fescalhao.chapter10.impl.ElementFactory
import org.scalatest.matchers.must.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class ElementSpec2 extends AnyWordSpec with ScalaCheckPropertyChecks {
  "elem result" must {
    "have passed width" in {
      forAll {
        (w: Int) => {
          whenever(w > 0) {
            ElementFactory.elem('x', 3, w % 100).width must equal (w % 100)
            // ElementFactory.elem('x', 3, w - 100).width must equal (w + 10) throws a TestFailedException
          }
        }
      }
    }
  }
}
