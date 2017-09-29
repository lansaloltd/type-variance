import sbt._

object MyBuild extends Build {

  lazy val kingdomAnimaliaBranch = "master"
  lazy val root = Project("root", file(".")) dependsOn(kingdomAnimaliaProject)
  lazy val kingdomAnimaliaProject = RootProject(uri(s"https://github.com/lansaloltd/kingdom-animalia.git#$kingdomAnimaliaBranch"))

}

