package com.cursee.dyestone.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DiodeBlock.class)
public class NeoForgeDiodeBlockMixin {

    @Inject(method = "getInputSignal", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private void injected(Level level, BlockPos pos, BlockState state, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(state.getBlock() instanceof RedStoneWireBlock ? state.getValue(RedStoneWireBlock.POWER) : 0);
    }
}
