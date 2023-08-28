package com.kermitemperor.familiartools.tools;

import com.kermitemperor.familiartools.FamiliarTools;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FamiliarTools.MOD_ID);

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new ToolBase(new Item.Properties().tab(FamiliarTools.FAMILIAR_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
