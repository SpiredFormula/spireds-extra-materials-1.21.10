package spired.spiredsextramaterials.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.item.*;
import spired.spiredsextramaterials.*;
import spired.spiredsextramaterials.blocks.ModBlocks;
import spired.spiredsextramaterials.item.custom.ModArmorItem;
import spired.spiredsextramaterials.util.ModTags;

import java.util.function.Function;

public class ModItems {
    // Register all items
    public static Item RAW_MITHRIL = registerItem("raw_mithril", Item::new, new Item.Settings());
    public static Item MITHRIL_INGOT = registerItem("mithril_ingot",Item::new, new Item.Settings());
    // Tools
    public static Item MITHRIL_SWORD = registerItem("mithril_sword", Item::new, new Item.Settings().sword(ModToolMaterials.MITHRIL_TOOL_MATERIAL,3.0F, -2.4F ));
    public static Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe", Item::new, new Item.Settings().pickaxe(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 1F, -2.8F));
    public static Item MITHRIL_AXE = registerItem("mithril_axe", properties -> new AxeItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 6F, -3.1F, properties) , new Item.Settings());
    public static Item MITHRIL_SHOVEL = registerItem("mithril_shovel", properties -> new ShovelItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 1.5F, -3F, properties), new Item.Settings());
    public static Item MITHRIL_HOE = registerItem("mithril_hoe", properties -> new HoeItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, -2F, -1F, properties), new Item.Settings());
    //Armor
    // This is a MithrilArmorItem to detect if the player is wearing a full set
    public static final Item MITHRIL_HELMET = registerItem("mithril_helmet", properties -> new ModArmorItem(properties, ModTags.MITHRIL_ARMOR, () -> new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false )),
            new Item.Settings().armor(MithrilArmorMaterial.INSTANCE, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_CHESTPLATE = registerItem("mithril_chestplate", Item::new,
            new Item.Settings().armor(MithrilArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_LEGGINGS = registerItem("mithril_leggings", Item::new,
            new Item.Settings().armor(MithrilArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_BOOTS = registerItem("mithril_boots", Item::new,
            new Item.Settings().armor(MithrilArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(MithrilArmorMaterial.BASE_DURABILITY))
    );

    // Create creative tab
    public static RegistryKey<ItemGroup> MITHRIL_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(SpiredsExtraMaterials.MOD_ID, "mithril_group"));
    public static final  ItemGroup MITHRIL_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(MITHRIL_INGOT)).displayName(Text.translatable("mithrilGroup.spireds-extra-materials")).build();

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Creates the Resource Key
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpiredsExtraMaterials.MOD_ID, name));
        // Create the item instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        // Registers the item
        Registry.register(Registries.ITEM, itemKey, item);
        return  item;
    }

    public static void initialize( ){
        // Register Creative Tab and add all items and block items to it
        Registry.register(Registries.ITEM_GROUP, MITHRIL_GROUP_KEY, MITHRIL_GROUP);
        ItemGroupEvents.modifyEntriesEvent(MITHRIL_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(RAW_MITHRIL);
            itemGroup.add(MITHRIL_INGOT);
            itemGroup.add(MITHRIL_SWORD);
            itemGroup.add(MITHRIL_PICKAXE);
            itemGroup.add(MITHRIL_AXE);
            itemGroup.add(MITHRIL_SHOVEL);
            itemGroup.add(MITHRIL_HOE);
            itemGroup.add(MITHRIL_HELMET);
            itemGroup.add(MITHRIL_CHESTPLATE);
            itemGroup.add(MITHRIL_LEGGINGS);
            itemGroup.add(MITHRIL_BOOTS);
            itemGroup.add(ModBlocks.MITHRIL_ORE.asItem());
            itemGroup.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.asItem());
            itemGroup.add(ModBlocks.MITHRIL_BLOCK.asItem());
        });
    }
}
