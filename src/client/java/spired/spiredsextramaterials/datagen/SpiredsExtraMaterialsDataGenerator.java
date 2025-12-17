package spired.spiredsextramaterials.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SpiredsExtraMaterialsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator){
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(SpiredsExtraMaterialsRecipeProvider::new);
        pack.addProvider(SpiredsExtraMaterialsBlockLootTableProvider::new);
        pack.addProvider(SpiredsExtraMaterialsBlockTagProvider::new);
        pack.addProvider(SpiredsExtraMaterialsModelProvider::new);
        pack.addProvider(SpiredsExtraMaterialsItemTagProvider::new);
    }
}
