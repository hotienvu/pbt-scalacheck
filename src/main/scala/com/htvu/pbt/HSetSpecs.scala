package com.htvu.pbt

import org.scalacheck.{Gen, Commands}

object HSetSpecs extends Commands {
  // system under test
  private val hset = new HSet[Int]()

  case class State(set: Set[Int])

  def initialState() = {
    hset.clear()
    State(Set())
  }

  case class Add(v: Int) extends Command {
    def nextState(s: State): State = State(s.set + v)

    def run(s: State): Boolean =  hset.add(v)
  }

  case class Remove(v: Int) extends Command {
    def nextState(s: State): State = State(s.set - v)

    def run(s: State): Boolean = hset.remove(v)
  }

  case class Contains(v: Int) extends Command {
    def nextState(s: State): State = s

    def run(s: State): Boolean = hset.contains(v)

    postConditions += {
      case (s0, s1, r:Boolean) => r == s0.set.contains(v)
      case _ => false
    }
  }

  private val genIntCurried = (Gen.chooseNum[Int] _).curried(Int.MinValue)(Int.MaxValue)
  private val genInt = genIntCurried(Seq())
  private def genIntWithSpecials: Seq[Int] => Gen[Int] = xs => genIntCurried(xs)

  private val genAdd: Gen[Add] = genInt.map(Add)
  private val genRemove: Gen[Remove] = genInt.map(Remove)
  private def genRemoveExisting(s: State) = genIntWithSpecials(s.set.toSeq).map(Remove)
  val genContains: Gen[Contains] = genInt.map(Contains)
  private def genContainsExisting(s: State): Gen[Contains] = genIntWithSpecials(s.set.toSeq).map(Contains)

  def genCommand(s: HSetSpecs.State): Gen[HSetSpecs.Command] = Gen.oneOf(genAdd, genRemove, genRemoveExisting(s), genContains, genContainsExisting(s))
}

object HSetCheck extends App {
  HSetSpecs.check
}
