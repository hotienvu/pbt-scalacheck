package com.htvu.pbt

import org.scalatest.PropSpec
import org.scalatest.prop.{Checkers}
import org.scalacheck.Prop._

class SortedPropertyTest extends PropSpec with Checkers {
  property("every element is less than or equal to the next element in the sorted list") {
    check(
      forAll { xs: List[Int] => (!xs.isEmpty) ==>  {
        classify (xs.size > 1000, "large") {
          classify(xs.contains(Int.MaxValue) || xs.contains(Int.MinValue), "boundary") {
            val sorted = xs.sorted
            sorted.indices.tail.forall(i => sorted(i-1) <= sorted(i))
          }
        }
      }}
    )
  }

  property("sorted list contains the same elements") {
    check(
      forAll { xs: List[Int] => {
        val sorted = xs.sorted
        sorted.length == xs.length && xs.forall(x => sorted.contains(x))
      }}
    )
  }
}
