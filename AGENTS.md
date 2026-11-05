# JARVIS AI — OpenCode project instructions

## Mission
Build a reliable, privacy-first Android personal assistant for the user's Realme C53 (observed RMX3762, Android 15 / API 35). Use Android Studio as the IDE and OpenCode as the coding agent. The repository is currently a documentation scaffold; inspect it before creating app code.

## Non-negotiable workflow
1. Inspect repository, git status, Gradle/AGP/Kotlin versions, Android SDK availability, connected devices, and existing code before coding. Do not assume files or versions.
2. Preserve existing user work. Never overwrite or delete files without inspecting them. Work on feature branches; use small commits and PRs.
3. Build a minimal installable Android app first. Run Gradle unit tests, lint, assembleDebug, install to the real RMX3762 device, launch it, and capture actual logs. Report commands and results honestly.
4. Avoid unnecessary backend, database, dependency, framework, or cloud service. Verify current official compatibility before pinning versions.
5. Maintain docs/IMPLEMENTATION_STATUS.md with implemented, tested, blocked, and next items.

## Target architecture
- Android: Kotlin, Jetpack Compose, Material 3, MVVM, Clean Architecture boundaries.
- State: Coroutines + Flow; persistence: Room and DataStore when justified.
- Android integrations: Contacts Provider, Calendar Provider, Call Log only where role/policy permits, WorkManager/AlarmManager appropriately, notifications, CameraX, SpeechRecognizer, TextToSpeech.
- AI routing: deterministic local commands first; Gemini via a secure proxy or reviewed secure approach; Hugging Face optional/experimental. Never embed long-lived provider secrets in the APK.
- Backend (optional later): Node.js + TypeScript + Express, minimal scope for AI proxy, auth, rate limits and usage controls. Android remains executor for device-local actions.

## Free-first and privacy policy
- monthly_spending_limit = 0; automatic paid fallback disabled.
- Never silently switch to paid providers or create billable resources.
- Do not upload complete contacts, call logs, SMS, email, or calendars by default. Minimize/redact context and request explicit consent before cloud processing private content.
- Keep API keys out of source control, committed BuildConfig, logs, screenshots, and crash reports. Use local untracked config for development and server-side secrets for production.
- Provide user-visible controls for microphone, camera, location, AccessibilityService, notification access, and personal-data permissions. Request just-in-time, explain purpose, support revocation, degrade gracefully.
- No covert recording, camera capture, screen scraping, accessibility abuse, permission bypass, or background surveillance.
- Require explicit confirmation before sending messages, placing calls, modifying calendar events, deleting data, or performing consequential external actions. Verify outcome after execution.

## Device facts and limits
Use docs/DEVICE_AUDIT.md for observed ADB data. Treat memory/storage/battery as point-in-time readings. Do not assume commercial RAM variant, CPU marketing name, or hardware capability without verification. Benchmark local models on device; do not target a large LLM as an always-on process.

## Milestone order
1. Foundation: Gradle project, Compose app shell, theme, navigation, logging, tests, install/run on device.
2. Local core: tasks, notes, settings, local command parser, Room/DataStore only as needed.
3. Contacts and calendar: explicit permissions, read-only first, source-aware event IDs and duplicate handling; add writes after confirmation flows and tests.
4. Phone intelligence: check default dialer role, Android API requirements, distribution policy, and restricted Call Log eligibility. Default Assistant role alone does not guarantee Call Log access. Build required dialer behavior if pursuing the role.
5. Voice: push-to-talk first, Hindi/Hinglish speech tests, TTS, then evaluate wake-word feasibility/battery. No always-on microphone promise before device tests.
6. Reminders: notifications, reboot recovery and battery tests; exact alarms only when justified and user-authorized.
7. AI: provider abstraction, Gemini, optional HF, budget enforcement, redaction, timeouts, retries and offline graceful behavior.
8. Camera/OCR and accessibility only after opt-in, disclosure, lifecycle/security review and device tests.
9. Release hardening: tests, lint, privacy disclosures, permission review, battery profiling, crash handling and signed build instructions.

## Definition of done
- Clear user story and permission rationale.
- Unit tests for business logic and edge cases.
- UI/instrumentation tests where applicable.
- Device test on RMX3762 where hardware/platform behavior is involved.
- Denied-permission, offline and revoked-access behavior handled.
- Privacy/security review; logs contain no sensitive content.
- docs/IMPLEMENTATION_STATUS.md updated with evidence.

## Communication
Guide the owner in easy Hinglish. Separate implemented facts, assumptions, recommendations, and blockers. If a task needs physical Android Studio UI interaction, local files, device unlock, OAuth consent, API key, or permission grant the agent cannot perform, provide exact owner steps. Never pretend it was done.
