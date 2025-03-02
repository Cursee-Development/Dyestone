package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.Dyestone;
import com.cursee.dyestone.core.world.block.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.BiConsumer;

public class ModBlocks {

    public static final Block DYED_WHITE_REDSTONE_WIRE = new ModWhiteRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY).isRedstoneConductor((blockState, blockGetter, blockPos) -> true));
    public static final Block DYED_ORANGE_REDSTONE_WIRE = new ModOrangeRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_MAGENTA_REDSTONE_WIRE = new ModRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_LIGHT_BLUE_REDSTONE_WIRE = new ModLightBlueRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_YELLOW_REDSTONE_WIRE = new ModYellowRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_LIME_REDSTONE_WIRE = new ModLimeRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_PINK_REDSTONE_WIRE = new ModPinkRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_GRAY_REDSTONE_WIRE = new ModGrayRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_LIGHT_GRAY_REDSTONE_WIRE = new ModLightGrayRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_CYAN_REDSTONE_WIRE = new ModCyanRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_PURPLE_REDSTONE_WIRE = new ModPurpleRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_BLUE_REDSTONE_WIRE = new ModBlueRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_BROWN_REDSTONE_WIRE = new ModBrownRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_GREEN_REDSTONE_WIRE = new ModGreenRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_RED_REDSTONE_WIRE = new ModRedRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    public static final Block DYED_BLACK_REDSTONE_WIRE = new ModBlackRedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY));

    public static void register(BiConsumer<Block, ResourceLocation> consumer) {
        consumer.accept(DYED_WHITE_REDSTONE_WIRE, Dyestone.identifier("dyed_white_redstone_wire"));
        consumer.accept(DYED_ORANGE_REDSTONE_WIRE, Dyestone.identifier("dyed_orange_redstone_wire"));
        consumer.accept(DYED_MAGENTA_REDSTONE_WIRE, Dyestone.identifier("dyed_magenta_redstone_wire"));
        consumer.accept(DYED_LIGHT_BLUE_REDSTONE_WIRE, Dyestone.identifier("dyed_light_blue_redstone_wire"));
        consumer.accept(DYED_YELLOW_REDSTONE_WIRE, Dyestone.identifier("dyed_yellow_redstone_wire"));
        consumer.accept(DYED_LIME_REDSTONE_WIRE, Dyestone.identifier("dyed_lime_redstone_wire"));
        consumer.accept(DYED_PINK_REDSTONE_WIRE, Dyestone.identifier("dyed_pink_redstone_wire"));
        consumer.accept(DYED_GRAY_REDSTONE_WIRE, Dyestone.identifier("dyed_gray_redstone_wire"));
        consumer.accept(DYED_LIGHT_GRAY_REDSTONE_WIRE, Dyestone.identifier("dyed_light_gray_redstone_wire"));
        consumer.accept(DYED_CYAN_REDSTONE_WIRE, Dyestone.identifier("dyed_cyan_redstone_wire"));
        consumer.accept(DYED_PURPLE_REDSTONE_WIRE, Dyestone.identifier("dyed_purple_redstone_wire"));
        consumer.accept(DYED_BLUE_REDSTONE_WIRE, Dyestone.identifier("dyed_blue_redstone_wire"));
        consumer.accept(DYED_BROWN_REDSTONE_WIRE, Dyestone.identifier("dyed_brown_redstone_wire"));
        consumer.accept(DYED_GREEN_REDSTONE_WIRE, Dyestone.identifier("dyed_green_redstone_wire"));
        consumer.accept(DYED_RED_REDSTONE_WIRE, Dyestone.identifier("dyed_red_redstone_wire"));
        consumer.accept(DYED_BLACK_REDSTONE_WIRE, Dyestone.identifier("dyed_black_redstone_wire"));
    }
}
