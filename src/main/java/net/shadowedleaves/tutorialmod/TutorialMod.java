package net.shadowedleaves.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.shadowedleaves.tutorialmod.block.ModBlocks;
import net.shadowedleaves.tutorialmod.block.entity.ModBlockEntities;
import net.shadowedleaves.tutorialmod.entity.ModBoats;
import net.shadowedleaves.tutorialmod.entity.ModEntities;
import net.shadowedleaves.tutorialmod.entity.custom.PorcupineEntity;
import net.shadowedleaves.tutorialmod.item.ModItemGroups;
import net.shadowedleaves.tutorialmod.item.ModItems;
import net.shadowedleaves.tutorialmod.recipe.ModRecipes;
import net.shadowedleaves.tutorialmod.screen.ModScreenHandlers;
import net.shadowedleaves.tutorialmod.sound.ModSounds;
import net.shadowedleaves.tutorialmod.util.ModCustomTrades;
import net.shadowedleaves.tutorialmod.util.ModLootTableModifiers;
import net.shadowedleaves.tutorialmod.villager.ModVillagers;
import net.shadowedleaves.tutorialmod.world.gen.ModWorldGeneration;
import net.shadowedleaves.tutorialmod.world.tree.ModFoliagePlacerTypes;
import net.shadowedleaves.tutorialmod.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModVillagers.registerVillagers();
		ModSounds.registerSounds();
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_LOG, ModBlocks.STRIPPED_CHESTNUT_LOG);
		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_WOOD, ModBlocks.STRIPPED_CHESTNUT_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LEAVES, 30, 60);
		ModBoats.registerBoats();
		ModWorldGeneration.generateModWorldGen();
		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();
		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.RUBY_BLOCK)
				.lightWithItem(ModItems.RUBY_STAFF)
				.destDimID(new Identifier(TutorialMod.MOD_ID, "shadoweddim"))
				.tintColor(0x9d0c62)
				.registerPortal();
	}
}
