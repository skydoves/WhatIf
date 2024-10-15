@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.application.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.compose.compiler.get().pluginId)
}

android {
  compileSdk = Configuration.compileSdk
  namespace = "com.skydoves.whatifdemo"

  defaultConfig {
    applicationId = "com.skydoves.whatifdemo"
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk
    versionCode = Configuration.versionCode
    versionName = Configuration.versionName
  }

  buildFeatures {
    compose = true
    viewBinding = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = libs.versions.jvmTarget.get()
  }

  packaging {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }

  lint {
    abortOnError = false
  }
}

dependencies {
  implementation(project(":whatif"))
  implementation(project(":whatif-android"))

  implementation(libs.material)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.material)
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.compose.runtime)
  implementation(libs.landscapist.glide)
}