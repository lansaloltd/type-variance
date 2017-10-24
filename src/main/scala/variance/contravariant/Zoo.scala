package variance.contravariant

import kingdom.animalia.Animal
// import kingdom.animalia.invertebrate.mollusc.Mollusc
import kingdom.animalia.vertebrate.Vertebrate
import kingdom.animalia.vertebrate.mammal.Mammal
// import kingdom.animalia.vertebrate.mammal.primate.Primate

/**
  * Remember the kingdom animalia hierarchy:
  *
  * .
  *  └── Animal
  *      |
  *      ├── Invertebrate
  *      |   |
  *      │   └── Mollusc
  *      │
  *      └── Vertebrate
  *          |
  *          ├── Fish
  *          |
  *          ├── Mammal
  *          |   |
  *          │   └── Primate
  *          |       |
  *          │       ├── Homo
  *          |
  *          ├── Reptile
  *
  */
class Zoo {

  val mammalCage: Cage[Mammal] = new variance.contravariant.Cage[Mammal]

  val vertebrateCage: Cage[Mammal] = new variance.contravariant.Cage[Vertebrate]

  val animalCage: Cage[Mammal] = new variance.contravariant.Cage[Animal]

  // type mismatch error
  // val primateCage: Cage[Mammal] = new variance.contravariant.Cage[Primate]

  // type mismatch error
  // val molluscCage: Cage[Mammal] = new variance.contravariant.Cage[Mollusc]

}
