package com.Nxer.TwistSpaceTechnology.common.machine.singleBlock.hatch;

final class SolidifierInputPolicy {

    private SolidifierInputPolicy() {}

    static boolean isRecipeCatalyst(int stackSize) {
        return stackSize == 0;
    }
}
