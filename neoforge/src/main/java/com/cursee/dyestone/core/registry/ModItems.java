package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class ModItems {

    public static final Item WHITE_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.WHITE_DYESTONE_WIRE, new Item.Properties());
    public static final Item ORANGE_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.ORANGE_DYESTONE_WIRE, new Item.Properties());
    public static final Item MAGENTA_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.MAGENTA_DYESTONE_WIRE, new Item.Properties());
    public static final Item LIGHT_BLUE_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.LIGHT_BLUE_DYESTONE_WIRE, new Item.Properties());
    public static final Item YELLOW_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.YELLOW_DYESTONE_WIRE, new Item.Properties());
    public static final Item LIME_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.LIME_DYESTONE_WIRE, new Item.Properties());
    public static final Item PINK_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.PINK_DYESTONE_WIRE, new Item.Properties());
    public static final Item GRAY_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.GRAY_DYESTONE_WIRE, new Item.Properties());
    public static final Item LIGHT_GRAY_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.LIGHT_GRAY_DYESTONE_WIRE, new Item.Properties());
    public static final Item CYAN_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.CYAN_DYESTONE_WIRE, new Item.Properties());
    public static final Item PURPLE_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.PURPLE_DYESTONE_WIRE, new Item.Properties());
    public static final Item BLUE_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.BLUE_DYESTONE_WIRE, new Item.Properties());
    public static final Item BROWN_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.BROWN_DYESTONE_WIRE, new Item.Properties());
    public static final Item GREEN_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.GREEN_DYESTONE_WIRE, new Item.Properties());
    public static final Item RED_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.RED_DYESTONE_WIRE, new Item.Properties());
    public static final Item BLACK_DYESTONE_WIRE = new ItemNameBlockItem(ModBlocks.BLACK_DYESTONE_WIRE, new Item.Properties());

    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
        consumer.accept(WHITE_DYESTONE_WIRE, Dyestone.identifier("white_dyestone"));
        consumer.accept(ORANGE_DYESTONE_WIRE, Dyestone.identifier("orange_dyestone"));
        consumer.accept(MAGENTA_DYESTONE_WIRE, Dyestone.identifier("magenta_dyestone"));
        consumer.accept(LIGHT_BLUE_DYESTONE_WIRE, Dyestone.identifier("light_blue_dyestone"));
        consumer.accept(YELLOW_DYESTONE_WIRE, Dyestone.identifier("yellow_dyestone"));
        consumer.accept(LIME_DYESTONE_WIRE, Dyestone.identifier("lime_dyestone"));
        consumer.accept(PINK_DYESTONE_WIRE, Dyestone.identifier("pink_dyestone"));
        consumer.accept(GRAY_DYESTONE_WIRE, Dyestone.identifier("gray_dyestone"));
        consumer.accept(LIGHT_GRAY_DYESTONE_WIRE, Dyestone.identifier("light_gray_dyestone"));
        consumer.accept(CYAN_DYESTONE_WIRE, Dyestone.identifier("cyan_dyestone"));
        consumer.accept(PURPLE_DYESTONE_WIRE, Dyestone.identifier("purple_dyestone"));
        consumer.accept(BLUE_DYESTONE_WIRE, Dyestone.identifier("blue_dyestone"));
        consumer.accept(BROWN_DYESTONE_WIRE, Dyestone.identifier("brown_dyestone"));
        consumer.accept(GREEN_DYESTONE_WIRE, Dyestone.identifier("green_dyestone"));
        consumer.accept(RED_DYESTONE_WIRE, Dyestone.identifier("red_dyestone"));
        consumer.accept(BLACK_DYESTONE_WIRE, Dyestone.identifier("black_dyestone"));
    }
}
