package com.kermitemperor.familiar_tools.init;

import com.kermitemperor.familiar_tools.FamiliarTools;
import com.kermitemperor.familiar_tools.tools.ToolBase;
import com.kermitemperor.familiar_tools.tools.util.ToolColour;
import com.kermitemperor.familiar_tools.util.FarmiliarToolsRegistrate;
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
