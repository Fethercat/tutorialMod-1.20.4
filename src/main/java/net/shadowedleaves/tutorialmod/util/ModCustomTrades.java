package net.shadowedleaves.tutorialmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.shadowedleaves.tutorialmod.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.TOMATO, 6),
                            6, 5, 0.05f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.TOMATO_SEEDS, 6),
                            3, 10, 0.1f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.CORN, 6),
                            6, 5, 0.075f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.CORN_SEEDS, 3),
                            2, 15, 0.125f));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1,
                factories1 -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 32),
                                    EnchantedBookItem
                                            .forEnchantment(new EnchantmentLevelEntry(Enchantments.INFINITY, 1)),
                            4, 10, 0.15f));
                    TradeOfferHelper.registerWanderingTraderOffers(1,
                            factories2 -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(ModItems.RAW_RUBY, 4),
                                        new ItemStack(ModItems.COAL_BRIQUETTE, 1),
                                        16, 5, 0.075f));
                            });
                    TradeOfferHelper.registerWanderingTraderOffers(2,
                            factories3 -> {
                                factories.add((entity, random) -> new TradeOffer(
                                        new ItemStack(ModItems.RAW_RUBY, 16),
                                        new ItemStack(ModItems.METAL_DETECTOR, 1),
                                        1, 10, 0.075f));
                            });
                });
                });
    }
}
