plugins {
  kotlin("jvm")
  id(libs.plugins.kotlin.binary.compatibility.get().pluginId)
}

rootProject.extra.apply {
  set("PUBLISH_GROUP_ID", Configuration.artifactGroup)
  set("PUBLISH_ARTIFACT_ID", "whatif")
  set("PUBLISH_VERSION", rootProject.extra.get("rootVersionName"))
}

apply(from ="${rootDir}/scripts/publish-module.gradle")


dependencies {
  testImplementation(libs.junit)
}