package variance.invariant

// import kingdom.animalia.vertebrate.Vertebrate
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

  val mammalCage: Cage[Mammal] = new Cage[Mammal]

  /**
    * [error] Note: kingdom.animalia.vertebrate.mammal.primate.Primate <: kingdom.animalia.vertebrate.mammal.Mammal, but class Cage is invariant in type A.
    * [error] You may wish to define A as +A instead.
    */
   // val primateCage: Cage[Mammal] = new Cage[Primate]

  /**
    * [error] Note: kingdom.animalia.vertebrate.Vertebrate >: kingdom.animalia.vertebrate.mammal.Mammal, but class Cage is invariant in type A.
    * [error] You may wish to define A as -A instead.
    */
  // val vertebrateCage: Cage[Mammal] = new Cage[Vertebrate]

}
