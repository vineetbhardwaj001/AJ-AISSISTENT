# Realme C53 — ADB device audit

Captured by the project owner on Windows using Android Debug Bridge. Values below are a point-in-time snapshot.

## Observed device details

| Field | Observed value |
|---|---|
| Model | RMX3762 |
| Manufacturer | realme |
| Android release | 15 |
| API level | 35 |
| Build ID | RMX3762_15_H.05 |
| Hardware identifier | ums9230_hulk |
| Primary ABI | arm64-v8a |
| Supported ABI list | arm64-v8a, armeabi-v7a, armeabi |
| Linux MemTotal | 3,851,896 kB (~3.67 GiB) |
| MemAvailable at capture | 1,380,984 kB (~1.32 GiB) |
| /data partition | 106 GB total; 80 GB used; 26 GB available |
| Battery level | 88% |
| Battery temperature | 34.7°C |
| Battery status | USB powered |

## Google package observations (user 0)

The package query returned:
- com.google.android.gms — Google Play services package
- com.android.vending — Play Store package
- com.google.android.apps.googleassistant — Google Assistant app package
- com.google.android.calendar — Google Calendar package
- com.google.android.contacts — Google Contacts package
- com.google.android.dialer — Google Dialer package
- com.google.android.tts — Google Text-to-Speech package

Package presence is not a functional test and does not prove account sign-in, enabled state, network connectivity, permissions, or API availability.

## Known audit limitation

Package enumeration without an explicit user selector returned a SecurityException because shell could not access user 12. The owner reran package enumeration with --user 0, which succeeded. This is a profile-scope limitation, not evidence of a broken ADB connection.

## Important interpretation

- MemTotal is Android/Linux memory-visible total. Do not treat this as the exact advertised physical RAM variant.
- MemAvailable is dynamic and changes as apps open/close.
- /data usage is a filesystem snapshot, not total advertised flash capacity.
- Battery reading was taken while USB-powered and should not be used as battery-life benchmark.
- Hardware identifier ums9230_hulk is not enough by itself to claim exact CPU model/clock.
- The reported ABI confirms 64-bit ARM app compatibility.

## Next compatibility tests

1. Verify CPU model/clock only through trustworthy device/SoC evidence.
2. Create and install a minimal Compose app.
3. Test microphone permission and SpeechRecognizer in Hindi/Hinglish.
4. Test TextToSpeech output.
5. Test CameraX preview.
6. Test notification permission and scheduling after reboot.
7. Measure idle and active battery/RAM with JARVIS installed.
8. Test Android 15 background execution and battery optimization behavior.
