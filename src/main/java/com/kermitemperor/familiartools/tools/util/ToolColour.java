package com.kermitemperor.familiartools.tools.util;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.kermitemperor.familiartools.tools.ToolBase.*;

public class ToolColour implements ItemColor {
    public static int getToolHeadColor(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR_HEAD);
    }

    public static int getToolBaseColor(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR_BASE);
    }
    @Override
    public int getColor(@NotNull ItemStack stack, int layer) {
        if (layer == 0)
            return Color.singleColor(getToolBaseColor(stack));
        if (layer == 1)
            return Color.singleColor(getToolHeadColor(stack));
        return Color.singleColor(0x0f0f0f);
    }
}
