package net.shadowedleaves.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModArmorItem extends ArmorItem {

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (player.getInventory().armor.stream().allMatch(itemStack -> itemStack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == this.material)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2, 1,
                        false, false, false));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}