plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(AndroidSdk.compile)
  buildToolsVersion(AndroidSdk.buildToolsVersion)

  defaultConfig {
    applicationId = "com.nistix.connectivity.demo"
    minSdkVersion(AndroidSdk.min)
    targetSdkVersion(AndroidSdk.target)
    versionCode = Config.versionCode
    versionName = Config.versionName
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
  implementation(project(":check"))
  implementation(project(":adapter-livedata"))
  implementation(project(":adapter-rxjava2"))

  implementation(Libraries.kotlinStdLibJdk8)

  implementation(Libraries.appCompatLatest)
  implementation(Libraries.constraintLayoutDev)
  implementation(Libraries.coreLatest)
  implementation(Libraries.lifecycleLiveDataLatest)
  implementation(Libraries.lifecycleViewModelLatest)
  implementation(Libraries.materialLatest)
  implementation(Libraries.navigationFragmentDev)
  implementation(Libraries.navigationUiDev)

  implementation(Libraries.rxAndroid)
  implementation(Libraries.rxJava2)
}
