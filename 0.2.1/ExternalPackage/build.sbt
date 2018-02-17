import com.typesafe.sbt.MultiJvmPlugin.multiJvmSettings

name := "ExternalPackage"

version := "0.1"
val akkaVersion = "2.5.8"

lazy val appResolvers = Seq(
  "typesafe" at "http://repo.typesafe.com/typesafe/releases/",
  "hydrasonatype" at "https://oss.sonatype.org/content/groups/staging/"
)
lazy val `externalpackage` = project
  .in(file("."))
  .settings(multiJvmSettings: _*)
  .settings(
    name := "External",
    version := "0.1.0",
    organization := "io.github.wherby",
    scalaVersion := "2.12.2",
    scalacOptions in Compile ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlog-reflective-calls", "-Xlint"),
    javacOptions in Compile ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
    javaOptions in run ++= Seq("-Xms128m", "-Xmx1024m", "-Djava.library.path=./target/native"),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-remote" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
      "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
      "com.typesafe.akka" %% "akka-distributed-data" % akkaVersion,
      "com.typesafe.akka" %% "akka-http"   % "10.1.0-RC1",
      "com.typesafe.akka" %% "akka-stream" % akkaVersion),
    fork in run := true,
    // disable parallel tests
    parallelExecution in Test := false,
    resolvers ++= appResolvers,
    licenses := Seq("GPL-3.0" -> url("https://opensource.org/licenses/GPL-3.0"))
  )
  .configs (MultiJvm)