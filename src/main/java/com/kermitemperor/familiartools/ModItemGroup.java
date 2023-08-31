package com.kermitemperor.familiartools;

import com.mojang.logging.LogUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class ModItemGroup extends CreativeModeTab {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String PATH = "textures/gui/container/creative_inventory/";
    public ModItemGroup(String label) {
        super(label);
        this.setBackgroundImage(new ResourceLocation(FamiliarTools.MOD_ID, PATH + "tab_familiar_tools.png" ));
        this.hideTitle();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> pItems) {
        for(Item item : Registry.ITEM) {
            item.fillItemCategory(this, pItems);}
    }

    @Nonnull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Blocks.DIAMOND_BLOCK.asItem());
    }
    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public int getSearchbarWidth() {
        return 88;
    }

    @Nonnull
    @Override
    public ResourceLocation getTabsImage() {
        return new ResourceLocation(FamiliarTools.MOD_ID, PATH + "tab_familiar_tools_tabs.png");
    }
}
