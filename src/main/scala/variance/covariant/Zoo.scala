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

  val mammalCage: Cage[Mammal] = new Cage[Mammal]

  val primateCage: Cage[Mammal] = new Cage[Primate]

  val homoCage: Cage[Mammal] = new Cage[Homo]

  // type mismatch error
  // val reptileCage: Cage[Mammal] = new Cage[Reptile]

  // type mismatch error
  // val vertebrateCage: Cage[Mammal] = new Cage[Vertebrate]

}
