package net.parsa.fuckingmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.parsa.fuckingmod.FirstMod;
import net.parsa.fuckingmod.block.ModBlocks;
import net.parsa.fuckingmod.item.ModItems;

public class ModVillagers {
    public static final PointOfInterestType HARD_FUCK_POI = registerPOI("hard_fuck_poi", ModBlocks.HARD_FUCK);
    public static final VillagerProfession FUCK_MAN = registerProfession("fuck_man",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(FirstMod.MOD_ID, "hard_fuck_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(FirstMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(FirstMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(FirstMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        FirstMod.LOGGER.debug("Registering Villagers for " + FirstMod.MOD_ID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(FUCK_MAN,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModItems.FUCK_SEEDS, 5),
                            6, 4, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(FUCK_MAN,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RAW_FUCK, 3),
                            new ItemStack(ModItems.LUKEWARM_FUCK, 3),
                            10, 3, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(FUCK_MAN,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.LUKEWARM_FUCK, 5),
                            new ItemStack(ModItems.RAW_FUCK, 5),
                            new ItemStack(ModItems.FUCK_TELLER, 1),
                            10, 1, 0.02f
                    )));
                });
    }
}