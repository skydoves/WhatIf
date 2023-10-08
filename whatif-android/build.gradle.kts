@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.kotlin.binary.compatibility.get().pluginId)
  id(libs.plugins.nexus.plugin.get().pluginId)
}

apply(from = "${rootDir}/scripts/publish-module.gradle.kts")

mavenPublishing {
  val artifactId = "whatif-android"
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

android {
  namespace = "com.skydoves.whatif.android"
  compileSdk = Configuration.compileSdk
  defaultConfig {
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk
  }

  buildFeatures {
    buildConfig = false
  }
}

dependencies {
  api(project(":whatif"))

  implementation(libs.androidx.appcompat)
  testImplementation(libs.junit)
  testImplementation(libs.robolectric)
}
