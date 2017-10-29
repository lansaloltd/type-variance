package variance.covariant

import kingdom.animalia.Animal
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.primate.Primate
import kingdom.animalia.vertebrate.mammal.primate.homo.Homo
import org.scalatest.{FlatSpec, Matchers}

class FixedCageSpec extends FlatSpec with Matchers {

  "a FixedCage class" should "let us put a primate in a FixedCage[Animal]" in {
    val animalCage = new FixedCage[Animal, Primate](new Primate)
  }

  it should "not allow the occuring of the heap pollution issue" in {
    val primateCage = new FixedCage[Primate, Primate](new Primate)
    // That won't be allowed anymore
    // val animalCage: FixedCage[Animal] = primateCage

    // But we can still assign an Homo as it's a subtype of Primate
    primateCage.guest = new Homo
  }

}
