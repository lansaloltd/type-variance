package variance.invariant

// Note that here Option is INVARIANT on A
sealed trait Option[A]

/*
NOTE:

case class Some[+A]( value: A ) extends Option[A]

with Some covariant on A, would NOT compile with error:
covariant type A occurs in invariant position
 */
case class Some[A]( value: A ) extends Option[A]
case object None extends Option[Nothing]