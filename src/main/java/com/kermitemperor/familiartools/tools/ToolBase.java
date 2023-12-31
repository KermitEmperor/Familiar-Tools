package com.kermitemperor.familiartools.tools;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kermitemperor.familiartools.FTTags;
import com.kermitemperor.familiartools.FamiliarTools;
import com.kermitemperor.familiartools.config.FTCommonConfig;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kermitemperor.familiartools.util.JsonListener.TOOLMATERIALS;
import static com.kermitemperor.familiartools.util.JsonUtils.*;
import static com.kermitemperor.familiartools.util.StringUtil.capitalize;

public class ToolBase extends Item {
    public static final String NBT_COLOR_HEAD = "HeadColor";
    public static final String NBT_COLOR_BASE = "BaseColor";
    public static final String NBT_TIER = "Tier";
    public static final String NBT_MAXDAMAGE = "MaxDamage";




    public ToolBase(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
        if (group == FamiliarTools.FAMILIAR_TAB) {

            if (!(FTCommonConfig.BLACKLIST_TOOLS.get()
                    .contains(Objects.requireNonNull(this.getRegistryName()).getPath())
                    ==
                    FTCommonConfig.INVERT.get())) return;

            for (JsonElement jsonElement : TOOLMATERIALS) {
                JsonObject json = jsonElement.getAsJsonObject();

                try {
                    ArrayList<String> exc = JsonArray2ArrayList(json.get("exceptions").getAsJsonArray());
                    if (exc.contains(Objects.requireNonNull(this.getRegistryName()).getPath())) {
                        continue;
                    }
                } catch (Exception ignored) {}

                String name = json.get("localizedName").getAsString();
                int tier = json.get("tier").getAsInt();
                int headcolor = getColorFromJsonKey(json, "headcolor");
                int basecolor = getColorFromJsonKey(json, "basecolor");
                int durability = json.get("durability").getAsInt();

                ItemStack newItemStack = createStack(name, tier, durability, new int[] {basecolor, headcolor});
                items.add(newItemStack);
            }
        }
    }



    public ItemStack createStack(String stackName, int tier, int durability, int[] colors) {

        ItemStack stack = new ItemStack(this);
        CompoundTag nbt = stack.getOrCreateTag();
        String pathName = Objects.requireNonNull(this.getRegistryName()).getPath();
        //SO MUCH PAIN


        JsonObject textComponent = new JsonObject();
        textComponent.addProperty("text", "%s %s".formatted(
                stackName,
                capitalize(Objects.requireNonNull(pathName)))
        );
        textComponent.addProperty("italic", false);
        String jsonDisplayName = textComponent.toString();

        CompoundTag namenbt = new CompoundTag();
        namenbt.putString("Name", jsonDisplayName);
        nbt.put("display", namenbt);

        nbt.putInt(NBT_TIER, tier);

        boolean isHeadless = stack.is(FTTags.Items.HEADLESS);
        if (!isHeadless) nbt.putInt(NBT_COLOR_HEAD, colors[1]);
        nbt.putInt(NBT_COLOR_BASE, !isHeadless ? colors[0] : colors[1]);


        nbt.putInt(NBT_MAXDAMAGE, durability);
        nbt.putInt("Damage", 0);
        return stack;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack returnStack = stack.copy();
        CompoundTag nbt = returnStack.getOrCreateTag();
        int stackDamage = nbt.getInt("Damage");
        if(stackDamage >= getMaxDamage(returnStack)) {
            return ItemStack.EMPTY;
        }
        nbt.putInt("Damage", stackDamage+1);
        return returnStack;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @SuppressWarnings("unused")
    public static int getToolTier(@NotNull ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_TIER);
    }

    public boolean canBeDepleted() {
        return true;
    }

    public int getMaxDamage(@NotNull ItemStack stack) {
        return Objects.requireNonNull(stack.getTag()).getInt(NBT_MAXDAMAGE);
    }

    @Override
    public int getBarColor(@NotNull ItemStack pStack) {
        float stackMaxDamage = this.getMaxDamage(pStack);
        float f = Math.max(0.0F, (stackMaxDamage - (float)pStack.getDamageValue()) / stackMaxDamage);
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return (pStack.getDamageValue() > 0);
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        return createStack("Base", 1, 8000, new int[] {0xffffff, 0xffffff});
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains(NBT_TIER)) {
            tooltip.add(Component.nullToEmpty("§6Tier: §a" + tag.getInt(NBT_TIER)));
        }
    }
}