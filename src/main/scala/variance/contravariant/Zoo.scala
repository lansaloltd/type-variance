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

  var contravariantCage: Cage[Mammal] = null

  contravariantCage = new variance.contravariant.Cage[Mammal]

  contravariantCage = new variance.contravariant.Cage[Vertebrate]

  contravariantCage = new variance.contravariant.Cage[Animal]

  // type mismatch error
  // contravariantCage = new variance.contravariant.Cage[Primate]

  // type mismatch error
  // contravariantCage = new variance.contravariant.Cage[Mollusc]

}
