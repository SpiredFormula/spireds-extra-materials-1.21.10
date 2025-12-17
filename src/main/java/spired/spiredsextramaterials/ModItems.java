package spired.spiredsextramaterials;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    // Register all items
    public static Item RAW_MITHRIL = registerItem("raw_mithril", Item::new, new Item.Properties());
    public static Item MITHRIL_INGOT = registerItem("mithril_ingot",Item::new, new Item.Properties());
    // Tools
    public static Item MITHRIL_SWORD = registerItem("mithril_sword", Item::new, new Item.Properties().sword(ModToolMaterials.MITHRIL_TOOL_MATERIAL,3.0F, -2.4F ));
    public static Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe", Item::new, new Item.Properties().pickaxe(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 1F, -2.8F));
    public static Item MITHRIL_AXE = registerItem("mithril_axe", properties -> new AxeItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 6F, -3.1F, properties) , new Item.Properties());
    public static Item MITHRIL_SHOVEL = registerItem("mithril_shovel", properties -> new ShovelItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, 1.5F, -3F, properties), new Item.Properties());
    public static Item MITHRIL_HOE = registerItem("mithril_hoe", properties -> new HoeItem(ModToolMaterials.MITHRIL_TOOL_MATERIAL, -2F, -1F, properties), new Item.Properties());

    //Armor
    public static final Item MITHRIL_HELMET = registerItem("mithril_helmet", Item::new,
            new Item.Properties().humanoidArmor(MithrilArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_CHESTPLATE = registerItem("mithril_chestplate", Item::new,
            new Item.Properties().humanoidArmor(MithrilArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_LEGGINGS = registerItem("mithril_leggings", Item::new,
            new Item.Properties().humanoidArmor(MithrilArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(MithrilArmorMaterial.BASE_DURABILITY))
    );
    public static final Item MITHRIL_BOOTS = registerItem("mithril_boots", Item::new,
            new Item.Properties().humanoidArmor(MithrilArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(MithrilArmorMaterial.BASE_DURABILITY))
    );

    // Create creative tab
    public static ResourceKey<CreativeModeTab> MITHRIL_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(SpiredsExtraMaterials.MOD_ID, "mithril_group"));
    public static final  CreativeModeTab MITHRIL_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(MITHRIL_INGOT)).title(Component.translatable("mithrilGroup.spireds-extra-materials")).build();

    private static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Creates the Resource Key
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SpiredsExtraMaterials.MOD_ID, name));
        // Create the item instance
        Item item = itemFactory.apply(settings.setId(itemKey));
        // Registers the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return  item;
    }

    public static void initialize( ){
        // Register Creative Tab and add all items and block items to it
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MITHRIL_GROUP_KEY, MITHRIL_GROUP);
        ItemGroupEvents.modifyEntriesEvent(MITHRIL_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(RAW_MITHRIL);
            itemGroup.accept(MITHRIL_INGOT);
            itemGroup.accept(MITHRIL_SWORD);
            itemGroup.accept(MITHRIL_PICKAXE);
            itemGroup.accept(MITHRIL_AXE);
            itemGroup.accept(MITHRIL_SHOVEL);
            itemGroup.accept(MITHRIL_HOE);
            itemGroup.accept(MITHRIL_HELMET);
            itemGroup.accept(MITHRIL_CHESTPLATE);
            itemGroup.accept(MITHRIL_LEGGINGS);
            itemGroup.accept(MITHRIL_BOOTS);
            itemGroup.accept(ModBlocks.MITHRIL_ORE.asItem());
        });
    }
}
