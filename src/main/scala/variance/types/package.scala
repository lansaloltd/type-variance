package variance

package object types {

  class InvariantCage[A](val animal: A)

  class CovariantCage[+A](val animal: A)

  class ContravariantCage[-A](val animal: A)

}
