package net.bexxx.tutorialmod.init.villager;

import com.google.common.collect.ImmutableSet;
import net.bexxx.tutorialmod.TutorialMod;
import net.bexxx.tutorialmod.init.blocks.ModBlocks;
import net.bexxx.tutorialmod.init.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType JUMP_POI = registerPOI("jump_poi", ModBlocks.JUMP_BLOCK);
    public static final VillagerProfession JUMP_MASTER = registerProfession("jumpmaster",
        RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(TutorialMod.MODID, "jump_poi")));


    public static final PointOfInterestType TANZANITE_POI = registerPOI("tanzanite_poi", ModBlocks.TANZANITE_BLOCK);
    public static final VillagerProfession TANZANITE_TRADER = registerProfession("tanzanite_trader",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(TutorialMod.MODID, "tanzanite_poi")));
    public static final PointOfInterestType ENCHANTER_POI = registerPOI("enchanter_poi", Blocks.ENCHANTING_TABLE);
    public static final VillagerProfession ENCHANTER = registerProfession("enchanter",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(TutorialMod.MODID, "enchanter_poi")));
    public static final PointOfInterestType LAMP_POI = registerPOI("lamp_poi", Blocks.REDSTONE_BLOCK);
    public static final VillagerProfession LAMPER = registerProfession("lamper",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(TutorialMod.MODID, "lamp_poi")));



    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(TutorialMod.MODID, name),
                VillagerProfessionBuilder.create().id(new Identifier(TutorialMod.MODID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(TutorialMod.MODID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        TutorialMod.LOGGER.debug("Registering Villagers For " + TutorialMod.MODID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(JUMP_MASTER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModItems.EGGPLANT, 5),
                            6, 2, 0.02f
                            )));
                });

            TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 10),
                                new ItemStack(ModItems.TANZANITE_PICKAXE),
                                20, 2, 0.02f
                        )));
                    });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModBlocks.TANZANITE_BLOCK),
                            20, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(ModItems.TANZANITE_SHARD_PIECE),
                            20, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.TANZANITE_SHARD),
                            20, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 15),
                            new ItemStack(ModItems.TANZANITE, 10),
                            20, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(Items.NETHERITE_PICKAXE),
                            15, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TANZANITE_TRADER, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.OMEGA_PICKAXE),
                            1, 2, 0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ENCHANTER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(Items.ENCHANTED_BOOK),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(ENCHANTER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 50),
                            new ItemStack(Items.BEACON),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(ENCHANTER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.NETHER_STAR, 15),
                            new ItemStack(Items.ANCIENT_DEBRIS, 50),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(LAMPER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 15),
                            new ItemStack(ModBlocks.TANZANITE_LAMP, 2),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(LAMPER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 15),
                            new ItemStack(Blocks.REDSTONE_LAMP, 2),
                            10, 2, 0.02f
                    )));
                });
        }




    }



