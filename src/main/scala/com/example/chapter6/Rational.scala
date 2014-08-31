package com.example.chapter6

object Rational {
  def apply(n: Int, d: Int) = new Rational(n, d)
  def apply(n: Int) = new Rational(n, 1)
}

class Rational(n: Int, d: Int) {
  // 実装が足りなかった部分
  require(d != 0)

  private val gcd = calGCD(n, d)
  private val sign = n * d / (n * d).abs

  // fields
  val numerator = sign * n.abs / gcd
  val denominator = d.abs / gcd

  // methods
  def unary_+ = this
  def unary_- = new Rational(-numerator, denominator)

  override def toString = s"$numerator / $denominator"

  override def hashCode = (numerator + 31) * 31 + denominator

  override def equals(other: Any) = other match {
    case r: Rational =>
      r.isInstanceOf[Rational] && numerator == r.numerator && denominator == r.denominator
    case _ => false
  }

  def inverse = new Rational(denominator, numerator)

  def +(r: Rational) = {
    val n = numerator * r.denominator + r.numerator * denominator
    new Rational(n, denominator * r.denominator)
  }

  def -(r: Rational) = this + (-r)

  def *(r: Rational) = {
    val n = numerator * r.numerator
    val d = denominator * r.denominator

    new Rational(n, d)
  }

  def /(r: Rational) = this * r.inverse

  // 最大公約数
  private def calGCD(x: Int, y: Int): Int = {
    if(y == 0) x.abs else calGCD(y.abs, (x % y).abs)
  }

}
