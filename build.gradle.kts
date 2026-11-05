buildscript {
    dependencies {
        // AGP 9 provides built-in Kotlin. Override its default KGP with the
        // pinned Kotlin version used by the Compose compiler plugin.
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.21")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
