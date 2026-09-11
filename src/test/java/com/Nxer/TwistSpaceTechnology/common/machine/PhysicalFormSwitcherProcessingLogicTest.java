package com.Nxer.TwistSpaceTechnology.common.machine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PhysicalFormSwitcherProcessingLogicTest {

    @Test
    void solidifierModeDoesNotPreFilterPatternsBeforeSharedMoldsAreMerged() {
        assertTrue(PhysicalFormSwitcherInputPolicy.shouldBypassPatternCache(0));
        assertFalse(PhysicalFormSwitcherInputPolicy.shouldBypassPatternCache(1));
    }
}
