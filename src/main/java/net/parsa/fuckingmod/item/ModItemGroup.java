package net.parsa.fuckingmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.parsa.fuckingmod.FirstMod;

public class ModItemGroup {
    public static final ItemGroup FUCK = FabricItemGroup.builder(new Identifier(FirstMod.MOD_ID))
            .displayName(Text.literal("FUCK"))
            .icon(() -> new ItemStack(ModItems.LUKEWARM_FUCK))
            .build();
}
