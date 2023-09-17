package com.kermitemperor.familiartools.util;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

public class FamiliarToolsRegistrate extends AbstractRegistrate<FamiliarToolsRegistrate> {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    protected FamiliarToolsRegistrate(String modid) {
        super(modid);
    }
    public static FamiliarToolsRegistrate create(String modid) {
        return new FamiliarToolsRegistrate(modid);
    }
    
    @Override
    public @NotNull FamiliarToolsRegistrate registerEventListeners(@NotNull IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
