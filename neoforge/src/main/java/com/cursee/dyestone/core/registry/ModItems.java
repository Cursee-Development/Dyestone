package com.cursee.dyestone.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class ModItems {

    public static final Item DYED_WHITE_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_WHITE_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_ORANGE_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_ORANGE_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_MAGENTA_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_MAGENTA_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_LIGHT_BLUE_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_YELLOW_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_YELLOW_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_LIME_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_LIME_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_PINK_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_PINK_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_GRAY_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_GRAY_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_LIGHT_GRAY_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_CYAN_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_CYAN_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_PURPLE_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_PURPLE_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_BLUE_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_BLUE_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_BROWN_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_BROWN_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_GREEN_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_GREEN_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_RED_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_RED_REDSTONE_WIRE, new Item.Properties());
    public static final Item DYED_BLACK_REDSTONE_WIRE = new BlockItem(ModBlocks.DYED_BLACK_REDSTONE_WIRE, new Item.Properties());

    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
        consumer.accept(DYED_WHITE_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_WHITE_REDSTONE_WIRE));
        consumer.accept(DYED_ORANGE_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_ORANGE_REDSTONE_WIRE));
        consumer.accept(DYED_MAGENTA_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_MAGENTA_REDSTONE_WIRE));
        consumer.accept(DYED_LIGHT_BLUE_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE));
        consumer.accept(DYED_YELLOW_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_YELLOW_REDSTONE_WIRE));
        consumer.accept(DYED_LIME_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIME_REDSTONE_WIRE));
        consumer.accept(DYED_PINK_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_PINK_REDSTONE_WIRE));
        consumer.accept(DYED_GRAY_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_GRAY_REDSTONE_WIRE));
        consumer.accept(DYED_LIGHT_GRAY_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE));
        consumer.accept(DYED_CYAN_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_CYAN_REDSTONE_WIRE));
        consumer.accept(DYED_PURPLE_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_PURPLE_REDSTONE_WIRE));
        consumer.accept(DYED_BLUE_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BLUE_REDSTONE_WIRE));
        consumer.accept(DYED_BROWN_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BROWN_REDSTONE_WIRE));
        consumer.accept(DYED_GREEN_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_GREEN_REDSTONE_WIRE));
        consumer.accept(DYED_RED_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_RED_REDSTONE_WIRE));
        consumer.accept(DYED_BLACK_REDSTONE_WIRE, BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BLACK_REDSTONE_WIRE));
    }
}
