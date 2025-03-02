package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;

public class ModTabs {

    public static final CreativeModeTab DYESTONE_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.RED_DYESTONE))
            .title(Component.translatable("itemGroup.dyestone"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.WHITE_DYESTONE);
                output.accept(ModItems.ORANGE_DYESTONE);
                output.accept(ModItems.MAGENTA_DYESTONE);
                output.accept(ModItems.LIGHT_BLUE_DYESTONE);
                output.accept(ModItems.YELLOW_DYESTONE);
                output.accept(ModItems.LIME_DYESTONE);
                output.accept(ModItems.PINK_DYESTONE);
                output.accept(ModItems.GRAY_DYESTONE);
                output.accept(ModItems.LIGHT_GRAY_DYESTONE);
                output.accept(ModItems.CYAN_DYESTONE);
                output.accept(ModItems.PURPLE_DYESTONE);
                output.accept(ModItems.BLUE_DYESTONE);
                output.accept(ModItems.BROWN_DYESTONE);
                output.accept(ModItems.GREEN_DYESTONE);
                output.accept(ModItems.RED_DYESTONE);
                output.accept(ModItems.BLACK_DYESTONE);
            }).build();

    public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {
        consumer.accept(DYESTONE_TAB, Dyestone.identifier("dyestone_tab"));
    }
}
