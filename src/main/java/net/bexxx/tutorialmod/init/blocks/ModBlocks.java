package net.bexxx.tutorialmod.init.blocks;

import net.bexxx.tutorialmod.TutorialMod;
import net.bexxx.tutorialmod.init.blocks.custom.EggPlantCropBlock;
import net.bexxx.tutorialmod.init.blocks.custom.JumpBlock;
import net.bexxx.tutorialmod.init.blocks.custom.TanzaniteLampBlock;
import net.bexxx.tutorialmod.init.util.tab.ModItemGroup;
import net.bexxx.tutorialmod.init.util.tolltips.ShowToolTips;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.bexxx.tutorialmod.TutorialMod.MODID;

public class ModBlocks {

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(1).luminance(7)), ModItemGroup.TANZANITE);
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool(),
                    UniformIntProvider.create(7, 10)), ModItemGroup.TANZANITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool(),
                    UniformIntProvider.create(7, 10)), ModItemGroup.TANZANITE);
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool(),
                    UniformIntProvider.create(7, 10)), ModItemGroup.TANZANITE);
    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool(),
                    UniformIntProvider.create(7, 10)), ModItemGroup.TANZANITE);

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(1).luminance(7)), ModItemGroup.TANZANITE);
    public static final Block RUNY_ORE = registerBlock("ruby_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool(),
                    UniformIntProvider.create(7, 10)), ModItemGroup.TANZANITE);

    /** Plants, Seed, Food, Drinks */
    public static final Block EGGPLANT_CROP = registerBlockWithoutItem("eggplant_crop",
            new EggPlantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    /** Misc Stuff */
    public static final Block JUMP_BLOCK = registerBlock("jump_block",
            new JumpBlock(FabricBlockSettings.of(Material.METAL).strength(1)), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_LAMP = registerBlock("tanzanite_lamp",
            new  TanzaniteLampBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()
                    .luminance(state -> state.get(TanzaniteLampBlock.LIT) ? 15 : 0)), ModItemGroup.TANZANITE);


    /** registering Blocks without Item, ItemGroup or Tooltips */
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MODID, name), block); }

    /** registering Blocks with Items, but without Tooltips*/
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(MODID, name), block); }

    private static void registerBlockItem(String name, Block block, ItemGroup tab) {
        Registry.register(Registry.ITEM, new Identifier(MODID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    /** registering Block with Item but with Tooltip Shift */
    public static Block registerBlock(String blockName, Block block, ItemGroup tab, String tooltipShift) {
        registerBlockItem(blockName, block, tab, tooltipShift);
        return Registry.register(Registry.BLOCK, new Identifier(MODID, blockName), block);
    }

    private static void registerBlockItem(String blockName, Block block, ItemGroup tab, String tooltipShift) {
        Registry.register(Registry.ITEM, new Identifier(MODID, blockName),
                new BlockItem(block, new FabricItemSettings().group(tab)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        ShowToolTips.showTooltips(tooltip, tooltipShift);
                        // super.appendTooltip(stack, world, tooltip, context);
                    }
                });
    }

    /** registering Block with Item but with Tooltip Shift & Ctrl */
    public static Block registerBlock(String blockName, Block block, ItemGroup tab, String tooltipShift, String tooltipCtrl) {
        registerBlockItem(blockName, block, tab, tooltipShift, tooltipCtrl);
        return Registry.register(Registry.BLOCK, new Identifier(MODID, blockName), block);
    }

    private static void registerBlockItem(String blockName, Block block, ItemGroup tab, String tooltipShift, String tooltipCtrl) {
        Registry.register(Registry.ITEM, new Identifier(MODID, blockName),
                new BlockItem(block, new FabricItemSettings().group(tab)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        ShowToolTips.showTooltips(tooltip, tooltipShift, tooltipCtrl);
                        // super.appendTooltip(stack, world, tooltip, context);
                    }
                });
    }

    /** registering Block with Item but with Tooltip Shift & Ctrl & Alt */
    public static Block registerBlock(String blockName, Block block, ItemGroup tab, String tooltipShift, String tooltipCtrl, String tooltipAlt) {
        registerBlockItem(blockName, block, tab, tooltipShift, tooltipCtrl, tooltipAlt);
        return Registry.register(Registry.BLOCK, new Identifier(MODID, blockName), block);
    }

    private static void registerBlockItem(String blockName, Block block, ItemGroup tab, String tooltipShift, String tooltipCtrl, String tooltipAlt) {
        Registry.register(Registry.ITEM, new Identifier(MODID, blockName),
                new BlockItem(block, new FabricItemSettings().group(tab)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        ShowToolTips.showTooltips(tooltip, tooltipShift, tooltipCtrl, tooltipAlt);
                        // super.appendTooltip(stack, world, tooltip, context);
                    }
                });
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.debug("Registering ModBlocks for " + MODID);
    }
}
