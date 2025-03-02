package com.cursee.dyestone.mixin;

import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(RedStoneWireBlock.class)
public class NeoForgeRedStoneWireBlockMixin {

    @Inject(method = "updateIndirectNeighbourShapes", at = @At("TAIL"))
    private void dyestone$updateIndirectNeighbourShapesInject(BlockState state, LevelAccessor level, BlockPos pos, int flags, int recursionLeft, CallbackInfo ci) {

        BlockPos.MutableBlockPos mutablePosition = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            RedstoneSide redstoneside = (RedstoneSide)state.getValue((Property)RedStoneWireBlock.PROPERTY_BY_DIRECTION.get(direction));
            if (redstoneside != RedstoneSide.NONE && !(level.getBlockState(mutablePosition.setWithOffset(pos, direction)).getBlock() instanceof RedStoneWireBlock)) {
                mutablePosition.move(Direction.DOWN);
                BlockState downCheckedState = level.getBlockState(mutablePosition);
                if (downCheckedState.getBlock() instanceof RedStoneWireBlock) {
                    BlockPos blockpos = mutablePosition.relative(direction.getOpposite());
                    level.neighborShapeChanged(direction.getOpposite(), level.getBlockState(blockpos), mutablePosition, blockpos, flags, recursionLeft);
                }

                mutablePosition.setWithOffset(pos, direction).move(Direction.UP);
                BlockState upCheckedState = level.getBlockState(mutablePosition);
                if (upCheckedState.getBlock() instanceof RedStoneWireBlock) {
                    BlockPos relativeState = mutablePosition.relative(direction.getOpposite());
                    level.neighborShapeChanged(direction.getOpposite(), level.getBlockState(relativeState), mutablePosition, relativeState, flags, recursionLeft);
                }
            }
        }
    }

    @Inject(method = "shouldConnectTo(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z", at = @At(value = "HEAD"), cancellable = true)
    private static void dyestone$shouldConnectToInject(BlockState state, Direction p_direction, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            cir.setReturnValue(true);
        }
        else if (state.is(Blocks.REPEATER)) {
            Direction direction = (Direction)state.getValue(RepeaterBlock.FACING);
            cir.setReturnValue(direction == p_direction || direction.getOpposite() == p_direction);
        }
        else {
            cir.setReturnValue(state.is(Blocks.OBSERVER) ? p_direction == state.getValue(ObserverBlock.FACING) : state.isSignalSource() && p_direction != null);
        }
    }

//    @Inject(method = "getWireSignal", at = @At(value = "RETURN"), cancellable = true)
//    private void injected2(BlockState state, CallbackInfoReturnable<Integer> cir) {
//        cir.setReturnValue(state.getBlock() instanceof RedStoneWireBlock ? state.getValue(RedStoneWireBlock.POWER) : 0);
//    }

//    @Inject(method = "updatePowerStrength", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;updateNeighborsAt(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;)V"))
//    private void injected3(Level level, BlockPos pos, BlockState state, CallbackInfo ci) {
//        Block toUpdate = level.getBlockState(pos).getBlock() instanceof RedStoneWireBlock redStoneWireBlock ? redStoneWireBlock : Blocks.REDSTONE_WIRE;
//        level.updateNeighborsAt(pos, toUpdate);
//    }

    @Inject(method = "updatePowerStrength", at = @At(value = "RETURN"))
    private void dyestone$updatePowerStrengthInject(Level level, BlockPos pos, BlockState state, CallbackInfo ci) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        int i = instance.calculateTargetStrength(level, pos);
        if ((Integer)state.getValue(RedStoneWireBlock.POWER) != i) {
            if (level.getBlockState(pos) == state) {
                level.setBlock(pos, (BlockState)state.setValue(RedStoneWireBlock.POWER, i), 2);
            }

            Set<BlockPos> set = Sets.newHashSet();
            set.add(pos);

            for(Direction direction : Direction.values()) {
                set.add(pos.relative(direction));
            }

            for(BlockPos blockpos : set) {
                if (level.getBlockState(blockpos).getBlock() instanceof RedStoneWireBlock redStoneWireBlock) level.updateNeighborsAt(blockpos, redStoneWireBlock);
                // else level.updateNeighborsAt(blockpos, instance);
            }
        }
    }

    @Inject(method = "onPlace", at = @At(value = "RETURN"))
    private void dyestone$onPlaceInject(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        if (!oldState.is(state.getBlock()) && !level.isClientSide) {
            instance.updatePowerStrength(level, pos, state);

            for(Direction direction : Direction.Plane.VERTICAL) {
                level.updateNeighborsAt(pos.relative(direction), instance);
                level.updateNeighborsAt(pos.relative(direction), Blocks.REDSTONE_WIRE);
                if (state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock) level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
            }

            instance.updateNeighborsOfNeighboringWires(level, pos);
        }
    }

    @Inject(method = "checkCornerChangeAt", at = @At(value = "RETURN"))
    private void dyestone$checkCornerChangeAtInject(Level level, BlockPos pos, CallbackInfo ci) {
        if (level.getBlockState(pos).getBlock() instanceof RedStoneWireBlock redStoneWireBlock) {
            level.updateNeighborsAt(pos, redStoneWireBlock);

            for(Direction direction : Direction.values()) {
                level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
            }
        }
    }

    @Inject(method = "onPlace", at = @At("HEAD"))
    private void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        if ((state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock) && !level.isClientSide) {
            instance.updatePowerStrength(level, pos, state);

            for(Direction direction : Direction.Plane.VERTICAL) {
                level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
            }

            instance.updateNeighborsOfNeighboringWires(level, pos);
        }

    }

    @Inject(method = "onRemove", at = @At("HEAD"), cancellable = true)
    private void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving, CallbackInfo ci) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        if (!isMoving && !state.is(newState.getBlock()) && (state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock)) {
            if (state.hasBlockEntity() && (!state.is(newState.getBlock()) || !newState.hasBlockEntity())) {
                level.removeBlockEntity(pos);
            }
            if (!level.isClientSide) {
                for(Direction direction : Direction.values()) {
                    level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
                }

                instance.updatePowerStrength(level, pos, state);
                instance.updateNeighborsOfNeighboringWires(level, pos);
            }
            ci.cancel();
        }
    }
}
