package com.kermitemperor.familiar_tools.util;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;

public class FarmiliarToolsRegistrate extends AbstractRegistrate<FarmiliarToolsRegistrate> {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    protected FarmiliarToolsRegistrate(String modid) {
        super(modid);
    }
    public static FarmiliarToolsRegistrate create(String modid) {
        return new FarmiliarToolsRegistrate(modid);
    }
    
    @Override
    public FarmiliarToolsRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
