package net.shadowedleaves.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.shadowedleaves.tutorialmod.block.ModBlocks;
import net.shadowedleaves.tutorialmod.item.ModItemGroups;
import net.shadowedleaves.tutorialmod.item.ModItems;
import net.shadowedleaves.tutorialmod.sound.ModSounds;
import net.shadowedleaves.tutorialmod.util.ModCustomTrades;
import net.shadowedleaves.tutorialmod.util.ModLootTableModifiers;
import net.shadowedleaves.tutorialmod.villager.ModVillagers;
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
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}