package spired.spiredsextramaterials.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import spired.spiredsextramaterials.ModItems;

public class SpiredsExtraMaterialsRecipeProvider extends FabricRecipeProvider {

    public SpiredsExtraMaterialsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                oreSmelting(
                        List.of(ModItems.RAW_MITHRIL), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.MITHRIL_INGOT, // Output
                        0.7f, // Experience
                        200, // Cooking time
                        "mithril_ingot" // group
                );

                oreBlasting(
                        List.of(ModItems.RAW_MITHRIL),
                        RecipeCategory.MISC,
                        ModItems.MITHRIL_INGOT,
                        0.7f,
                        100,
                        "mithril_ingot"
                );
            }
        };


    }

    @Override
    public String getName() {
        return "MithrilModRecipeProvider";
    }
}