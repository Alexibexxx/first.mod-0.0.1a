package net.bexxx.tutorialmod.init.items.custom;

import net.bexxx.tutorialmod.init.util.tab.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class TanzanitePickaxe extends PickaxeItem {
    public TanzanitePickaxe(ToolMaterial material, int i, float v, FabricItemSettings group) {
        super(material, 2, 2.8f, new Item.Settings().group(ModItemGroup.TANZANITE_TOOLS).maxCount(1));
    }
}

