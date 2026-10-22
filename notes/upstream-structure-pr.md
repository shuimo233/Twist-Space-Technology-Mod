# Suggested title

fix: isolate optional multiblock structure errors

# Suggested body

Ball Lightning rejects a valid MK1-only structure because checking the optional
MK2 extension appends errors to the same list used to determine whether the
machine forms. Keep the optional extension errors separate so MK1 forms at
structure tier 1 and a complete MK2 extension still selects tier 2.

Swelegfyr Blast Furnace currently clears T2 errors and falls back to T1 even
with an upgraded controller. If T1 succeeds, the method returns without reporting
the required T2 failure. Check T2 directly for upgraded controllers and preserve
its errors. Keep the optional T2 probe separate for unupgraded controllers and
clear partial hatch state before trying T1.

Validation:

- Based on TST `0.8.0-RC2.7` (`f59f8746`) and GTNH `2.9.0-RC2`.
- The local `test assemble` build succeeded; `test` was `NO-SOURCE`.
- The reporter tested a JAR containing only these two machine changes and
  reported that both Ball Lightning MK1 and the upgraded Swelegfyr Blast Furnace
  could form. No structure screenshot or scanner output was supplied.
- Formation is field-tested; invalid structures, every orientation, save/reload,
  and recipe processing have not been separately verified.

Only the two structure-checking changes from branch
`codex/gtnh-rc2-structure-fix` belong in this PR. The personal branch includes
unrelated compatibility fixes and should not be used as the PR head.

# Publication status

Prepared locally; not submitted. Review the description against the target
branch before publication. There is no PR template in the checked-out release.
