package main.scala.homework

import scala.util.Random

class BallsExperiment {
  //true  - белый шар
  //false - черный
  //Найти вероятность появления белого шара если первый черный
  //P(AB) = (3/6) * (3/5) = 3/10
  var urn = true :: false :: true :: false :: true :: false :: Nil

  def isFirstBlackSecondWhite(): Boolean = {
    val firstTake = Random.nextInt(6)
    if (urn(firstTake)) {
      false
    } else {
      val secondTake = Random.nextInt(5)
      val (start, end) = urn.splitAt(firstTake)
      (start ++ end.tail) (secondTake)
    }
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 100000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment)
    val countOfExperiments = listOfExperiments.map(x => x.isFirstBlackSecondWhite())
    val countOfPositiveExperiments: Float = countOfExperiments.count(_ == true)
    println(countOfPositiveExperiments / count) // -> 0.3 те к 3/10
  }
}