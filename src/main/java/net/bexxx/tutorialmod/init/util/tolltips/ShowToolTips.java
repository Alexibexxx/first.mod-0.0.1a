package net.bexxx.tutorialmod.init.util.tolltips;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

import static net.bexxx.tutorialmod.TutorialMod.MODID;
import static net.minecraft.text.Text.translatable;

public class ShowToolTips {

    public static void showTooltips(List<Text> pTooltip, String tooltipShift) {

        if (Screen.hasShiftDown()) {
            pTooltip.add(translatable(tooltipShift));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_shift").formatted(Formatting.YELLOW));
        }
    }

    public static void showTooltips(List<Text> pTooltip, String tooltipShift, String tooltipCtrl) {

        if (Screen.hasShiftDown()) {
            pTooltip.add(translatable(tooltipShift));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_shift").formatted(Formatting.YELLOW));
        }

        if (Screen.hasControlDown()) {
            pTooltip.add(translatable(tooltipCtrl));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_ctrl").formatted(Formatting.GREEN));
        }
    }

    public static void showTooltips(List<Text> pTooltip, String tooltipShift, String tooltipCtrl, String tooltipAlt) {

        if (Screen.hasShiftDown()) {
            pTooltip.add(translatable(tooltipShift));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_shift").formatted(Formatting.YELLOW));
        }

        if (Screen.hasControlDown()) {
            pTooltip.add(translatable(tooltipCtrl));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_ctrl").formatted(Formatting.GREEN));
        }

        if (Screen.hasAltDown()) {
            pTooltip.add(translatable(tooltipAlt));
        } else {
            pTooltip.add(translatable("tooltip." + MODID + ".hold_alt").formatted(Formatting.AQUA));
        }
    }
}
