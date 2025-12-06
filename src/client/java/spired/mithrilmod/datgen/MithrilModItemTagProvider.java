package spired.mithrilmod.datgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jetbrains.annotations.Nullable;
import spired.mithrilmod.MithrilArmorMaterial;
import spired.mithrilmod.ModItems;

import java.util.concurrent.CompletableFuture;

public class MithrilModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MithrilModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public MithrilModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.MITHRIL_HELMET);
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.MITHRIL_CHESTPLATE);
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.MITHRIL_LEGGINGS);
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.MITHRIL_BOOTS);

        valueLookupBuilder(MithrilArmorMaterial.REPAIRS_MITHRIL_ARMOR).add(ModItems.MITHRIL_INGOT);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.MITHRIL_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.MITHRIL_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.MITHRIL_AXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.MITHRIL_SHOVEL);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.MITHRIL_HOE);
    }
}
