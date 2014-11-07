package com.htvu.pbt

object Pbt {
  class ListOps[T](ls: List[T]) {
    def rle: List[(T, Int)] = {
      if (ls.isEmpty) Nil
      else {
        val (packed, next) = ls.span(_ == ls.head)
        (ls.head, packed.size) :: new ListOps(next).rle
      }
    }
  }

  implicit def List2ListOps[T](ls: List[T]) = new ListOps[T](ls)
}
