package com.cursee.dyestone.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class ModItems {

    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
        consumer.accept(new BlockItem(ModBlocks.DYED_WHITE_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_WHITE_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_ORANGE_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_ORANGE_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_MAGENTA_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_MAGENTA_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_YELLOW_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_YELLOW_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_LIME_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIME_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_PINK_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_PINK_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_GRAY_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_GRAY_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_CYAN_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_CYAN_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_PURPLE_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_PURPLE_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_BLUE_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BLUE_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_BROWN_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BROWN_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_GREEN_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_GREEN_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_RED_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_RED_REDSTONE_WIRE));
        consumer.accept(new BlockItem(ModBlocks.DYED_BLACK_REDSTONE_WIRE, new Item.Properties()), BuiltInRegistries.BLOCK.getKey(ModBlocks.DYED_BLACK_REDSTONE_WIRE));
    }
}
