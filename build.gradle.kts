// Top-level build file where you can add configuration options common to all sub-projects/modules.
//gradle poject
plugins {
    //alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.jetbrains.kotlin.android) apply false
    //alias(libs.plugins.ksp) // Aquí estás utilizando el alias de KSP

    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false

}