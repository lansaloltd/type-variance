package variance.invariant.mixed

sealed trait Option[+A]

case class Some[A]( value: A ) extends Option[A]
case object None extends Option[Nothing]
