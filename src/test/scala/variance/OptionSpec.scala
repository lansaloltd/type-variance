package variance

import kingdom.animalia.vertebrate.Vertebrate
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.primate.Primate
import org.scalatest.{FreeSpec, Matchers}

class OptionSpec extends FreeSpec with Matchers {

  "The standard scala Option has the following properties" - {
    import variance.covariant.{None, Option, Some}
    "Test 1: Because Option is covariant, I can assign a Option[Primate] to a Option[Mammal]" in {
      val optionalMammal: Option[Mammal] = Some(new Primate)

      // But not a Vertebrate
      //val contravariantlMammal: Option[Mammal] = Some(new Vertebrate)
    }

    "Test 2: We can even assign an Option[Nothing] to an Option[Nothing]" in {
      var optionalMammal: Option[Mammal] = None
      val optionNone: Option[Nothing] = None

      // As Nothing is a subtype of any type
      optionalMammal = optionNone
    }
  }

  "An invariant version of Option (but where Some is still covariant, has the following properties" - {
    import variance.invariant.Option
    "Test 3: Because Option is invariant, I can NOT assign a Option[Primate] to a Option[Mammal]" in {
      // Both won't compile!
      // val optionalMammal: Option[Mammal] = Some(new Primate)
      // val optionalMammal: Option[Mammal] = Some(new Mammal)
    }

    "Test 4: But Some with its Type Bounds allow a Some(Primate) to be assigned to a Some[Mammal]" in {
      val somelMammal: Some[Mammal] = Some(new Primate)

      val mammalammal: Some[Mammal] = Some(new Mammal)

      // But not a Vertebrate
      // val contravariantlMammal: Some[Mammal] = Some(new Vertebrate)
    }

    "Test 5: An other interesting thing is that we CAN NOT assige a None to Option[Mammal]" in {
      // This won't compile:
      // val somelMammal: Option[Mammal] = None

      /*
      Nothing is a subtype of any type but this time Option is invariant so we CAN'T assign
      to an Option[Mammal] anything that is not an Option[Mammal], so not an Option[Nothing],
      not None which extends Option[Nothing]
       */
    }
  }

  "If we make Option fully invariant (like in variance.invariant.fully.Option) then lose also the covariance for Some" - {
    import variance.invariant.fully.{None, Option, Some}

    "Test 6: An other interesting thing is that we CAN NOT assige a None to Option[Mammal]" in {
      val mammalammal: variance.invariant.fully.Some[Mammal] = Some(new Mammal)

      val somelMammal: variance.invariant.fully.Some[Mammal] = Some(new Primate)


    }

  }



}
