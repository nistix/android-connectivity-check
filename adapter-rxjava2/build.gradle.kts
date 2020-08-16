import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("com.android.library")
  kotlin("android")
  `maven-publish`
  id("com.jfrog.bintray") version "1.8.5"
}

val libVersionCode = 2
val libVersionName = "1.0.2"
val libBintrayRepo = "maven"
val libGroupId = "com.nistix.connectivity-check"
val libArtifactId = "adapter-rxjava2"
val libDesc = "Android Connectivity Check library: Adapter RxJava2"
val libWebSiteUrl = "https://github.com/nistix/android-connectivity-check"
val libIssueTrackerUrl = "https://github.com/nistix/android-connectivity-check/issues"
val libVcsUrl = "https://github.com/nistix/android-connectivity-check.git"
val libLicense = "MIT"
val libGithubRepo = "nistix/android-connectivity-check"
val libGithubReleaseNotesFile = "README.md"

android {
  compileSdkVersion(30)
  buildToolsVersion("30.0.2")

  defaultConfig {
    minSdkVersion(21)
    targetSdkVersion(30)
    versionCode = libVersionCode
    versionName = libVersionName
    consumerProguardFiles("consumer-rules.pro")
    setProperty("archivesBaseName", "connectivity-check-$libArtifactId-$libVersionName")
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
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
  implementation("io.reactivex.rxjava2:rxjava:2.2.19")
}

val sourcesJar by tasks.creating(Jar::class) {
  archiveClassifier.set("sources")
  from(project.android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
  publications {
    create<MavenPublication>(libArtifactId) {
      groupId = libGroupId
      artifactId = libArtifactId
      version = libVersionName
      artifact(sourcesJar)
      artifact("$buildDir/outputs/aar/${property("archivesBaseName")}-release.aar")
    }
  }
}

bintray {
  user = gradleLocalProperties(rootDir).getProperty("bintrayUser")
  key = gradleLocalProperties(rootDir).getProperty("bintrayKey")
  dryRun = false
  publish = true
  override = true
  setPublications(libArtifactId)

  pkg.apply {
    repo = libBintrayRepo
    name = libArtifactId
    desc = libDesc
    websiteUrl = libWebSiteUrl
    issueTrackerUrl = libIssueTrackerUrl
    vcsUrl = libVcsUrl
    setLicenses(libLicense)
    publicDownloadNumbers = true
    githubRepo = libGithubRepo
    githubReleaseNotesFile = libGithubReleaseNotesFile

    version.apply {
      name = libVersionName
      desc = "$libDesc $libVersionName"
      vcsTag = libVersionName
    }
  }
}