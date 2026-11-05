# JARVIS AI (AJ Assistant)

A personal Android assistant designed for the Realme C53 (RMX3762), with a free-first AI strategy and privacy-preserving local phone integrations.

> Status: project foundation only. No Android application code or device integration has been implemented yet.

## Current target device (ADB audit)

| Item | Observed value |
|---|---|
| Model | RMX3762 |
| Android | 15 (API 35) |
| Build | RMX3762_15_H.05 |
| Hardware identifier | ums9230_hulk |
| ABI | arm64-v8a (also armeabi-v7a, armeabi) |
| RAM reported by Linux | 3,851,896 kB (~3.67 GiB) |
| Available RAM at audit time | 1,380,984 kB (~1.32 GiB) |
| `/data` partition | 106 GB total, 80 GB used, 26 GB available |
| Battery at audit time | 88%, 34.7°C, USB powered |
| Google Play Services / Play Store packages | Present for user 0 |

These values are a point-in-time ADB snapshot, not guaranteed free resources. Physical RAM variant and CPU marketing name should be confirmed separately. Package presence does not prove a service is enabled or usable. See [device audit](docs/DEVICE_AUDIT.md).

## Product decisions

- Android app: Kotlin, Jetpack Compose, Material 3, MVVM with Clean Architecture boundaries.
- Android is the source of truth for phone-local data and operations.
- AI: deterministic local commands first; Gemini as optional cloud reasoning; Hugging Face as an optional experimental adapter.
- Free-first: no automatic paid fallback; spending limit is zero unless the owner deliberately changes policy.
- Never upload complete contacts, call logs, messages, or calendars by default.
- Voice and camera capture must be visible, user enabled, permission gated, and subject to Android background restrictions.
- Important actions (send message, modify calendar, place call, delete data) require an explicit confirmation step.

## Documentation

- [Architecture and milestones](docs/ARCHITECTURE_AND_ROADMAP.md)
- [Android Studio + OpenCode workflow](docs/DEVELOPMENT_WORKFLOW.md)
- [OpenCode project rules](AGENTS.md)
- [Device audit](docs/DEVICE_AUDIT.md)

## First milestone

Create a minimal Android app, install it on the connected RMX3762, and verify launch, Compose rendering, runtime permissions, logging, and crash-free lifecycle before implementing personal-data features.

## Safety and privacy

This project must use public Android APIs and documented user-consent flows. Do not bypass Android permission controls, Play policy, app security boundaries, or protected screens. Accessibility automation is optional, user enabled, narrowly scoped, and disclosed. Never hardcode API keys or commit secrets.
