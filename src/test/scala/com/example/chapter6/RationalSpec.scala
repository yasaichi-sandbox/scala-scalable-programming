package com.example.chapter6

import org.specs2.mutable.SpecificationWithJUnit

class RationalSpec extends SpecificationWithJUnit {

  "Rational(2, 0)" should {
    "throw IllegalArgumentException whose message is \"requirement failed\"" in {
      { Rational(2, 0) } must throwAn[java.lang.IllegalArgumentException]("requirement failed")
    }
  }

  "Rational(2)" should {
    "be equal to Rational(2, 1)" in {
      Rational(2) must_== Rational(2, 1)
    }
  }

  "Rational(1, 2)" should {
    "be equal to Rational(2, 4)" in {
      Rational(1, 2) must_== Rational(2, 4)
    }

    "be equal to Rational(-1, -2)" in {
      Rational(1, 2) must_== Rational(-1, -2)
    }

    "be equal to +Rational(1, 2)" in {
      Rational(1, 2) must_== +Rational(1, 2)
    }

    "be equal to -Rational(1, -2)" in {
      Rational(1, 2) must_== -Rational(1, -2)
    }
  }

  "Rational(1, 2).toString" should {
    "be equal to \"1 / 2\"" in {
      Rational(1, 2).toString must_== "1 / 2"
    }
  }

  "Rational(1, 2).inverse" should {
    "be equal to \"2 / 1\"" in {
      Rational(1, 2).inverse must_== Rational(2, 1)
    }
  }

  "Rational(1, 2) + Rational(1, 3)" should {
     "return Rational(5, 6)" in {
       Rational(1, 2) + Rational(1, 3) must_== Rational(5, 6)
     }
  }

  "Rational(1, 2) - Rational(1, 3)" should {
    "return Rational(1, 6)" in {
      Rational(1, 2) - Rational(1, 3) must_== Rational(1, 6)
    }
  }

  "Rational(1, 2) * Rational(1, 3)" should {
    "return Rational(1, 6)" in {
      Rational(1, 2) * Rational(1, 3) must_== Rational(1, 6)
    }
  }

  "Rational(1, 2) / Rational(1, 3)" should {
    "return Rational(3, 2)" in {
      Rational(1, 2) / Rational(1, 3) must_== Rational(3, 2)
    }
  }

}
