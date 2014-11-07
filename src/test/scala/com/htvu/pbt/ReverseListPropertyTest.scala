package com.htvu.pbt

import org.scalatest.PropSpec
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._

  class ReverseListPropertyTest extends PropSpec with Checkers {
    property("reversed list should contains the same elements") {
      check(
        forAll { xs: List[Int] => {
          xs.reverse.forall(xs.contains(_))
        }}
      )
    }

    property("applying reverse list returns the same list") {
      check(
        forAll { xs: List[Int] => {
          xs.reverse.reverse == xs
        }}
      )
    }
  }
