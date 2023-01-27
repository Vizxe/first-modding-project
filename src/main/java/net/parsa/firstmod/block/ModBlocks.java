package net.parsa.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.parsa.firstmod.FirstMod;
import net.parsa.firstmod.item.ModItemGroup;

public class ModBlocks {

    public static final Block HARD_FUCK = registerBlock("hard_fuck",
            new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.25f).strength(2f).requiresTool()));

    public static final Block FUCK_ORE = registerBlock("fuck_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.METAL).slipperiness(1f).strength(2f).requiresTool(), UniformIntProvider.create(3,10)));

    public static final Block HARD_FUCK_ORE = registerBlock("hard_fuck_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.METAL).slipperiness(1f).strength(2f).requiresTool(), UniformIntProvider.create(3,10)));

    private static Block registerBlock(String name, Block block) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.FUCK).register(entries -> entries.add(block));
        Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        FirstMod.LOGGER.debug("Registering mod blocks for: " + FirstMod.MOD_ID);
    }

}
