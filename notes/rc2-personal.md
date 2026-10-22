# GTNH 2.9.0-RC2 personal build

Base: official TST `0.8.0-RC2.7`, commit `f59f874694906144e205a3451dfd665c701eca97`.

The upstream-ready structure change is isolated on `codex/gtnh-rc2-structure-fix`
at `fb395c69`. The personal branch `codex/gtnh-rc2-personal` also preserves fixes
from the previous beta1 personal build where RC2.7 still needs them.

## Structure changes

- Ball Lightning: errors from the optional MK2 extension no longer invalidate a
  valid MK1 structure.
- Swelegfyr Blast Furnace: an upgraded controller checks the required T2 shape
  directly and retains its errors; an unupgraded controller can fall back from
  optional T2 to T1 without carrying T2 errors or partial hatch state forward.
- User testing with the structure-only JAR reported that both affected machines
  can now form. This confirms formation only; recipe processing, save/reload,
  invalid structures, and all orientations were not reported as tested.

## Previous personal fixes

| Fix | RC2 handling |
| --- | --- |
| Chemical Distorter recipe maps | Already handled in RC2.7; no old API patch copied. |
| Alternative recipe inputs, including steel and SoC wafers | RC2.7 uses the GTNH parallel calculator/input consumer; no beta1 calculator copied. |
| Laser Meteor Miner T2 fallback | Already handled in RC2.7. |
| ACAL circuit imprint refresh | Refresh the imprint set from the current inventory when queried. |
| Solidifier shared/manual mold inputs | Bypass the pattern-only pre-filter in solidifier mode so GTNH checks merged inputs. |
| Solidifier hatch mold acceptance | Populate the existing mold set and discover zero-quantity recipe catalysts. |
| Conditional Thaumonomicon research parents | Use the welcome research when the Essentia Discretizer is disabled. Keep the intended parent when enabled, even though it registers later. |

Input consumption remains the native GTNH recipe behavior. Zero-quantity
catalysts remain reusable; positive-quantity inputs, including exceptional
solidification recipes and single-use molds, remain consumable.

The reverted wireless-input transaction experiment remains excluded.

## Build and verification

```powershell
.\gradlew.bat check assemble --console=plain --no-daemon --no-configuration-cache -PdisableSpotless=true -PautoUpdateBuildScript=false
```

Spotless is disabled because fetching the shared formatter configuration failed
with connection resets/timeouts in this environment. No source formatting policy
was changed. This upstream revision has no automated tests, so `test NO-SOURCE`
must not be represented as a passing game regression suite.

The additional migrated personal fixes need an RC2 in-game smoke test: manual
mold insertion before/after a queued pattern, mold removal after processing,
a positive-quantity solidification input, a reloaded imprint hatch, and the TST
Thaumonomicon tab with Essentia Discretizer disabled.

## Installation

Use the ordinary reobfuscated runtime JAR on both client and server, replacing
the existing TST JAR. The `-dev` and `-sources` JARs are development artifacts.
Keep the previous JAR and a world backup for rollback.
