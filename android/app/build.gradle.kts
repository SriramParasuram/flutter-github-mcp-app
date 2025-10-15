plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.mcp_flutter_demo"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.mcp_flutter_demo"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    // ✅ Product Flavors setup
    flavorDimensions += "default"
    productFlavors {
        create("dev") {
            dimension = "default"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            resValue("string", "app_name", "MCP Dev")
        }
        create("staging") {
            dimension = "default"
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-staging"
            resValue("string", "app_name", "MCP Staging")
        }
        create("prod") {
            dimension = "default"
            // No suffix for production
            resValue("string", "app_name", "MCP Prod")
        }
    }

    sourceSets {
        getByName("dev") {
            res.srcDirs("src/dev/res")
        }
        getByName("staging") {
            res.srcDirs("src/staging/res")
        }
        getByName("prod") {
            res.srcDirs("src/prod/res")
        }
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}