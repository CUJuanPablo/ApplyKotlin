//gradle app
plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.jetbrains.kotlin.android)
    //alias(libs.plugins.ksp) // Usas el alias definido para KSP
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.zigmab.first"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zigmab.first"
        minSdk = 28
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.github.bumptech.glide:glide:4.16.0")
    //ksp("com.github.bumptech.glide:glide:4.16.0")

    implementation("androidx.room:room-runtime:2.6.1")
//    ksp("androidx.room:room-compiler:2.5.0")
    ksp("androidx.room:room-compiler:2.6.1")


}