# Android Studio + OpenCode — development workflow

## Roles

### Android Studio
Use it for Android SDK and emulator/device configuration, Gradle sync, build variants, Compose preview, running/debugging on the real RMX3762 phone, Logcat, profiler, layout inspector and signing configuration.

### OpenCode
Use it for repository exploration, implementation planning, Kotlin/Compose code generation, refactoring, tests, Gradle tasks, lint, documentation and code review.

Both work in the same local repository folder. OpenCode edits files; Android Studio syncs and displays those changes. Avoid editing the same file simultaneously in both tools.

## One-time setup
1. Install Android Studio from https://developer.android.com/studio
2. In SDK Manager install a stable Android SDK Platform suitable for API 35, Platform Tools, Build Tools, and a compatible JDK.
3. Clone this GitHub repository and open the local clone in Android Studio.
4. Install OpenCode using https://opencode.ai/docs/ and launch it from the repository root.
5. Connect Realme C53 with USB debugging enabled and approve the debugging prompt.
6. Verify adb devices shows the handset as device.
7. Ask OpenCode to inspect installed Gradle/AGP/Kotlin/JDK versions and propose a compatible minimal project before generating files.

## Daily loop
1. Start with git status and confirm the current feature branch.
2. Ask OpenCode for a short plan and the files it will change.
3. Review the plan; keep each task to one vertical slice.
4. Let OpenCode implement and add tests.
5. Run Gradle tests, build and lint from terminal; inspect failures.
6. Open/sync in Android Studio; inspect Compose previews.
7. Install and test on RMX3762; inspect Logcat and verify actual behavior.
8. Ask OpenCode to fix only reproducible issues.
9. Review git diff, secrets, permission declarations and tests.
10. Commit and push a feature branch; open a PR. Do not push unreviewed changes to main.

## First OpenCode prompt
Read AGENTS.md, README.md and docs/ARCHITECTURE_AND_ROADMAP.md. Inspect local environment and repository without changing files. Check JDK, Android SDK, Gradle availability, ADB connection, git status and existing files. Compare connected RMX3762 (Android 15/API 35) with installed SDK platforms. Produce a concise environment report and minimal M0 implementation plan. Do not generate app code until report identifies compatible toolchain and blockers. Never invent version numbers or claim a command ran if it did not.

## What the owner must do
The owner must install Android Studio and SDK components, clone/open the repository locally, install/login/configure OpenCode, unlock phone and approve debugging/runtime permission/OAuth prompts, provide secrets locally if needed, physically test voice/camera/calls/battery/notifications, and review PRs and consequential actions.

## Troubleshooting
- adb devices = unauthorized: unlock phone and approve the RSA debugging prompt.
- No adb: use Android SDK Platform Tools path or add it to PATH.
- Gradle sync fails: capture full error, verify JDK/AGP/Kotlin compatibility; do not randomly upgrade dependencies.
- Device not visible: check USB mode, cable, driver and adb devices.
- Never disable Android security controls to make a test pass.
