package com.kermitemperor.familiartools.tools;

import com.google.gson.JsonObject;
import com.kermitemperor.familiartools.FamiliarTools;
import com.kermitemperor.familiartools.util.StringUtil.*;
import com.mojang.logging.LogUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.kermitemperor.familiartools.util.StringUtil.capitalize;

public class ToolBase extends Item {
    public static final String NBT_COLOR_HEAD = "HeadColor";
    public static final String NBT_COLOR_BASE = "BaseColor";
    public static final String NBT_TIER = "Tier";
    public ToolBase(Properties pProperties) {
        super(pProperties);
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
        if (group == FamiliarTools.FAMILIAR_TAB) {
            ItemStack stack = new ItemStack(this);
            CompoundTag nbt = stack.getOrCreateTag();
            //SO MUCH PAIN


            JsonObject textComponent = new JsonObject();
            textComponent.addProperty("text", "Nice %s".formatted(capitalize(this.getRegistryName().getPath())));
            textComponent.addProperty("italic", false);
            String jsonDisplayName = textComponent.toString();

            CompoundTag namenbt = new CompoundTag();
            namenbt.putString("Name", jsonDisplayName);
            nbt.put("display", namenbt);

            nbt.putInt(NBT_TIER, 1);
            nbt.putInt(NBT_COLOR_HEAD, 0x385374);
            nbt.putInt(NBT_COLOR_BASE, 0xABC008);
            items.add(stack);
        }
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
