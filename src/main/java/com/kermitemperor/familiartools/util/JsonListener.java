package com.kermitemperor.familiartools.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class JsonListener extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final JsonListener instance = new JsonListener();

    public JsonListener() {
        super(GSON, "materials");
    }


    protected void apply(Map<ResourceLocation, JsonElement> jsonElementMap, ResourceManager p_10794_, ProfilerFiller p_10795_) {}
}
