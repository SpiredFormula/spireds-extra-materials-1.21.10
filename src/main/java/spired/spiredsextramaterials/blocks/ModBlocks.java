package spired.spiredsextramaterials.blocks;

import spired.spiredsextramaterials.SpiredsExtraMaterials;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block MITHRIL_ORE = registerBlock("mithril_ore", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0f,3.0f),true);
    public static Block DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(4.5F, 3.0F), true);
    public static Block MITHRIL_BLOCK = registerBlock("mithril_block", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.IRON).requiresTool().strength(5.0F, 6.0F), true);


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem){

        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SpiredsExtraMaterials.MOD_ID,name ));

        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if(shouldRegisterItem){
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpiredsExtraMaterials.MOD_ID,name ));
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void initialize(){

    }
}
