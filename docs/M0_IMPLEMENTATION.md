# M0 Foundation Implementation

## Scope
A minimal, permission-free Android application shell. No contacts, calls, calendar, microphone, camera, AI networking, or background services.

## Selected toolchain
- Android Gradle Plugin: 9.3.1
- Gradle: 9.5.0
- Kotlin and Compose compiler plugin: 2.4.21
- Compose BOM: 2026.09.00
- compileSdk: 37 (already present in the audited Android SDK)
- targetSdk: 35
- minSdk: 26
- Java and Kotlin bytecode target: 17
- Gradle runtime: Android Studio bundled JBR 25 is expected to be supported by Gradle 9.5; verify with the first local sync.

AGP 9.3 supports API 37 and requires Gradle 9.5. Kotlin 2.4.21's fully supported AGP range includes AGP 9.3.1, and its supported Gradle range includes 9.5. Gradle 9.5 supports running on Java 25. See the official Android and Kotlin compatibility references.

## Structure
- Single :app module
- Kotlin + Jetpack Compose + Material 3
- Version catalog at gradle/libs.versions.toml
- No Android permissions in the manifest
- One launcher Activity and a minimal home screen
- One JVM unit test

## Local setup
- Use Android Studio's bundled JDK (JBR 25) for Gradle after confirming the first sync succeeds.
- Do not commit local.properties or machine-specific SDK/JDK paths.
- SDK Platform 37 and Build Tools 36.0.0 were observed in the environment audit.
- Gradle wrapper scripts/JAR are not yet included. Generate and commit them after verifying the local Gradle runtime, before claiming command-line reproducibility.

## Verification status
Not yet built, linted, installed, or tested on RMX3762. Record actual local command output before marking any check as passed.
