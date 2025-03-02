package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.ModBlocks;
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

    @EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ModClientBusEvents {

        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                DyestoneClient.init();
            });
        }

        @SubscribeEvent
        public static void onRegisterColorHandlers(final RegisterColorHandlersEvent.Block event) {
            // event.register((blockState, blockAndTintGetter, blockPos, i) -> Mth.color(1.0f, 0, 0), ModBlocks.DYED_RED_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(RED_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_RED_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_RED_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(GREEN_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_GREEN_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_GREEN_REDSTONE_WIRE);

            event.register((state, tintGetter, pos, i) -> getColorForPower(BLUE_COLORS, state.getValue(RedStoneWireBlock.POWER)), ModBlocks.DYED_BLUE_REDSTONE_WIRE);
            event.getBlockColors().addColoringState(RedStoneWireBlock.POWER, ModBlocks.DYED_RED_REDSTONE_WIRE);

            event.register((blockState, blockAndTintGetter, blockPos, i) -> 0xFF000000, ModBlocks.DYED_BLACK_REDSTONE_WIRE);
        }
    }

    public static int getColorForPower(Vec3[] colorVec3Array, int pPower) {
        Vec3 vec3 = colorVec3Array[pPower];
        return Mth.color((float)vec3.x(), (float)vec3.y(), (float)vec3.z());
    }

    public static final Vec3[] ORIGINAL_COLORS = Util.make(new Vec3[16], vec3Array -> {
        for(int power = 0; power <= 15; ++power) {

            float inRangePower = power / 15.0F;
            float red = inRangePower * 0.6F + (inRangePower != 0.0F ? 0.4F : 0.3F);
            float green = Mth.clamp(inRangePower * inRangePower * 0.7F - 0.5F, 0.0F, 1.0F);
            float blue = Mth.clamp(inRangePower * inRangePower * 0.6F - 0.7F, 0.0F, 1.0F);
            vec3Array[power] = new Vec3(red, green, blue);
        }
    });

    public static float minToOne(float value) {
        return Math.min(1.0f, value);
    }

    public static final Vec3[] RED_COLORS = Util.make(new Vec3[16], vec3Array -> {
        for (int power = 0; power <= 15; ++power) {
            float inRangePower = power / 15.0f;
            float red = inRangePower * 0.6F + (inRangePower != 0.0F ? 0.4F : 0.3F);
            float green = Mth.clamp(inRangePower * inRangePower * 0.7F - 0.5F, 0.0F, 1.0F);
            float blue = Mth.clamp(inRangePower * inRangePower * 0.6F - 0.7F, 0.0F, 1.0F);
            // vec3Array[power] = new Vec3(minToOne(red * 1.2f), minToOne(green * 1.2f), minToOne(blue * 1.2f));
            vec3Array[power] = new Vec3(minToOne(red * 2f), minToOne(green * 4f), minToOne(blue * 4f));
        }
    });

    public static final Vec3[] GREEN_COLORS = Util.make(new Vec3[16], vec3Array -> {
        for (int power = 0; power <= 15; ++power) {
            float inRangePower = power / 15.0f;
            float red = Mth.clamp(inRangePower * inRangePower * 0.7F - 0.5F, 0.0F, 1.0F);
            float green = inRangePower * 0.6F + (inRangePower != 0.0F ? 0.4F : 0.3F);
            float blue = Mth.clamp(inRangePower * inRangePower * 0.6F - 0.7F, 0.0F, 1.0F);
            vec3Array[power] = new Vec3(red, green, blue);
        }
    });

    public static final Vec3[] BLUE_COLORS = Util.make(new Vec3[16], vec3Array -> {
        for (int power = 0; power <= 15; ++power) {
            float inRangePower = power / 15.0f;
            float red = Mth.clamp(inRangePower * inRangePower * 0.7F - 0.5F, 0.0F, 1.0F);
            float green = Mth.clamp(inRangePower * inRangePower * 0.6F - 0.7F, 0.0F, 1.0F);
            float blue = inRangePower * 0.6F + (inRangePower != 0.0F ? 0.4F : 0.3F);
            vec3Array[power] = new Vec3(red, green, blue);
        }
    });
}
