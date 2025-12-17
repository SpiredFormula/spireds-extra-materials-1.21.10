package spired.spiredsextramaterials.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import spired.spiredsextramaterials.ModBlocks;
import spired.spiredsextramaterials.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class SpiredsExtraMaterialsBlockLootTableProvider extends FabricBlockLootTableProvider {


    protected SpiredsExtraMaterialsBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropOther(ModBlocks.MITHRIL_ORE, ModItems.RAW_MITHRIL);
    }

    @Override
    public BlockLootSubProvider withConditions(ResourceCondition... conditions) {
        return super.withConditions(conditions);
    }

    @Override
    public BiConsumer<ResourceKey<LootTable>, LootTable.Builder> withConditions(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter, ResourceCondition... conditions) {
        return super.withConditions(exporter, conditions);
    }
}
