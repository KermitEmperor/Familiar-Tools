package com.kermitemperor.familiartools;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings({"unused", "SameParameterValue"})
public class FTTags {

    public static class Items {
        public static final TagKey<Item> HEADLESS = tag("headless");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FamiliarTools.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}