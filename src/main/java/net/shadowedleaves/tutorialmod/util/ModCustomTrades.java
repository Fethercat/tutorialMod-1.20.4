package net.shadowedleaves.tutorialmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.shadowedleaves.tutorialmod.block.ModBlocks;
import net.shadowedleaves.tutorialmod.item.ModItems;
import net.shadowedleaves.tutorialmod.villager.ModVillagers;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.TOMATO, 6),
                            6, 5, 0.05f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.TOMATO_SEEDS, 1),
                            2, 7, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.RUBY, 16),
                            new ItemStack(ModItems.CORN_SEEDS, 1),
                            4, 7, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 32),
                            EnchantedBookItem
                                    .forEnchantment(new EnchantmentLevelEntry(Enchantments.INFINITY, 2)),
                            3, 12, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 1),
                            new ItemStack(Items.END_STONE, 8),
                            new ItemStack(ModBlocks.END_STONE_RUBY_ORE, 1),
                            8, 5, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY_STAFF, 1),
                            new ItemStack(Items.DRAGON_HEAD, 1),
                            new ItemStack(ModBlocks.SOUND_BLOCK, 1),
                            1, 10, 0.075f));
                });


        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(ModItems.COAL_BRIQUETTE, 1),
                            8, 6, 0.075f));
                });

        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItems.METAL_DETECTOR, 1),
                            4, 12, 0.075f));
                });
    }
}