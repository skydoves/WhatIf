plugins {
  kotlin("jvm")
  id(libs.plugins.nexus.plugin.get().pluginId)
  id(libs.plugins.kotlin.binary.compatibility.get().pluginId)
}

apply(from = "${rootDir}/scripts/publish-module.gradle.kts")

mavenPublishing {
  val artifactId = "whatif"
  coordinates(
    Configuration.artifactGroup,
    artifactId,
    rootProject.extra.get("libVersion").toString()
  )

  pom {
    name.set(artifactId)
    description.set("Fluent syntactic sugar of Kotlin for handling single if-else statements, nullable, collections, and booleans.")
  }
}

dependencies {
  testImplementation(libs.junit)
}