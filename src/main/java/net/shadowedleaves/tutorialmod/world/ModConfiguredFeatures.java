package net.shadowedleaves.tutorialmod.world;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.shadowedleaves.tutorialmod.TutorialMod;
import net.shadowedleaves.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.shadowedleaves.tutorialmod.world.tree.custom.ChestnutFoliagePlacer;
import net.shadowedleaves.tutorialmod.world.tree.custom.ChestnutTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_RUBY_ORE_KEY = registerKey("end_ruby_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CHESTNUT_KEY = registerKey("chestnut");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldRubyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endRubyOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_RUBY_ORE.getDefaultState()));

        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 6));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 8));
        register(context, END_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRubyOres, 4));

        register(context, CHESTNUT_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHESTNUT_LOG),
                new ChestnutTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(ModBlocks.CHESTNUT_LEAVES),
                new ChestnutFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}