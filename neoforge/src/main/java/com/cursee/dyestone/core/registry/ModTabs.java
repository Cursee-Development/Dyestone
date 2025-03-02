package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;

public class ModTabs {

    public static final CreativeModeTab DYESTONE_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.RED_DYESTONE_WIRE))
            .title(Component.translatable("itemGroup.dyestone"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.WHITE_DYESTONE_WIRE);
                output.accept(ModItems.ORANGE_DYESTONE_WIRE);
                output.accept(ModItems.MAGENTA_DYESTONE_WIRE);
                output.accept(ModItems.LIGHT_BLUE_DYESTONE_WIRE);
                output.accept(ModItems.YELLOW_DYESTONE_WIRE);
                output.accept(ModItems.LIME_DYESTONE_WIRE);
                output.accept(ModItems.PINK_DYESTONE_WIRE);
                output.accept(ModItems.GRAY_DYESTONE_WIRE);
                output.accept(ModItems.LIGHT_GRAY_DYESTONE_WIRE);
                output.accept(ModItems.CYAN_DYESTONE_WIRE);
                output.accept(ModItems.PURPLE_DYESTONE_WIRE);
                output.accept(ModItems.BLUE_DYESTONE_WIRE);
                output.accept(ModItems.BROWN_DYESTONE_WIRE);
                output.accept(ModItems.GREEN_DYESTONE_WIRE);
                output.accept(ModItems.RED_DYESTONE_WIRE);
                output.accept(ModItems.BLACK_DYESTONE_WIRE);
            }).build();

    public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {
        consumer.accept(DYESTONE_TAB, Dyestone.identifier("dyestone_tab"));
    }
}
