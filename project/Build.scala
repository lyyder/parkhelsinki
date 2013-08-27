import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "parkhelsinki"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // play-salat
      "se.radley" %% "play-plugins-salat" % "1.3.0"
    )

  val main = play.Project(appName, appVersion, appDependencies).settings(
      // play-salat
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId",
      resolvers += Resolver.sonatypeRepo("snapshots")
    )

}
