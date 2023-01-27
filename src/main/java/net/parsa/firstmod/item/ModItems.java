package net.parsa.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.parsa.firstmod.FirstMod;

public class ModItems {

    public static final Item RAW_FUCK = registerItem("raw_fuck",
            new Item(new Item.Settings()), ModItemGroup.FUCK);
    public static final Item LUKEWARM_FUCK = registerItem("lukewarm_fuck",
            new Item(new Item.Settings()), ModItemGroup.FUCK);

    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }


    public static void registerModItems(){
        FirstMod.LOGGER.debug("Registering mod items for: " + FirstMod.MOD_ID);
    }

}
