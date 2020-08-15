plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(30)
  buildToolsVersion("30.0.2")

  defaultConfig {
    applicationId = "com.nistix.connectivity.demo"
    minSdkVersion(21)
    targetSdkVersion(30)
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }

  sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
  implementation("androidx.core:core-ktx:1.3.1")
  implementation("androidx.appcompat:appcompat:1.2.0")
  implementation("com.google.android.material:material:1.2.0")
  implementation("androidx.constraintlayout:constraintlayout:1.1.3")
  implementation("androidx.navigation:navigation-fragment:2.3.0")
  implementation("androidx.navigation:navigation-ui:2.3.0")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
  implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
  implementation("androidx.navigation:navigation-ui-ktx:2.3.0")

  implementation("com.nistix.connectivity-check:core:1.0.0")
  implementation("com.nistix.connectivity-check:adapter-livedata:1.0.0")
}
