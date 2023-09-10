package com.kermitemperor.familiartools.init;

import com.kermitemperor.familiartools.FamiliarTools;
import com.kermitemperor.familiartools.tools.ToolBase;
import com.kermitemperor.familiartools.tools.util.ToolColour;
import com.kermitemperor.familiartools.util.FarmiliarToolsRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

@SuppressWarnings("unused")
public class FTItems {
    private static final FarmiliarToolsRegistrate REGISTRATE = FamiliarTools.registrate()
            .creativeModeTab(() -> FamiliarTools.FAMILIAR_TAB);
    public static final ItemEntry<ToolBase> hammer = REGISTRATE.item("hammer", ToolBase::new)
            .color(() -> ToolColour::new)
            .register();

    public static final ItemEntry<ToolBase> wrench = REGISTRATE.item("wrench", ToolBase::new)
            .color(() -> ToolColour::new)
            .register();

    public static final ItemEntry<ToolBase> file= REGISTRATE.item("file", ToolBase::new)
            .color(() -> ToolColour::new)
            .register();
    public static void register() {}
}
