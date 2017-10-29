package variance

import kingdom.animalia.vertebrate.Vertebrate
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.primate.Primate
import org.scalatest.{FreeSpec, Matchers}

class OptionSpec extends FreeSpec with Matchers {

  "The standard scala Option has the following properties:" - {
    import variance.covariant.{None => NoneE, Option => OptionE, Some => SomeE}

    "Test 1: Because Option is covariant, I can assign an Option[Primate] to an Option[Mammal]" in {
      var optionalMammal: OptionE[Mammal] = SomeE(new Mammal)
      val optionalPrimate: OptionE[Primate] = SomeE(new Primate)

      optionalMammal = optionalPrimate

      // But not a Vertebrate (won't compile)
      // val contravariantlMammal: OptionE[Mammal] = OptionE(new Vertebrate)
    }

    "Test 2: Same for Some, because is covariant, I can assign a Some[Primate] to a Some[Mammal]" in {
      var someMammal: SomeE[Mammal] = SomeE(new Mammal)
      val somePrimate: SomeE[Primate] = SomeE(new Primate)

      someMammal = somePrimate
    }

    "Test 3: We can even assign an Option[Nothing] to an Option[Mammal]" in {
      var optionalMammal: OptionE[Mammal] = NoneE
      val optionNothing: OptionE[Nothing] = NoneE

      // As Nothing is a subtype of any type
      optionalMammal = optionNothing
    }
  }

  "An covariant version of Option (but where Some is invariant), has the following properties:" - {
    import variance.invariant.mixed.{None => NoneE, Option => OptionE, Some => SomeE}

    "Test 4: We can still assign an Option[Primate] to an Option[Mammal]" in {
      var optionalMammal: OptionE[Mammal] = SomeE(new Mammal)
      val optionalPrimate: OptionE[Primate] = SomeE(new Primate)

      optionalMammal = optionalPrimate
    }
    "Test 5: But we can NOT assign a Some[Primate] to a Some[Mammal]" in {
      var someMammal: SomeE[Mammal] = SomeE(new Mammal)
      val somePrimate: SomeE[Primate] = SomeE(new Primate)

      // This won't compile
      // someMammal = somePrimate
    }
    "Test 6: We can still assign a None to Option[Mammal]" in {
      // Because Option is covariant
      val somelMammal: OptionE[Mammal] = NoneE
    }
  }

  "An invariant version of Option, has the following properties:" - {
    import variance.invariant.{None => NoneE, Option => OptionE, Some => SomeE}

    "Test 7: Because Option is invariant, I can NOT assign a Option[Primate] to a Option[Mammal]" in {
      var optionalMammal: OptionE[Mammal] = SomeE(new Mammal)
      val optionalPrimate: OptionE[Primate] = SomeE(new Primate)

      // This won't compile
      // optionalMammal = optionalPrimate
    }

    "Test 8: Because Some is invariant, I can NOT assign a Some[Primate] to a Some[Mammal]" in {
      var someMammal: SomeE[Mammal] = SomeE(new Mammal)
      val somePrimate: SomeE[Primate] = SomeE(new Primate)

      // Won't compile.
      // someMammal = somePrimate
    }

    "Test 9: An other interesting thing is that we CAN NOT assign a None to Option[Mammal]" in {
      // This won't compile:
      // val somelMammal: OptionE[Mammal] = NoneE
    }

  }

}
