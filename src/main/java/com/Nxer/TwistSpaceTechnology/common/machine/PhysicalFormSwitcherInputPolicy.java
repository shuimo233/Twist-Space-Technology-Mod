package com.Nxer.TwistSpaceTechnology.common.machine;

final class PhysicalFormSwitcherInputPolicy {

    private PhysicalFormSwitcherInputPolicy() {}

    static boolean shouldBypassPatternCache(int machineMode) {
        return machineMode == 0;
    }
}
