package spired.spiredsextramaterials.item.custom;

import org.jetbrains.annotations.Nullable;


import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;


public class ModArmorItem extends Item {

    private RegistryEntry<StatusEffect> effect;
    private TagKey<Item> tag;
    private Supplier<StatusEffectInstance> effectSupplier;

    public ModArmorItem(net.minecraft.item.Item.Settings properties, TagKey<Item> t, Supplier<StatusEffectInstance> es) {
        super(properties);
        tag = t;
        effectSupplier = es;
        effect = effectSupplier.get().getEffectType();

    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerWorld serverLevel, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
        super.inventoryTick(itemStack, serverLevel, entity, equipmentSlot);

        if(!serverLevel.isClient()) {
            if(entity instanceof PlayerEntity){

                PlayerEntity player = (PlayerEntity) entity;

                // If player is not wearing the helmet then return
                if(!(player.getInventory().getStack(39).getItem().equals(this))) return;


                if(checkIfWearingFullSet(player) && checkArmorType(player, tag)){
                    boolean hasEffect = player.hasStatusEffect(effect);
                    if(!hasEffect){
                        player.addStatusEffect(effectSupplier.get());
                    }
                }
            }
        }
    }

    private boolean checkIfWearingFullSet(PlayerEntity player){
        PlayerInventory inventory =  player.getInventory();

        ItemStack boots = player.getInventory().getStack(36);
        ItemStack leggings = player.getInventory().getStack(37);
        ItemStack chestPlate = player.getInventory().getStack(38);
        ItemStack helmet = player.getInventory().getStack(39);

        // Check if the player has a full set of armor on
        if (boots.isEmpty() || leggings.isEmpty() || chestPlate.isEmpty() || helmet.isEmpty()){
            return false;
        }
        return true;

    }
    private boolean checkArmorType(PlayerEntity player, TagKey<Item> tag){
        ItemStack boots = player.getInventory().getStack(36);
        ItemStack leggings = player.getInventory().getStack(37);
        ItemStack chestPlate = player.getInventory().getStack(38);
        ItemStack helmet = player.getInventory().getStack(39);

        // If all bits of armor have the correct tag return true
        return boots.streamTags().toList().contains(tag) && leggings.streamTags().toList().contains(tag)
                && chestPlate.streamTags().toList().contains(tag) && helmet.streamTags().toList().contains(tag);
    }

}
