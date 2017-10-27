package variance.covariant

class FixedCage[+A] {

  def addGuest[B, B <: A](animal: B): Unit = {
    // maybe setting some local variable
  }

}
