package net.bexxx.tutorialmod.init.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.bexxx.tutorialmod.TutorialMod.MODID;

public class SevenBallItem extends Item {
    private final String tooltipAlt;
    public SevenBallItem(Settings settings, String tooltipAlt) {
        super(settings);

        this.tooltipAlt = tooltipAlt;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            // output a random number
            outputRandomNumber(user);
            // add a cooldown
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasAltDown()) {
            tooltip.add(Text.translatable(tooltipAlt).formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.translatable("tooltip." + MODID + ".hold_alt").formatted(Formatting.DARK_RED));
        }
    }

    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.literal("Your Number is " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return Random.createLocal().nextInt(7);
    }
}
