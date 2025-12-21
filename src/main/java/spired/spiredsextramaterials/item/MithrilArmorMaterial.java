package spired.spiredsextramaterials.item;


import spired.spiredsextramaterials.SpiredsExtraMaterials;

import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
// TODO make this the ModArmorMaterial class for storing all Armor materials
public class MithrilArmorMaterial {
    public static final int BASE_DURABILITY = 15;

    public static final RegistryKey<EquipmentAsset> MITHRIL_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(SpiredsExtraMaterials.MOD_ID,"mithril"));

    public static final TagKey<Item> REPAIRS_MITHRIL_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(SpiredsExtraMaterials.MOD_ID, "repairs_mithril_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0F,
            0.0F,
            REPAIRS_MITHRIL_ARMOR,
            MITHRIL_ARMOR_MATERIAL_KEY
    );
}

