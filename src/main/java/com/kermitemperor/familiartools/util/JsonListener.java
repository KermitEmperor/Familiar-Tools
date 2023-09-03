package com.kermitemperor.familiartools.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.*;


public class JsonListener extends SimpleJsonResourceReloadListener {
    public static List<JsonElement> TOOLMATERIALS;
    public static Dictionary<String, JsonElement> MATERIALSDICT;
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final JsonListener instance = new JsonListener();

    public JsonListener() {
        super(GSON, "materials");
        TOOLMATERIALS = new ArrayList<>();
        MATERIALSDICT = new Hashtable<>();
        LOGGER.info("do you work?");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> files, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        files.forEach((resourceLocation, jsonElement) -> {
            LOGGER.info("%s ||| %s".formatted(resourceLocation, jsonElement));
            TOOLMATERIALS.add(jsonElement);
            MATERIALSDICT.put(String.valueOf(resourceLocation), jsonElement);
        });
        //LOGGER.info(teststring + "HELL");
    }
}
