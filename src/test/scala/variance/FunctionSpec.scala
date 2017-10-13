package variance

import kingdom.animalia.vertebrate.Vertebrate
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.primate.Primate
import kingdom.animalia.vertebrate.mammal.primate.homo.Homo
import org.scalatest.{FreeSpec, Matchers}

class FunctionSpec extends FreeSpec with Matchers {

  import Fixture._

  "Test 1: We can assign a function fromVertebrateToHomo to a function fromMammalToPrimate " in {
    fromMammalToPrimate = fromVertebrateToHomo

    // But we cannot do the following without ending with a compilation error:

    //fromMammalToPrimate = fromMammalToMammal
    //fromMammalToPrimate = fromPrimateToPrimate
  }

  "Test 2: We can pass fromVertebrateToHomo to promoteToPrimate" in {
    val primate1: Primate = promoteToPrimate(new Mammal, fromMammalToPrimate)
    val primate2: Primate = promoteToPrimate(new Mammal, fromVertebrateToHomo)
    val primate3: Primate = promoteToPrimate(new Primate(), fromMammalToPrimate)
    val primate4: Primate = promoteToPrimate(new Homo(), fromVertebrateToHomo)

    // This won't compile because fromPrimateToPrimate IS NOT a subtype of fromMammalToPrimate
    // And the reason is that the argument is not contravariant of Mammal
    // (or in other words, NOT ALL mammals are primates)
    //
    // promoteToPrimate(new Mammal(), fromPrimateToPrimate)

    // This won't compile because fromVertebrateToMammal IS NOT a subtype of fromMammalToPrimate
    // And the reason is that the returned type is not covariant of Primate
    // (or in other words, NOT ALL mammals are primates)
    //
    // promoteToPrimate(new Mammal(), fromVertebrateToMammal)

  }

  "Test 3: Even if fromAnyRefToInt is a supertype of fromStringToInt that does NOT implies that: " - {

    val stringLength = calculateStringLength("string", fromStringToInt)
    val anyRefLength = calculateStringLength("string", fromAnyRefToInt)

    stringLength shouldBe 6
    anyRefLength shouldBe -5

    "we can assign an istance of the child function to its parent function" - {

      // fromAnyRefToInt is a supertype of fromStringToInt hence:
      fromStringToInt = fromAnyRefToInt

      val newStringLength = calculateStringLength("string", fromStringToInt)

      "AND expect the same result" in {
        stringLength == newStringLength shouldBe false
        newStringLength shouldBe -5
        stringLength shouldBe 6
      }
    }
  }

  /*"Test 4: Variance as defined for Function, preserve : " - {

  }*/


}

object Fixture {

  def promoteToPrimate(m: Mammal, f: Mammal => Primate): Primate = f(m)

  def calculateStringLength(s: String, f: String => Int): Int = f(s)

  var fromMammalToPrimate: Function1[Mammal, Primate] = new Function1[Mammal, Primate] {
    def apply(x: Mammal): Primate = new Primate()
  }

  val fromVertebrateToHomo: Function1[Vertebrate, Homo] = new Function1[Vertebrate, Homo] {
    def apply(x: Vertebrate): Homo = new Homo()
  }

  val fromVertebrateToMammal: Function1[Vertebrate, Mammal] = new Function1[Vertebrate, Mammal] {
    def apply(x: Vertebrate): Mammal = new Mammal()
  }

  val fromPrimateToPrimate: Function1[Primate, Primate] = new Function1[Primate, Primate] {
    def apply(x: Primate): Primate = x
  }

  var fromStringToInt: Function1[String, Int] = new Function1[String, Int] {
    def apply(x: String): Int = x.length
  }

  var fromAnyRefToInt: Function1[AnyRef, Int] = new Function1[AnyRef, Int] {
    def apply(x: AnyRef): Int = -5
  }


}
