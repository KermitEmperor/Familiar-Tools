package com.kermitemperor.familiartools;

import com.kermitemperor.familiartools.config.FTCommonConfig;
import com.kermitemperor.familiartools.init.FTItems;
import com.kermitemperor.familiartools.util.FamiliarToolsRegistrate;
import com.kermitemperor.familiartools.util.JsonListener;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(FamiliarTools.MOD_ID)
public class FamiliarTools {

    public static final String MOD_ID = "familiartools";
    public static final CreativeModeTab FAMILIAR_TAB = new FTItemGroup("familiar_tab");

    public static final FamiliarToolsRegistrate registrate = FamiliarToolsRegistrate.create(MOD_ID);
    private static final Logger LOGGER = LogUtils.getLogger();



    public FamiliarTools() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        
        FTItems.register();
        registrate.registerEventListeners(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FTCommonConfig.SPEC, "familiartools-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @SubscribeEvent
    public void jsonReading(AddReloadListenerEvent event) {
        event.addListener(JsonListener.instance);
    }
    
    public static @NotNull FamiliarToolsRegistrate registrate() {
        return registrate;
    }

}
