package com.kermitemperor.familiartools.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Collections;
import java.util.List;

public class FTCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BLACKLIST_TOOLS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> INVERT;

    static {
        BUILDER.push("Configs for Familiar Tools");

        BLACKLIST_TOOLS = BUILDER.comment("Blacklist for tools to be not added in to creative tabs (ex.: [\"hammer\", \"file\", \"wrench\"])")
                .defineListAllowEmpty(List.of("blacklist_tools"), Collections::emptyList, (element) -> element instanceof String || element == null);

        INVERT = BUILDER.comment("If blacklist_tools should be inverted to white list").define("blacklist_tools_to_white", false);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }


}
