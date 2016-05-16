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

  def goldbach: (Int, Int) = {
    assert(start > 2, "Start number must be greater than two")
    assert(start % 2 == 0, "Start number must be an even number")

    import P39.listPrimesInRange

    primes.takeWhile {
      _ <= start / 2
    } foreach {
      x =>
        val list = listPrimesInRange(start / 2, start)
        list.foreach {
          y =>
            if (x + y == start) return (x, y)
        }
    }

    throw new NoSuchElementException
  }

  def goldbach2: (Int, Int) = {
    assert(start > 2, "Start number must be greater than two")
    assert(start % 2 == 0, "Start number must be an even number")

    primes.takeWhile {
      _ < start
    } find (p => (start - p).isPrime) match {
      case Some(x) => (x, start - x)
      case None => throw new NoSuchElementException
    }
  }

}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  val primes = 2 #:: (Stream.from(3, 2) filter {
    _.isPrime
  })

  val positiveIntegers: Stream[Int] = 1 #:: positiveIntegers.map(_ + 1)
}
