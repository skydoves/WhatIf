plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.nexus.plugin.get().pluginId)
  id(libs.plugins.kotlin.multiplatform.get().pluginId)
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

kotlin {
  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64(),
    macosArm64(),
    macosX64(),
  ).forEach {
    it.binaries.framework {
      baseName = "common"
    }
  }

  androidTarget {
    publishLibraryVariants("release")
  }

  jvm {
    libs.versions.jvmTarget.get().toInt()
    compilations.all {
      kotlinOptions.jvmTarget = libs.versions.jvmTarget.get()
    }
  }

  applyDefaultHierarchyTemplate()

  sourceSets {
    all {
      languageSettings.optIn("kotlin.contracts.ExperimentalContracts")
      languageSettings.optIn("com.skydoves.sandwich.annotations.InternalSandwichApi")
    }
  }

  explicitApi()
}

android {
  compileSdk = Configuration.compileSdk
  namespace = "com.skydoves.whatif"
  defaultConfig {
    minSdk = Configuration.minSdk
    consumerProguardFiles("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
}

tasks.withType(JavaCompile::class.java).configureEach {
  this.targetCompatibility = libs.versions.jvmTarget.get()
  this.sourceCompatibility = libs.versions.jvmTarget.get()
}

dependencies {
  androidTestImplementation(libs.junit)
}