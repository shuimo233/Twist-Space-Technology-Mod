# Suggested title

Ball Lightning MK1 fails to form; upgraded Swelegfyr structure checks discard errors

### Describe the bug

On GTNH 2.9.0-RC2 with TST 0.8.0-RC2.7, the reporter observed that Ball Lightning
would only form with the tier 2 structure, while a tier 1 structure failed to
form. The reporter also observed a tier 2 Swelegfyr Blast Furnace failing to
form after using its controller upgrade chip.

Code inspection identifies shared structure-error lists as a problem:
Ball Lightning appends errors for the optional MK2 extension to the main error
list. Swelegfyr clears required T2 errors and falls back to T1 even after its
controller has been upgraded.

### How to reproduce the bug

1. Use GTNH 2.9.0-RC2 with the official TST 0.8.0-RC2.7 JAR.
2. Build Ball Lightning's valid MK1 structure without its optional MK2 extension
   and trigger a structure check. The reported result is failure to form.
3. Add the MK2 extension and recheck. The reporter observed that this formed.
4. Separately, upgrade a Swelegfyr Blast Furnace controller and check its T2
   structure. This also failed in the reported setup, but the exact failing
   block/coordinate and a complete world reproduction are not available.

### Which mod/modpack versions are you using?

GTNH: 2.9.0-RC2
TST: 0.8.0-RC2.7

### Crash log

No crash occurred. A current `fml-client-latest.log` link has not been supplied.
The repository issue form marks this field as required; attach a suitable log
before submitting the issue.

### Additional details

The reporter subsequently tested a local build with isolated optional structure
errors and corrected upgraded-controller checks, and reported that both affected
machines could form. This is a formation test, not a full machine regression.

The Ball Lightning cause is established from the code and matches the reported
symptom. The initial Swelegfyr failure lacks scanner evidence, so its complete
cause should not be asserted from the field report alone.
