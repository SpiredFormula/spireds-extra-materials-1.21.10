package spired.spiredsextramaterials.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import spired.spiredsextramaterials.MithrilArmorMaterial;
import spired.spiredsextramaterials.ModBlocks;
import spired.spiredsextramaterials.ModItems;

public class SpiredsExtraMaterialsModelProvider extends FabricModelProvider {
    public SpiredsExtraMaterialsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.MITHRIL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RAW_MITHRIL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MITHRIL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateTrimmableItem(ModItems.MITHRIL_HELMET, MithrilArmorMaterial.MITHRIL_ARMOR_MATERIAL_KEY,ItemModelGenerators.TRIM_PREFIX_HELMET, false );
        itemModelGenerators.generateTrimmableItem(ModItems.MITHRIL_CHESTPLATE, MithrilArmorMaterial.MITHRIL_ARMOR_MATERIAL_KEY,ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false );
        itemModelGenerators.generateTrimmableItem(ModItems.MITHRIL_LEGGINGS, MithrilArmorMaterial.MITHRIL_ARMOR_MATERIAL_KEY,ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false );
        itemModelGenerators.generateTrimmableItem(ModItems.MITHRIL_BOOTS, MithrilArmorMaterial.MITHRIL_ARMOR_MATERIAL_KEY,ItemModelGenerators.TRIM_PREFIX_BOOTS, false );
    }
}
