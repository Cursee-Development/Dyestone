package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import com.cursee.dyestone.core.world.block.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;

public class ModBlocks {

    public static final Block WHITE_DYESTONE_WIRE = new WhiteDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block ORANGE_DYESTONE_WIRE = new OrangeDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block MAGENTA_DYESTONE_WIRE = new AbstractDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block LIGHT_BLUE_DYESTONE_WIRE = new LightBlueDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block YELLOW_DYESTONE_WIRE = new YellowDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block LIME_DYESTONE_WIRE = new LimeDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block PINK_DYESTONE_WIRE = new PinkDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block GRAY_DYESTONE_WIRE = new GrayDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block LIGHT_GRAY_DYESTONE_WIRE = new LightGrayDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block CYAN_DYESTONE_WIRE = new CyanDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block PURPLE_DYESTONE_WIRE = new PurpleDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block BLUE_DYESTONE_WIRE = new BlueDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block BROWN_DYESTONE_WIRE = new BrownDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block GREEN_DYESTONE_WIRE = new GreenDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block RED_DYESTONE_WIRE = new RedDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));
    public static final Block BLACK_DYESTONE_WIRE = new BlackDyestoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE));

    public static void register(BiConsumer<Block, ResourceLocation> consumer) {
        consumer.accept(WHITE_DYESTONE_WIRE, Dyestone.identifier("white_dyestone_wire"));
        consumer.accept(ORANGE_DYESTONE_WIRE, Dyestone.identifier("orange_dyestone_wire"));
        consumer.accept(MAGENTA_DYESTONE_WIRE, Dyestone.identifier("magenta_dyestone_wire"));
        consumer.accept(LIGHT_BLUE_DYESTONE_WIRE, Dyestone.identifier("light_blue_dyestone_wire"));
        consumer.accept(YELLOW_DYESTONE_WIRE, Dyestone.identifier("yellow_dyestone_wire"));
        consumer.accept(LIME_DYESTONE_WIRE, Dyestone.identifier("lime_dyestone_wire"));
        consumer.accept(PINK_DYESTONE_WIRE, Dyestone.identifier("pink_dyestone_wire"));
        consumer.accept(GRAY_DYESTONE_WIRE, Dyestone.identifier("gray_dyestone_wire"));
        consumer.accept(LIGHT_GRAY_DYESTONE_WIRE, Dyestone.identifier("light_gray_dyestone_wire"));
        consumer.accept(CYAN_DYESTONE_WIRE, Dyestone.identifier("cyan_dyestone_wire"));
        consumer.accept(PURPLE_DYESTONE_WIRE, Dyestone.identifier("purple_dyestone_wire"));
        consumer.accept(BLUE_DYESTONE_WIRE, Dyestone.identifier("blue_dyestone_wire"));
        consumer.accept(BROWN_DYESTONE_WIRE, Dyestone.identifier("brown_dyestone_wire"));
        consumer.accept(GREEN_DYESTONE_WIRE, Dyestone.identifier("green_dyestone_wire"));
        consumer.accept(RED_DYESTONE_WIRE, Dyestone.identifier("red_dyestone_wire"));
        consumer.accept(BLACK_DYESTONE_WIRE, Dyestone.identifier("black_dyestone_wire"));
    }
}
