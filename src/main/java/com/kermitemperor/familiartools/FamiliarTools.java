package com.kermitemperor.familiar_tools;

import com.kermitemperor.familiar_tools.init.FTItems;
import com.kermitemperor.familiar_tools.util.FarmiliarToolsRegistrate;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(FamiliarTools.MOD_ID)
public class FamiliarTools {

    public static final String MOD_ID = "familiar_tools";
    public static final CreativeModeTab FAMILIAR_TAB = new ModItemGroup("familiar_tab");
    public static final FarmiliarToolsRegistrate registrate = FarmiliarToolsRegistrate.create(MOD_ID);
    private static final Logger LOGGER = LogUtils.getLogger();

    public FamiliarTools() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        
        FTItems.register();
        registrate.registerEventListeners(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    public static @NotNull FarmiliarToolsRegistrate registrate() {
        return registrate;
    }

}
