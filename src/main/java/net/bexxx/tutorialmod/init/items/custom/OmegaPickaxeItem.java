package net.bexxx.tutorialmod.init.items.custom;


import net.bexxx.tutorialmod.init.util.tolltips.ShowToolTips;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OmegaPickaxeItem extends PickaxeItem {
	private final String tooltipShift;
	private final int enchantability;
	public OmegaPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, int enchantability,
							Settings settings, String tooltipShift) {
		super(material, attackDamage, attackSpeed, settings);

		this.enchantability = enchantability;
		this.tooltipShift = tooltipShift;
	}

	@Override
	public int getEnchantability() {
		return enchantability; // return 50;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		ShowToolTips.showTooltips(tooltip, tooltipShift);
		// super.appendTooltip(stack, world, tooltip, context);
	}
}
