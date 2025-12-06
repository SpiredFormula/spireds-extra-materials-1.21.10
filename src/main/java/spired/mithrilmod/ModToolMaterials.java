package spired.mithrilmod;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {

    public static final ToolMaterial MITHRIL_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            1561,8.0F,3.0F,10,
            MithrilArmorMaterial.REPAIRS_MITHRIL_ARMOR
    );
}
