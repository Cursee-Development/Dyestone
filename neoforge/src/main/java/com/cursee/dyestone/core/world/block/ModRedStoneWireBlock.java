package com.cursee.dyestone.core.world.block;

import com.cursee.dyestone.DyestoneClientNeoForge;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

public class ModRedStoneWireBlock extends RedStoneWireBlock {

    public ModRedStoneWireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void checkCornerChangeAt(Level level, BlockPos pos) {
        if (level.getBlockState(pos).getBlock() instanceof RedStoneWireBlock redStoneWireBlock) {
            level.updateNeighborsAt(pos, redStoneWireBlock);

            for(Direction direction : Direction.values()) {
                level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
            }
        }
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            if (state.canSurvive(level, pos)) {
                this.updatePowerStrength(level, pos, state);
            } else {
                dropResources(state, level, pos);
                level.removeBlock(pos, false);
            }
        }
    }

    @Override
    protected void updateIndirectNeighbourShapes(BlockState state, LevelAccessor level, BlockPos pos, int flags, int recursionLeft) {
        super.updateIndirectNeighbourShapes(state, level, pos, flags, recursionLeft);
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

        return true;

//        if (state.getBlock() instanceof RedStoneWireBlock || state.is(Blocks.REDSTONE_WIRE) || state.is(this)) {
//            return true;
//        }
//        else if (state.is(Blocks.REPEATER)) {
//            Direction facing = (Direction)state.getValue(RepeaterBlock.FACING);
//            return facing == direction || facing.getOpposite() == direction;
//        }
//        else if (state.is(Blocks.OBSERVER)) {
//            return direction == state.getValue(ObserverBlock.FACING);
//        }
//        else {
//            return state.isSignalSource() && direction != null;
//        }
    }

    public void spawnParticlesAlongLine(Level level, RandomSource random, BlockPos pos, Vec3 particleVec, Direction xDirection, Direction zDirection, float min, float max) {
        float f = max - min;
        if (!(random.nextFloat() >= 0.2F * f)) {
            float f1 = 0.4375F;
            float f2 = min + f * random.nextFloat();
            double d0 = (double)0.5F + (double)(0.4375F * (float)xDirection.getStepX()) + (double)(f2 * (float)zDirection.getStepX());
            double d1 = (double)0.5F + (double)(0.4375F * (float)xDirection.getStepY()) + (double)(f2 * (float)zDirection.getStepY());
            double d2 = (double)0.5F + (double)(0.4375F * (float)xDirection.getStepZ()) + (double)(f2 * (float)zDirection.getStepZ());
            level.addParticle(new DustParticleOptions(particleVec.toVector3f(), 1.0F), (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, (double)0.0F, (double)0.0F, (double)0.0F);
        }
    }

//    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
//        int i = (Integer)state.getValue(POWER);
//        if (i != 0) {
//            for(Direction direction : Direction.Plane.HORIZONTAL) {
//                RedstoneSide redstoneside = (RedstoneSide)state.getValue((Property)PROPERTY_BY_DIRECTION.get(direction));
//                switch (redstoneside) {
//                    case UP:
//                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.ORIGINAL_COLORS[i], direction, Direction.UP, -0.5F, 0.5F);
//                    case SIDE:
//                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.ORIGINAL_COLORS[i], Direction.DOWN, direction, 0.0F, 0.5F);
//                        break;
//                    case NONE:
//                    default:
//                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.ORIGINAL_COLORS[i], Direction.DOWN, direction, 0.0F, 0.3F);
//                }
//            }
//        }
//
//    }

    @Override
    public void updatePowerStrength(Level level, BlockPos pos, BlockState state) {
        int i = this.calculateTargetStrength(level, pos);
        if ((Integer)state.getValue(POWER) != i) {
            if (level.getBlockState(pos) == state) {
                level.setBlock(pos, (BlockState)state.setValue(POWER, i), Block.UPDATE_CLIENTS);
            }

            Set<BlockPos> set = Sets.newHashSet();
            set.add(pos);

            for(Direction direction : Direction.values()) {
                set.add(pos.relative(direction));
            }

            for(BlockPos blockpos : set) {
                if (level.getBlockState(blockpos).getBlock() instanceof RedStoneWireBlock redStoneWireBlock) level.updateNeighborsAt(blockpos, redStoneWireBlock);
                else level.updateNeighborsAt(blockpos, Blocks.REDSTONE_WIRE);
            }
        }
    }

    private static boolean isDot(BlockState state) {
        return !((RedstoneSide)state.getValue(NORTH)).isConnected() && !((RedstoneSide)state.getValue(SOUTH)).isConnected() && !((RedstoneSide)state.getValue(EAST)).isConnected() && !((RedstoneSide)state.getValue(WEST)).isConnected();
    }

//    private boolean canSurviveOn(BlockGetter level, BlockPos pos, BlockState state) {
//        return state.isFaceSturdy(level, pos, Direction.UP) || state.is(Blocks.HOPPER);
//    }

//    private RedstoneSide getConnectingSide(BlockGetter level, BlockPos pos, Direction direction, boolean nonNormalCubeAbove) {
//        BlockPos blockpos = pos.relative(direction);
//        BlockState blockstate = level.getBlockState(blockpos);
//        if (nonNormalCubeAbove) {
//            boolean flag = blockstate.getBlock() instanceof TrapDoorBlock || this.canSurviveOn(level, blockpos, blockstate);
//            if (flag && level.getBlockState(blockpos.above()).canRedstoneConnectTo(level, blockpos.above(), (Direction)null)) {
//                if (blockstate.isFaceSturdy(level, blockpos, direction.getOpposite())) {
//                    return RedstoneSide.UP;
//                }
//
//                return RedstoneSide.SIDE;
//            }
//        }
//
//        if (blockstate.canRedstoneConnectTo(level, blockpos, direction)) {
//            return RedstoneSide.SIDE;
//        } else if (blockstate.isRedstoneConductor(level, blockpos)) {
//            return RedstoneSide.NONE;
//        } else {
//            BlockPos blockPosBelow = blockpos.below();
//            return level.getBlockState(blockPosBelow).canRedstoneConnectTo(level, blockPosBelow, (Direction)null) ? RedstoneSide.SIDE : RedstoneSide.NONE;
//        }
//    }

//    @Override
//    public BlockState getMissingConnections(BlockGetter level, BlockState state, BlockPos pos) {
//        boolean flag = !level.getBlockState(pos.above()).isRedstoneConductor(level, pos);
//
//        for(Direction direction : Direction.Plane.HORIZONTAL) {
//            if (!((RedstoneSide)state.getValue((Property)PROPERTY_BY_DIRECTION.get(direction))).isConnected()) {
//                RedstoneSide redstoneside = this.getConnectingSide(level, pos, direction, flag);
//                state = (BlockState)state.setValue((Property)PROPERTY_BY_DIRECTION.get(direction), redstoneside);
//            }
//        }
//
//        return state;
//    }

    @Override
    public BlockState getConnectionState(BlockGetter level, BlockState state, BlockPos pos) {

        boolean flag = isDot(state);

        state = state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock ? redStoneWireBlock.getMissingConnections(level, redStoneWireBlock.defaultBlockState().setValue(POWER, (Integer)state.getValue(POWER)), pos) : this.getMissingConnections(level, (BlockState)this.defaultBlockState().setValue(POWER, (Integer)state.getValue(POWER)), pos);


        if (flag && isDot(state)) {
            return state;
        }
        else {

            boolean northConnected = state.getValue(NORTH).isConnected();
            boolean southConnected = state.getValue(SOUTH).isConnected();
            boolean eastConnected = state.getValue(EAST).isConnected();
            boolean westConnected = state.getValue(WEST).isConnected();

            boolean horizontal = !northConnected && !southConnected;
            boolean vertical = !eastConnected && !westConnected;

            if (!westConnected && horizontal) state = state.setValue(WEST, RedstoneSide.SIDE);
            if (!eastConnected && horizontal) state = state.setValue(EAST, RedstoneSide.SIDE);
            if (!northConnected && vertical) state = state.setValue(NORTH, RedstoneSide.SIDE);
            if (!southConnected && vertical) state = state.setValue(SOUTH, RedstoneSide.SIDE);

            return state;
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        if (!oldState.is(state.getBlock()) && (state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock) && !level.isClientSide) {
            instance.updatePowerStrength(level, pos, state);

            for(Direction direction : Direction.Plane.VERTICAL) {
                level.updateNeighborsAt(pos.relative(direction), redStoneWireBlock);
            }

            instance.updateNeighborsOfNeighboringWires(level, pos);
        }

    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        RedStoneWireBlock instance = (RedStoneWireBlock) (Object) this;

        if (!isMoving && (state.getBlock() instanceof RedStoneWireBlock redStoneWireBlock)) {
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
        }

    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
}
