package com.kermitemperor.familiartools.tools;

import com.kermitemperor.familiartools.FamiliarTools;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ToolBase extends Item {
    public static final String NBT_COLOR_HEAD = "HeadColor";
    public static final String NBT_COLOR_BASE = "BaseColor";
    public static final String NBT_NAME = "LocalizedName";
    public static final String NBT_TIER = "Tier";
    public ToolBase(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
        if (group == FamiliarTools.FAMILIAR_TAB) {
            ItemStack stack = new ItemStack(this);
            CompoundTag nbt = stack.getOrCreateTag();
            CompoundTag namenbt = new CompoundTag();
            namenbt.putString("Name", "{Name:[{\"text\":\"Nice\",\"italic\":false}]}");
            nbt.put("display", namenbt);
            nbt.putString(NBT_NAME, "testing");
            nbt.putInt(NBT_TIER, 1);
            nbt.putInt(NBT_COLOR_HEAD, 0x385374);
            nbt.putInt(NBT_COLOR_BASE, 0xABC008);
            items.add(stack);
        }
    }

    public static String getToolName(ItemStack stack) {
        return stack.getOrCreateTag().getString(NBT_NAME);
    }

    public static int getToolTier(ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_TIER);
    }

    public static void setToolColor(ItemStack stack, int headcolor, int basecolor) {
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putInt(NBT_COLOR_HEAD, headcolor);
        nbt.putInt(NBT_COLOR_HEAD, basecolor);
    }
    
    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        setToolColor(stack,0x385374, 0xffffff);
        return stack;
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains(NBT_COLOR_HEAD)) {
            tooltip.add(Component.nullToEmpty("#" + Integer.toHexString(tag.getInt(NBT_COLOR_HEAD)).toUpperCase()));
        }
        if (tag.contains(NBT_COLOR_BASE)) {
            tooltip.add(Component.nullToEmpty("#" + Integer.toHexString(tag.getInt(NBT_COLOR_BASE)).toUpperCase()));
        }
    }
}
