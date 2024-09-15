package net.shadowedleaves.tutorialmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
//      Order for world generation:
//                RAW_GENERATION
//                LAKES
//                LOCAL_MODIFICATIONS
//                UNDERGROUND_STRUCTURES
//                SURFACE_STRUCTURES
//                STRONGHOLDS
//                UNDERGROUND_ORES
//                UNDERGROUND_DECORATION
//                FLUID_SPRINGS
//                VEGETAL_DECORATION
//                TOP_LAYER_MODIFICATION
    }
}
