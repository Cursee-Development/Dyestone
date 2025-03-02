package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.ModBlocks;
import com.cursee.dyestone.core.registry.ModItems;
import net.minecraft.Util;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class DyestoneClientNeoForge {

    public static double minToOne(double value) {
        return Math.min(1.0D, value);
    }

    public static Vec3[] createPoweredColorArray(Vec3 rgbVector) {
        return Util.make(new Vec3[16], vec3Array -> {
            for (int power = 0; power <= 15; ++power) {
                float percentage = power / 15.0f;
                float offModifier = percentage != 0.0f ? 0.5f : 0.3f;

                vec3Array[power] = new Vec3(
                        minToOne(rgbVector.x * ((percentage * 0.6f) + offModifier)),
                        minToOne(rgbVector.y * ((percentage * 0.6f) + offModifier)),
                        minToOne(rgbVector.z * ((percentage * 0.6f) + offModifier))
                );
            }
        });
    }

    public static final Vec3 WHITE = new Vec3(1.0f, 1.0f, 1.0f);
    public static final Vec3 ORANGE = new Vec3(1.0f, 0.67f, 0.0f);
    public static final Vec3 MAGENTA = new Vec3(1.0f, 0.34f, 1.0f);
    public static final Vec3 LIGHT_BLUE = new Vec3(0.34f, 1.0f, 1.0f);
    public static final Vec3 YELLOW = new Vec3(1.0f, 1.0f, 0.34f);
    public static final Vec3 LIME = new Vec3(0.34f, 1.0f, 0.34f);
    public static final Vec3 PINK = new Vec3(1.0f, 0.34f, 0.34f);
    public static final Vec3 GRAY = new Vec3(0.34f, 0.34f, 0.34f);
    public static final Vec3 LIGHT_GRAY = new Vec3(0.67f, 0.67f, 0.67f);
    public static final Vec3 CYAN = new Vec3(0.34f, 1.0f, 1.0f);
    public static final Vec3 PURPLE = new Vec3(0.67f, 0.0f, 0.67f);
    public static final Vec3 BLUE = new Vec3(0.0f, 0.0f, 0.67f);
    public static final Vec3 BROWN = new Vec3(131.0f/255.0f, 84.0f/255.0f, 50.0f/255.0f);
    public static final Vec3 GREEN = new Vec3(0.0f, 0.67f, 0.0f);
    public static final Vec3 RED = new Vec3(0.67f, 0.0f, 0.0f);
    public static final Vec3 BLACK = new Vec3(0.1f, 0.1f, 0.1f);

    public static final Vec3[] WHITE_COLORS = createPoweredColorArray(WHITE);
    public static final Vec3[] ORANGE_COLORS = createPoweredColorArray(ORANGE);
    public static final Vec3[] MAGENTA_COLORS = createPoweredColorArray(MAGENTA);
    public static final Vec3[] LIGHT_BLUE_COLORS = createPoweredColorArray(LIGHT_BLUE);
    public static final Vec3[] YELLOW_COLORS = createPoweredColorArray(YELLOW);
    public static final Vec3[] LIME_COLORS = createPoweredColorArray(LIME);
    public static final Vec3[] PINK_COLORS = createPoweredColorArray(PINK);
    public static final Vec3[] GRAY_COLORS = createPoweredColorArray(GRAY);
    public static final Vec3[] LIGHT_GRAY_COLORS = createPoweredColorArray(LIGHT_GRAY);
    public static final Vec3[] CYAN_COLORS = createPoweredColorArray(CYAN);
    public static final Vec3[] PURPLE_COLORS = createPoweredColorArray(PURPLE);
    public static final Vec3[] BLUE_COLORS = createPoweredColorArray(BLUE);
    public static final Vec3[] BROWN_COLORS = createPoweredColorArray(BROWN);
    public static final Vec3[] GREEN_COLORS = createPoweredColorArray(GREEN);
    public static final Vec3[] RED_COLORS = createPoweredColorArray(RED);
    public static final Vec3[] BLACK_COLORS = createPoweredColorArray(BLACK);

    public static int getColorForPower(Vec3[] colorVec3Array, int pPower) {
        Vec3 vec3 = colorVec3Array[pPower];
        return Mth.color((float)vec3.x(), (float)vec3.y(), (float)vec3.z());
    }

    @EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ModClientBusEvents {

        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                DyestoneClient.init();
            });
        }

        @SubscribeEvent
        public static void onRegisterBlockColorHandlers(final RegisterColorHandlersEvent.Block event) {

            event.register((state, tintGetter, pos, i) -> getColorForPower(WHITE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_WHITE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_WHITE_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(ORANGE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_ORANGE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_ORANGE_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(MAGENTA_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_MAGENTA_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_MAGENTA_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(LIGHT_BLUE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_LIGHT_BLUE_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(YELLOW_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_YELLOW_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_YELLOW_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(LIME_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_LIME_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_LIME_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(PINK_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_PINK_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_PINK_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(GRAY_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_GRAY_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_GRAY_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(LIGHT_GRAY_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_LIGHT_GRAY_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(CYAN_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_CYAN_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_CYAN_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(PURPLE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_PURPLE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_PURPLE_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(BLUE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_BLUE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_BLUE_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(BROWN_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_BROWN_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_BROWN_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(GREEN_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_GREEN_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_GREEN_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(RED_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_RED_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_RED_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(BLACK_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_BLACK_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_BLACK_REDSTONE_WIRE);
        }

        @SubscribeEvent
        public static void onRegisterItemColorHandlers(final RegisterColorHandlersEvent.Item event) {
            event.register((itemStack, i) -> 0xFFFFFF, ModItems.DYED_WHITE_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xFFAA00, ModItems.DYED_ORANGE_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xFF55FF, ModItems.DYED_MAGENTA_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x5555FF, ModItems.DYED_LIGHT_BLUE_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xFFFF55, ModItems.DYED_YELLOW_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x55FF55, ModItems.DYED_LIME_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xF38BAA, ModItems.DYED_PINK_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x555555, ModItems.DYED_GRAY_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xAAAAAA, ModItems.DYED_LIGHT_GRAY_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x55FFFF, ModItems.DYED_CYAN_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xAA00AA, ModItems.DYED_PURPLE_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x0000AA, ModItems.DYED_BLUE_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x835432, ModItems.DYED_BROWN_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x00AA00, ModItems.DYED_GREEN_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0xFF5555, ModItems.DYED_RED_REDSTONE_WIRE);
            event.register((itemStack, i) -> 0x000000, ModItems.DYED_BLACK_REDSTONE_WIRE);
        }
    }
}
