plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android") version "2.51.1" // <--- Specify the Hilt plugin ID and version here

}

android {
    namespace = "com.example.jet_2_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.jet_2_app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }


    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.androidx.navigation.compose.v288)
    implementation(libs.accompanist.navigation.animation.v0320)


    //--->New code<---👆

    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20230800))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    // Retrofit & Converter
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

// Logging interceptor (optional, for debugging)
    implementation(libs.logging.interceptor)

    // Hilt
    implementation(libs.hilt.android) // This comes from your libs.versions.toml
    kapt(libs.hilt.compiler) // This comes from your libs.versions.toml

// Hilt with ViewModel
    implementation(libs.androidx.hilt.navigation.compose)

    // ViewModel + Lifecycle
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx.v270)

// Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation("io.coil-kt:coil-compose:2.4.0")




}