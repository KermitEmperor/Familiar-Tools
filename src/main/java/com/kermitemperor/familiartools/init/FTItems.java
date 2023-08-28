package com.kermitemperor.familiartools.init;

import com.kermitemperor.familiartools.FamiliarTools;
import com.kermitemperor.familiartools.tools.ToolBase;
import com.kermitemperor.familiartools.tools.util.ToolColour;
import com.kermitemperor.familiartools.util.FarmiliarToolsRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

public class FTItems {
    private static final FarmiliarToolsRegistrate REGISTRATE = FamiliarTools.registrate()
            .creativeModeTab(() -> FamiliarTools.FAMILIAR_TAB);
    public static final ItemEntry<ToolBase> hammer = REGISTRATE.item("hammer", ToolBase::new)
            .properties(properties -> properties.durability(100))
            .color(() -> ToolColour::new)
            .register();
    public static void register() {}
}
