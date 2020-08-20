const val kotlinVersion = "1.4.0"

const val navigationLatest = "2.3.0-beta01"

object Config {
  const val versionCode = 3
  const val versionName = "1.0.3"

  const val bintrayRepo =  "maven"
  const val artifactGroupId = "com.nistix.connectivity-check"
  const val websiteUrl = "https://github.com/nistix/android-connectivity-check"
  const val issueTrackerUrl = "https://github.com/nistix/android-connectivity-check/issues"
  const val vcsUrl = "https://github.com/nistix/android-connectivity-check.git"
  const val license = "MIT"
  const val githubRepo = "nistix/android-connectivity-check"
  const val githubReleaseNotesFile = "README.md"
}

object BuildPlugins {
  object Versions {
    const val buildToolsVersion = "4.1.0-rc01"
  }

  const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
  const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object AndroidSdk {
  const val min = 21
  const val compile = 30
  const val buildToolsVersion = "30.0.2"
  const val target = compile
}

object Libraries {
  public object Versions {
    const val appcompatLatest = "1.3.0-alpha02"
    const val constraintLayoutLatest = "2.0.0-rc1"
    const val coreLatest = "1.5.0-alpha02"
    const val lifecycleLatest = "2.3.0-alpha07"
    const val materialLatest = "1.3.0-alpha02"

    const val rxAndroid = "2.1.1"
    const val rxJava2 = "2.2.19"
  }

  const val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

  const val appCompatLatest = "androidx.appcompat:appcompat:${Versions.appcompatLatest}"
  const val constraintLayoutDev = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutLatest}"
  const val coreLatest = "androidx.core:core-ktx:${Versions.coreLatest}"
  const val lifecycleLiveDataLatest = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLatest}"
  const val lifecycleLiveDataCoreLatest = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.lifecycleLatest}"
  const val lifecycleViewModelLatest = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleLatest}"
  const val materialLatest = "com.google.android.material:material:${Versions.materialLatest}"
  const val navigationFragmentDev = "androidx.navigation:navigation-fragment-ktx:$navigationLatest"
  const val navigationUiDev = "androidx.navigation:navigation-ui-ktx:$navigationLatest"

  const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
  const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
}

