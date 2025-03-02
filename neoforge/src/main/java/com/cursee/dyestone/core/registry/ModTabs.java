package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;

public class ModTabs {

    public static final CreativeModeTab DYESTONE_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.DYED_RED_REDSTONE_WIRE))
            .title(Component.translatable("itemGroup.dyestone"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.DYED_WHITE_REDSTONE_WIRE);
                output.accept(ModItems.DYED_ORANGE_REDSTONE_WIRE);
                output.accept(ModItems.DYED_MAGENTA_REDSTONE_WIRE);
                output.accept(ModItems.DYED_LIGHT_BLUE_REDSTONE_WIRE);
                output.accept(ModItems.DYED_YELLOW_REDSTONE_WIRE);
                output.accept(ModItems.DYED_LIME_REDSTONE_WIRE);
                output.accept(ModItems.DYED_PINK_REDSTONE_WIRE);
                output.accept(ModItems.DYED_GRAY_REDSTONE_WIRE);
                output.accept(ModItems.DYED_LIGHT_GRAY_REDSTONE_WIRE);
                output.accept(ModItems.DYED_CYAN_REDSTONE_WIRE);
                output.accept(ModItems.DYED_PURPLE_REDSTONE_WIRE);
                output.accept(ModItems.DYED_BLUE_REDSTONE_WIRE);
                output.accept(ModItems.DYED_BROWN_REDSTONE_WIRE);
                output.accept(ModItems.DYED_GREEN_REDSTONE_WIRE);
                output.accept(ModItems.DYED_RED_REDSTONE_WIRE);
                output.accept(ModItems.DYED_BLACK_REDSTONE_WIRE);
            }).build();

    public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {
        consumer.accept(DYESTONE_TAB, Dyestone.identifier("dyestone_tab"));
    }
}
