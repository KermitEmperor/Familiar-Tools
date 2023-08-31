package com.kermitemperor.familiartools.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

import java.util.Map;

public class JsonListener extends SimpleJsonResourceReloadListener {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final JsonListener instance = new JsonListener();

    public JsonListener() {
        super(GSON, "materials");
        LOGGER.info("do you work?");
    }


    protected void apply(Map<ResourceLocation, JsonElement> jsonElementMap, ResourceManager p_10794_, ProfilerFiller p_10795_) {}
}
