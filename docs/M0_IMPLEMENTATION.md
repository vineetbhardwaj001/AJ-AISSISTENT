# M0 Foundation Implementation

## Scope
A minimal, permission-free Android application shell. No contacts, calls, calendar, microphone, camera, AI networking, or background services.

## Selected toolchain
- Android Gradle Plugin: 9.3.1
- Gradle: 9.5.0
- Kotlin and Compose compiler plugin: 2.4.21
- Compose BOM: 2025.11.00
- compileSdk / targetSdk: 35
- minSdk: 26
- Java and Kotlin bytecode target: 17

AGP/Kotlin/Gradle are selected from their overlapping fully supported ranges in the official compatibility documentation. SDK Platform 35 must be installed locally before building.

## Structure
- Single :app module
- Kotlin + Jetpack Compose + Material 3
- Version catalog at gradle/libs.versions.toml
- No Android permissions in the manifest
- One launcher Activity and a minimal home screen
- One JVM unit test

## Local setup
- Use Android Studio's bundled JDK for Gradle only after confirming Gradle 9.5 runs correctly on that JDK. Bytecode target remains 17.
- Do not commit local.properties or machine-specific SDK/JDK paths.
- Install Android SDK Platform 35.
- Gradle wrapper scripts/JAR are not yet included. Generate them locally using a verified Gradle installation or Android Studio's wrapper tooling, then commit them before claiming command-line reproducibility.

## Verification status
Not yet built, linted, installed, or tested on RMX3762. Record actual local command output before marking any check as passed.
