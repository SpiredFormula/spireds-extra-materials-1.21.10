package spired.spiredsextramaterials.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import spired.spiredsextramaterials.SpiredsExtraMaterials;

public class ModTags {

    public static final TagKey<Item> MITHRIL_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(SpiredsExtraMaterials.MOD_ID, "mithril_armor"));
    public static void initialize(){

    }
}
