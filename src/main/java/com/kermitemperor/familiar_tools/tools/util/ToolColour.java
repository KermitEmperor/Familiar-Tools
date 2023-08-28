package com.kermitemperor.familiar_tools.tools.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ToolColour implements ItemColor {
    public static final String NBT_COLOR = "HeadColor";
    public static int getToolColor(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR);
    }
    @Override
    public int getColor(@NotNull ItemStack stack, int layer) {
        if (layer == 0)
            return Color.singleColor(0xffffff);
        if (layer == 1)
            return Color.singleColor(getToolColor(stack));
        return 0;
    }
}
