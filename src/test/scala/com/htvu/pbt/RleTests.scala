package com.htvu.pbt

import org.scalatest.PropSpec
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import Pbt._

class RleTests extends PropSpec with Checkers {

  property("should maintain the total count") {
    check(
      forAll{xs: List[Int] => {
        val compressed = xs.rle
        compressed.map(_._2).sum === xs.size
      }}
    )
  }

  property("should ") {
    check(
      forAll{ (xs: List[Int], count: Byte) => (count > 0) ==> {
        val uncompressed = xs.flatMap(List.fill(count)(_))
        val compressed = uncompressed.rle
        compressed === xs.map((_, count))
      }}
    )
  }
}
