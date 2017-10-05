package variance.covariant

// import kingdom.animalia.vertebrate.Vertebrate
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.primate.Primate
import kingdom.animalia.vertebrate.mammal.primate.homo.Homo
// import kingdom.animalia.vertebrate.reptile.Reptile

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

  var covariantCage: Cage[Mammal] = null

  covariantCage = new Cage[Mammal]

  covariantCage = new Cage[Primate]

  covariantCage = new Cage[Homo]

  // type mismatch error
  // covariantCage = new Cage[Reptile]

  // type mismatch error
  // covariantCage = new Cage[Vertebrate]

}
