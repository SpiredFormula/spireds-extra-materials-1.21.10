package spired.mithrilmod.datgen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MithrilModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator){
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MithrilModRecipeProvider::new);
        pack.addProvider(MithrilModBlockLootTableProvider::new);
        pack.addProvider(MithrilModBlockTagProvider::new);
        pack.addProvider(MithrilModModelProvider::new);
        pack.addProvider(MithrilModItemTagProvider::new);
    }
}
