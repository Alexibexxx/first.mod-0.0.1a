package net.bexxx.tutorialmod;

import net.bexxx.tutorialmod.init.blocks.ModBlocks;

import net.bexxx.tutorialmod.init.fluid.ModFluids;
import net.bexxx.tutorialmod.init.items.ModItems;
import net.bexxx.tutorialmod.init.paintings.ModPaintings;
import net.bexxx.tutorialmod.init.util.loot.ModLootTableModifiers;
import net.bexxx.tutorialmod.init.villager.ModVillagers;
import net.bexxx.tutorialmod.init.world.feature.ModConfiguredFeatures;
import net.bexxx.tutorialmod.init.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MODID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID.getClass());

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		ModPaintings.registerPaintings();
		ModOreGeneration.generateOres();
		ModLootTableModifiers.modifyLootTables();
		ModFluids.register();
	}
}

// TODO ORGANIZE FOLDERS


