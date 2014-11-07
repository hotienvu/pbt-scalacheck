package com.htvu.pbt

import org.scalacheck.Gen

object Generators extends App{

  case class Person(name: String, age: Int)

  sealed abstract class Tree
  case class Node(v: Int, left: Tree, right: Tree) extends Tree
  case class Leaf(v: Int) extends Tree



  val genPerson: Gen[Person] = for {
    name <- Gen.alphaStr
    age <- Gen.chooseNum(1, 100)
  } yield Person(name, age)


  val genLeaf = Gen.chooseNum(0, 10000).map(v => Leaf(v))

  val genNode = for {
    v <- Gen.chooseNum(0, 1000)
    left <- genTree
    right <- genTree
  } yield Node(v, left, right)

  val genTree: Gen[Tree] = Gen.oneOf(genLeaf, genNode)
}
