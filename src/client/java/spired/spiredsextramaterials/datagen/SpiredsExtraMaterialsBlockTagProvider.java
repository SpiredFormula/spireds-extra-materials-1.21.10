package spired.spiredsextramaterials.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import spired.spiredsextramaterials.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class SpiredsExtraMaterialsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SpiredsExtraMaterialsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MITHRIL_ORE);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MITHRIL_ORE);


    }
}
