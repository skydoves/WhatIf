@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.binary.compatibility) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.nexus.plugin)
  alias(libs.plugins.spotless)
  alias(libs.plugins.dokka)
}

subprojects {
  if (name != "app") {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
      kotlinOptions.jvmTarget = libs.versions.jvmTarget.get()
      kotlinOptions.freeCompilerArgs += listOf(
        "-Xexplicit-api=strict",
        "-Xopt-in=kotlin.contracts.ExperimentalContracts"
      )
    }
  }

  apply(plugin = rootProject.libs.plugins.spotless.get().pluginId)
  configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
      target("**/*.kt")
      targetExclude("$buildDir/**/*.kt")
      ktlint().setUseExperimental(true).editorConfigOverride(
        mapOf(
          "indent_size" to "2",
          "continuation_indent_size" to "2"
        )
      )
      licenseHeaderFile(rootProject.file("spotless/spotless.license.kt"))
      trimTrailingWhitespace()
      endWithNewline()
    }
    format("kts") {
      target("**/*.kts")
      targetExclude("$buildDir/**/*.kts")
      licenseHeaderFile(rootProject.file("spotless/spotless.license.kt"), "(^(?![\\/ ]\\*).*$)")
      trimTrailingWhitespace()
      endWithNewline()
    }
  }
}