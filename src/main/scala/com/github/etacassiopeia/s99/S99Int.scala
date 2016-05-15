package com.github.etacassiopeia.s99

/**
  * <h1>S99Int</h1>
  * The S99Int 
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 4/05/16 
  */

class S99Int(val start: Int) {

  import S99Int._

  def isPrime: Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })

  def isCoprimeTo(n: Int) = {
    import P32.gcd
    gcd(start, n) == 1
  }

  def totient: Int = (1 to start).count(isCoprimeTo(_))

  def totientImproved: Int = {
    primeFactorMultiplicity.foldLeft(1) { (t, pf) =>
      pf match {
        case (p, m) => (t * (p - 1) * Math.pow(p, m - 1)).toInt
      }
    }
  }

  def primeFactors: List[Int] = {
    assert(start > 1, "number must be a positive integer")

    primes takeWhile {
      _ <= Math.sqrt(start)
    } find (start % _ == 0) match {
      //is there a solution to assign `start`/x to a variable and reuse it?
      case Some(x) if !(start / x).isPrime => List(x) ::: (start / x).primeFactors
      case Some(x) => List(x) ::: List(start / x)
      case _ => List()
    }
  }

  def primeFactorMultiplicity: Map[Int, Int] = {
    primeFactors.groupBy(x => x).map(x => (x._1, x._2.length))
  }

}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  val primes = 2 #:: (Stream.from(3, 2) filter {
    _.isPrime
  })

  val positiveIntegers: Stream[Int] = 1 #:: positiveIntegers.map(_ + 1)
}
