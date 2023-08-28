package com.kermitemperor.familiar_tools.tools;

import com.kermitemperor.familiar_tools.FamiliarTools;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class ToolBase extends Item implements ItemColor{
    public static final String NBT_COLOR = "HeadColor";
    public ToolBase() {
        super(new Properties().tab(FamiliarTools.FAMILIAR_TAB).stacksTo(1));
    }

    public static int getToolColor(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COLOR);
    }

    public static void setToolColor(ItemStack stack, int color) {
        stack.getOrCreateTag().putInt(NBT_COLOR, color);
    }

    public int getColor(@Nonnull ItemStack stack, int tintIndex) {
        return tintIndex == 1 ? getToolColor(stack) : 0x694c2d;
    }
}
