import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("com.android.library")
  kotlin("android")
  `maven-publish`
  id("com.jfrog.bintray") version "1.8.5"
}

val libArtifactId = "adapter-rxjava2"
val libDesc = "Android Connectivity Check library: Adapter RxJava2"

android {
  compileSdkVersion(AndroidSdk.compile)
  buildToolsVersion(AndroidSdk.buildToolsVersion)

  defaultConfig {
    minSdkVersion(AndroidSdk.min)
    targetSdkVersion(AndroidSdk.target)
    versionCode = Config.versionCode
    versionName = Config.versionName
    consumerProguardFiles("consumer-rules.pro")
    setProperty("archivesBaseName", "connectivity-check-$libArtifactId-${Config.versionName}")
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

  implementation(Libraries.kotlinStdLibJdk8)
  implementation(Libraries.rxJava2)
}

val sourcesJar by tasks.creating(Jar::class) {
  archiveClassifier.set("sources")
  from(project.android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
  publications {
    create<MavenPublication>(libArtifactId) {
      groupId = Config.artifactGroupId
      artifactId = libArtifactId
      version = Config.versionName
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
    repo = Config.bintrayRepo
    name = libArtifactId
    desc = libDesc
    websiteUrl = Config.websiteUrl
    issueTrackerUrl = Config.issueTrackerUrl
    vcsUrl = Config.vcsUrl
    setLicenses(Config.license)
    publicDownloadNumbers = true
    githubRepo = Config.githubRepo
    githubReleaseNotesFile = Config.githubReleaseNotesFile

    version.apply {
      name = Config.versionName
      desc = "$libDesc ${Config.versionName}"
      vcsTag = Config.versionName
    }
  }
}
