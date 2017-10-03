package variance.types

import kingdom.animalia.invertebrate.examples.{JellyFish, Octopus}
import kingdom.animalia.vertebrate.examples.PufferFish
import kingdom.animalia.vertebrate.mammal.Mammal
import kingdom.animalia.vertebrate.mammal.examples.Dog
import kingdom.animalia.vertebrate.mammal.primate.examples.Bonobo


class CagingAnimals {

  var invariantCage: InvariantCage[Octopus] = null

  var covariantCage: CovariantCage[Mammal] = null

  var contravariantCage: ContravariantCage[Mammal] = null


  invariantCage = new InvariantCage(new Octopus())

  // invariantCage = new InvariantCage(new JellyFish())

  covariantCage = new CovariantCage(new Bonobo())

  covariantCage = new CovariantCage(new Dog())

  //covariantCage = new CovariantCage(new PufferFish())

  contravariantCage = new ContravariantCage(new Bonobo())

  contravariantCage = new ContravariantCage(new Dog())

}
