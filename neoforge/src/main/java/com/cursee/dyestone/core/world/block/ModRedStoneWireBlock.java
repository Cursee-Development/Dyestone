package com.cursee.dyestone.core.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ModRedStoneWireBlock extends RedStoneWireBlock {

    public ModRedStoneWireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int calculateTargetStrength(Level level, BlockPos pos) {

        this.shouldSignal = false;
        int bestSignal = level.getBestNeighborSignal(pos);
        this.shouldSignal = true;
        int addedSignal = 0;

        if (bestSignal < 15) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                BlockPos blockpos = pos.relative(direction);
                BlockState blockstate = level.getBlockState(blockpos);
                addedSignal = Math.max(addedSignal, this.getWireSignal(blockstate));
                BlockPos blockpos1 = pos.above();
                if (blockstate.isRedstoneConductor(level, blockpos) && !level.getBlockState(blockpos1).isRedstoneConductor(level, blockpos1)) {
                    addedSignal = Math.max(addedSignal, this.getWireSignal(level.getBlockState(blockpos.above())));
                }
                else if (!blockstate.isRedstoneConductor(level, blockpos)) {
                    addedSignal = Math.max(addedSignal, this.getWireSignal(level.getBlockState(blockpos.below())));
                }
            }
        }

        return Math.max(
                Math.max(0, bestSignal - 1),
                Math.max(0, addedSignal - 1));
    }

    @Override
    public int getWireSignal(BlockState state) {
        return state.getBlock() instanceof RedStoneWireBlock ? state.getValue(POWER) : 0;
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            return true;
        } else if (state.is(Blocks.REPEATER)) {
            Direction facing = (Direction)state.getValue(RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.is(Blocks.OBSERVER)) {
            return direction == state.getValue(ObserverBlock.FACING);
        } else {
            return state.isSignalSource() && direction != null;
        }
    }
}
