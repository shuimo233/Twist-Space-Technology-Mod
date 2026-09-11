package com.Nxer.TwistSpaceTechnology.common.machine.singleBlock.hatch;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolidifierInputPolicyTest {

    @Test
    void onlyZeroSizedRecipeItemsAreDiscoveredAsCatalysts() {
        assertTrue(SolidifierInputPolicy.isRecipeCatalyst(0));
        assertFalse(SolidifierInputPolicy.isRecipeCatalyst(1));
        assertFalse(SolidifierInputPolicy.isRecipeCatalyst(16));
    }
}
