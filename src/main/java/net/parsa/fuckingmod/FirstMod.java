package net.parsa.fuckingmod;

import net.fabricmc.api.ModInitializer;
import net.parsa.fuckingmod.block.ModBlocks;
import net.parsa.fuckingmod.item.ModItems;
import net.parsa.fuckingmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "fuckingmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

	}
}
