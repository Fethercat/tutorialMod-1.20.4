package net.shadowedleaves.tutorialmod.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.shadowedleaves.tutorialmod.TutorialMod;
import net.shadowedleaves.tutorialmod.mixin.TrunkPlacerTypeInvoker;
import net.shadowedleaves.tutorialmod.world.tree.custom.ChestnutTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> CHESTNUT_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("chestnut_trunk_placer", ChestnutTrunkPlacer.CODEC);

    public static void register() {
        TutorialMod.LOGGER.info("Registering Trunk Placers for " + TutorialMod.MOD_ID);
    }
}
