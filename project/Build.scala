import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "parkhelsinki"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // play-salat
      "se.radley" %% "play-plugins-salat" % "1.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // play-salat
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId"
    )

}
