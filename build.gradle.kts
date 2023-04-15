plugins {
  kotlin("jvm") version "1.8.0"
  id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
  id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

group = "io.gabx"
version = "0.0.1"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(8)
}

ktlint {
  version.set("0.45.2")
  android.set(false)
  additionalEditorconfigFile.set(rootProject.file(".editorconfig"))
}

detekt {
  buildUponDefaultConfig = true
  allRules = false

  config = files("${rootProject.projectDir}/config/detekt.yml")
  baseline = file("${rootProject.projectDir}/config/baseline.xml")
}
