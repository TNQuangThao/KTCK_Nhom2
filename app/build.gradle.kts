android {
    namespace = "com.example.myapplication"
    compileSdk = 35 // Cập nhật từ 34 lên 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 35 // Đồng bộ với compileSdk
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dependencies {
        implementation("com.google.android.material:material:1.9.0")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.github.bumptech.glide:glide:4.12.0")
        annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    }
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

