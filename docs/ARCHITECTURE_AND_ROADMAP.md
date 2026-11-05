# JARVIS AI — Architecture and roadmap

## Product goal
A useful Android-first personal assistant, not just a chat screen. It should retrieve real user-authorized data, perform bounded actions, ask before consequential changes, and verify execution.

## System boundaries
User voice/text/camera input -> local command and context resolver -> feature repository (contacts, calendar, tasks, reminders, phone) -> permission/consent and approval gate -> Android platform action -> execution verification -> spoken/text response.

Cloud AI is an optional reasoning service, not the authority for device state. Android owns local data and executes phone operations. Backend must not remotely control the handset.

## Proposed Android packages
- app/
- core/common/
- core/database/
- core/datastore/
- core/permissions/
- core/security/
- core/designsystem/
- feature/home/
- feature/voice/
- feature/contacts/
- feature/calendar/
- feature/tasks/
- feature/reminders/
- feature/phone/
- feature/settings/
- data/ (repository implementations)
- domain/ (use cases and models)

Start simpler if a single-module app is adequate. Split modules only when build time or ownership justifies it.

## AI routing
1. Deterministic local commands and repository lookup.
2. Gemini for language understanding/planning when user consents to send the minimal redacted prompt.
3. Hugging Face adapter as optional/experimental, subject to model/provider availability and quota.
4. No automatic paid provider fallback. Budget limit remains zero by default.
5. Do not send entire contacts, call logs, emails, messages or calendar to cloud by default.

Never bake long-lived API keys into the Android APK. Prefer a small backend proxy for cloud credentials, authentication, rate limiting and budget enforcement when cloud calls are implemented.

## First product slice (v0.1)
- Compose home/dashboard and settings.
- Push-to-talk voice input.
- Hindi/Hinglish text command support.
- Local tasks and notes.
- Today's agenda read-only after explicit calendar permission.
- Contacts lookup after explicit contacts permission.
- TTS response and notification-based reminders.
- AI integration only after privacy and zero-spend controls work.

Do not start with always-on wake word, default dialer replacement, autonomous WhatsApp sending, or background camera. Those require additional platform, policy, battery and safety work.

## Milestones
### M0 — Repository and device foundation
- Android project scaffold, version catalog and Gradle compatibility inspection.
- Local build, install and launch on RMX3762.
- CI compile/test job.
- Device audit document and implementation status.

### M1 — Useful offline core
- Dashboard, settings, tasks, notes, deterministic local commands.
- Room/DataStore only where required.
- Unit tests and persistence tests.

### M2 — Contacts and calendar read
- Contextual permission requests.
- Contact exact and ambiguous matching.
- Calendar queries, timezone-safe dates, duplicate handling and source IDs.
- No write operations until confirmation UX is tested.

### M3 — Voice and responses
- Push-to-talk first; SpeechRecognizer and TextToSpeech.
- Hindi/Hinglish evaluation set.
- Offline/error handling and clear recording indicator.
- Wake-word feasibility study after battery measurement.

### M4 — Reminders
- Notification permission, WorkManager for deferrable work.
- Exact alarms only when truly required and user grants special access.
- Boot recovery and battery optimization tests.

### M5 — Phone intelligence
- Evaluate ROLE_DIALER requirements and build complete core dialer behavior if pursuing it.
- Treat Call Log permissions as restricted; check Android role and Play policy eligibility before implementation.
- Do not assume ROLE_ASSISTANT automatically authorizes call-log access.

### M6 — Cloud AI
- Provider interface, Gemini proxy, optional HF adapter.
- Redaction, consent, rate limits, explicit budget enforcement, request timeouts.
- Zero paid fallback and offline graceful degradation.

### M7 — Camera/OCR and controlled automation
- CameraX on-screen preview with user-initiated capture.
- OCR and share-to-JARVIS document input.
- Accessibility only for disclosed, user-enabled workflows and only when permitted.

### M8 — Release hardening
- Unit/UI/instrumentation tests, lint, dependency review.
- Battery and memory profiling on real handset.
- Privacy disclosures, permission audit, crash handling without sensitive payloads.
- Signed APK/AAB and installation guide.

## Example action policy
| Action | Default behavior |
|---|---|
| Read tasks / notes | Local; no confirmation |
| Search authorized contacts | Permission required |
| Read calendar | Permission/OAuth required |
| Create/reschedule event | Preview and explicit confirmation |
| Draft a message | Allowed; no sending |
| Send a message | Show recipient and exact body; explicit confirmation |
| Place a call | Confirm target before dialing unless user explicitly chooses immediate call |
| Read call history | Only if permission and role/policy eligibility allow |
| Camera / microphone | Visible user-initiated session and runtime permission |
| Cloud AI prompt | Minimal context + disclosed consent; no private bulk upload |

## Definition of done
A milestone is complete only when code exists, automated checks pass, hardware behavior is tested when relevant, failure cases are handled, and docs/IMPLEMENTATION_STATUS.md records evidence.
