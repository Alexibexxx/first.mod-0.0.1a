package net.bexxx.tutorialmod.init.items;

import net.bexxx.tutorialmod.init.blocks.ModBlocks;
import net.bexxx.tutorialmod.init.items.custom.EightBallItem;
import net.bexxx.tutorialmod.init.items.custom.OmegaPickaxeItem;
import net.bexxx.tutorialmod.init.items.custom.SevenBallItem;
import net.bexxx.tutorialmod.init.items.util.tiers.ModToolMaterials;
import net.bexxx.tutorialmod.init.util.tab.ModItemGroup;
import net.bexxx.tutorialmod.init.util.tolltips.ShowToolTips;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

import static net.bexxx.tutorialmod.TutorialMod.LOGGER;
import static net.bexxx.tutorialmod.TutorialMod.MODID;
public class ModItems {

    /** Stones, Minerals & Gems */
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    /**Tools, Weapons & Armors */
    public static final Item TANZANITE_SHARD = registerItem("tanzanite_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE_TOOLS)));

    public static final Item TANZANITE_SHARD_PIECE = registerItem("tanzanite_shard_piece",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE_TOOLS)));

    public static final Item TANZANITE_PICKAXE = registerItem("tanzanite_pickaxe",
        new PickaxeItem(ModToolMaterials.TANZANITE, 1, 3f,
                new FabricItemSettings().group(ModItemGroup.TANZANITE_TOOLS)));

    public static final Item OMEGA_PICKAXE = registerItem("omega_pickaxe",
          new OmegaPickaxeItem(ModToolMaterials.OMEGA, 2, 2.0F, 50,
                  new FabricItemSettings().group(ModItemGroup.OMEGA_TOOLS), "tooltip.omega_pickaxe.shift"));

    /**other Stuff */
    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.EIGHTBALL),
                    "tooltip.tutorialmod.eight_ball.shift"));
    public static final Item EIGHT_BALL_SHARD = registerItem("eight_ball_shard",
        new Item(new FabricItemSettings().group(ModItemGroup.EIGHTBALL)));

    public static final Item SEVEN_BALL = registerItem("seven_ball",
            new SevenBallItem(new FabricItemSettings().group(ModItemGroup.EIGHTBALL),
                    "tooltip.tutorialmod.seven_ball.alt"));
    public static final Item SEVEN_BALL_SHARD = registerItem("seven_ball_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.EIGHTBALL)));

    /** Crops, Seeds, Food & Drinks */
    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.PLANTS)
                    .food(new FoodComponent.Builder().hunger(4)
                            .saturationModifier(4f).alwaysEdible().build())));

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP, new FabricItemSettings().group(ModItemGroup.PLANTS)));


    /** registering the Items */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item); }

    private static Item registerItem(String name, Item item, List<Text> pTooltip, String tooltipShift) {
        ShowToolTips.showTooltips(pTooltip, tooltipShift);
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item); }

    public static void registerModItems() { LOGGER.debug("Registering Mod Items for " + MODID); }
}
