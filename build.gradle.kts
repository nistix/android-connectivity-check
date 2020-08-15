buildscript {
  repositories {
    google()
    jcenter()
    maven { url = uri("https://dl.bintray.com/nistix/maven") }
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.1.0-rc01")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven { url = uri("https://dl.bintray.com/nistix/maven") }
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
