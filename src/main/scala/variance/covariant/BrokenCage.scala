package variance.covariant

/**
  * If you comment out "(var animals: List[A])", you'll get a:
  * "covariant type A occurs in contravariant position in type List[A] of value animals_="
  * error message at compile time
  */
class BrokenCage[+A](var animals: List[A]) {

  // as animals is a var, the compiler would provide automatically a
  // def animals=(a: List[A]): Unit method as a setter

}

/*

Let's assume for the sick of the discussion that the compiler let us have something like a:

class BrokenCage[+A](var animals: List[A]) {

  private var animals: List[A]

  def animals_=(a: List[A]): Unit = {
    animals = a
  }

}

Because BrokenCage is covariant in A, BrokenCage[Primate] is a subtype of BrokenCage[Animal]
and, as we saw in the correspondent covariance.Zoo class we can assign a Cage[Primate] to a Cage[Mammal]

var covariantCage: Cage[Mammal] = new Cage[Primate]

That is what being covariant means.

Then let's create a

val primateCage = new BrokenCage[Primate](List.empty[Primate])

Now we have a BrokenCage[Primate] and the contained list is type List[Primate] and note that the list type is invariant (as we defined it)

Since BrokenCage[Primate] is a subtype of BrokenCage[Animal], the following should be allowed:

val mammalCage: BrokenCage[Animal] = primateCage

And now, we have a BrokenCage[Animal], and therefore mammalCage.animals is type List[Animal], which means the following should be valid:

mammalCage.animals = List[Animal]()

Which means we just assigned a List[Animal] to primateCage animals member, which shouldn't be allowed, since that is supposed to be a List[Primate],
not a List[Animal]. It also means you could prepend an Invertebrate (or any other Animal) to it  as it is type List[Animal].

 */
