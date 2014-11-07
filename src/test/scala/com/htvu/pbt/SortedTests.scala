package com.htvu.pbt

import org.scalatest.{BeforeAndAfter, FlatSpec}

class SortedTests extends FlatSpec {
  ".sorted" should "return empty if list is empty" in {
    assert(List[Int]().sorted === Nil)
  }

  it should "sort non-empty list to ascending order" in {
    assert(List(4,2,1,3).sorted === List(1,2,3,4))
  }

  it should "return the same list if it is already sorted" in  {
    val xs = List(1,2,3,4,5,6)
    assert(xs.sorted === xs)
  }

  it should "return reversed list if it is sorted descending" in {
    val xs = List(6,5,4,3,2,1)
    assert(xs.sorted === xs.reverse)
  }
}
