package variance.invariant

// Note that here Option is INVARIANT on A
sealed trait Option[A]

/*
We can't simply define Some like in the proper Option class definition:

case class Some[+A]( value: A ) extends Option[A]

The compiler will report an error like: covariant type A occurs in invariant position in type [+A]AnyRef
For the same reasons and consideration explained in the BrokenCage case.
 */

case class Some[A, B <: A]( value: B ) extends Option[A]
case object None extends Option[Nothing]