import sbt._

object AppDependencies {

  val compile = Seq()

  val test = Seq(
    "org.scalatest"  %% "scalatest"    % "3.2.15",
    "io.rest-assured" % "rest-assured" % "5.3.0",
    //"org.typelevel"                %% "cats-core"            % "2.9.0",
    "com.vladsch.flexmark" % "flexmark-all" % "0.62.2",
    //"org.scalacheck"               %% "scalacheck"           % "1.17.0",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.14.2",
    //"com.typesafe.play" %% "play-json" % "2.9.4",

    // The following are needed for XML/Json manipulation, avoiding the use of Akka
    // due to licencing restrictions
    "org.typelevel" %% "cats-effect"   % "3.4.10",
    "co.fs2"        %% "fs2-core"      % "3.6.1",
    "co.fs2"        %% "fs2-io"        % "3.6.1",
    "org.gnieh"     %% "fs2-data-xml"  % "1.7.0",
    "org.gnieh"     %% "fs2-data-json" % "1.7.1"
  ).map(_ % "test")
}
