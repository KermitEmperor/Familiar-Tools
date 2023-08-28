package com.kermitemperor.familiar_tools.tools;

import com.kermitemperor.familiar_tools.FamiliarTools;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ToolBase extends Item {
    public static final String NBT_COLOR = "HeadColor";
    public ToolBase(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
        if (group == FamiliarTools.FAMILIAR_TAB) {
            ItemStack stack = new ItemStack(this);
            CompoundTag nbt = stack.getOrCreateTag();
            nbt.putInt("HeadColor", 0x385374);
            items.add(stack);
        }
    }
    public static void setToolColor(ItemStack stack, int color) {
        stack.getOrCreateTag().putInt(NBT_COLOR, color);
    }
    
    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        setToolColor(stack,0x385374);
        return stack;
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains(NBT_COLOR)) {
            tooltip.add(Component.nullToEmpty("#" + Integer.toHexString(tag.getInt(NBT_COLOR)).toUpperCase()));
        }
    }
}
