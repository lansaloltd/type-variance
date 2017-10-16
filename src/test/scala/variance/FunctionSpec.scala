package variance

import kingdom.animalia.Animal
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

  "Test 4: Variance and function composition : " - {
    //f(x) compose g(x) -> f(g(x))

    // We can clearly compose this way
    val fromVertebrateToPrimate: Vertebrate => Primate = fromVertebrateToMammal andThen fromMammalToPrimate

    // Because Function is contravariant on its argument, we CAN replace
    // fromMammalToPrimate with a function that takes as a argument a parent of Mammal
    // (in this example Vertebrate which is a supertype of Mammal)
    val fromVertebrateToMammal1: Vertebrate => Mammal = fromVertebrateToMammal andThen fromVertebrateToMammal

    // We can also take advantage that the Function type is covariant in its return type
    // so if consider our first compose function: fromVertebrateToMammal andThen fromMammalToPrimate
    // we CAN replace fromVertebrateToMammal with a function that returns a child of Mammal (Homo is
    // indeed a supertype of Mammal)

    val fromVertebrateToPrimate2: Vertebrate => Primate = fromVertebrateToHomo andThen fromMammalToPrimate

    // But we CANNOT make the argument of fromMammalToPrimate covariant. If we use a child of Mammal
    // (like the supertype Primate in this example) that WILL NOT compile because fromPrimateToPrimate
    // is not defined for the whole Mammals' domain. In other worlds, if we pass a puff fish (which is
    // a vertebrate) to fromVertebrateToMammal, this function might return a Rhinoceros (which is a mammal
    // but NOT a primate). So, what is our function fromPrimateToPrimate supposed to do with a rhinoceros?

    //fromVertebrateToMammal andThen fromPrimateToPrimate


    // NOR we can make the return type contravariant for analogous considerations.
    // Let's consider the initial composite function fromVertebrateToMammal andThen fromMammalToPrimate:
    // If we try to make the return type of fromVertebrateToMammal contravariant, we have to pick up a parent
    // of Mammal (for example Animal, which is a super type of Mammal) and replace fromVertebrateToMammal with
    // fromVertebrateToAnimal, but the following WILL NOT compile. What about if I pass a puff fish to fromVertebrateToAnimal
    // and this one returns a jellyfish, which is an animal but definitely not a mammal. fromMammalToPrimate is not defined
    // for jellyfishes and would break

    //fromVertebrateToAnimal andThen fromMammalToPrimate


  }


}

object Fixture {

  def promoteToPrimate(m: Mammal, f: Mammal => Primate): Primate = f(m)

  def calculateStringLength(s: String, f: String => Int): Int = f(s)

  var fromMammalToPrimate: Mammal => Primate = new Function1[Mammal, Primate] {
    def apply(x: Mammal): Primate = new Primate()
  }

  val fromVertebrateToHomo: Vertebrate => Homo = new Function1[Vertebrate, Homo] {
    def apply(x: Vertebrate): Homo = new Homo()
  }

  val fromVertebrateToMammal: Vertebrate => Mammal = new Function1[Vertebrate, Mammal] {
    def apply(x: Vertebrate): Mammal = new Mammal()
  }

  val fromVertebrateToAnimal: Vertebrate => Animal = new Function1[Vertebrate, Animal] {
    def apply(x: Vertebrate): Animal = new Animal()
  }

  val fromPrimateToPrimate: Primate => Primate = new Function1[Primate, Primate] {
    def apply(x: Primate): Primate = x
  }

  var fromStringToInt: String => Int = new Function1[String, Int] {
    def apply(x: String): Int = x.length
  }

  var fromAnyRefToInt: AnyRef => Int = new Function1[AnyRef, Int] {
    def apply(x: AnyRef): Int = -5
  }


}
