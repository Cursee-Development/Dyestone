package com.cursee.dyestone.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedStoneWireBlock.class)
public class NeoForgeRedStoneWireBlockMixin {

    @Inject(method = "shouldConnectTo(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private static void injected(BlockState state, Direction p_direction, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state.getBlock() instanceof RedStoneWireBlock);
    }

//    @Inject(method = "getWireSignal", at = @At(value = "RETURN"), cancellable = true)
//    private void injected2(BlockState state, CallbackInfoReturnable<Integer> cir) {
//        cir.setReturnValue(state.getBlock() instanceof RedStoneWireBlock ? state.getValue(RedStoneWireBlock.POWER) : 0);
//    }
}
