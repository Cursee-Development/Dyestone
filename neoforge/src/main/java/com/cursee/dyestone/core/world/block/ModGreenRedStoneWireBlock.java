package com.cursee.dyestone.core.world.block;

import com.cursee.dyestone.DyestoneClientNeoForge;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class ModGreenRedStoneWireBlock extends ModRedStoneWireBlock {

    public ModGreenRedStoneWireBlock(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        int i = (Integer)state.getValue(POWER);
        if (i != 0) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                RedstoneSide redstoneside = (RedstoneSide)state.getValue((Property)PROPERTY_BY_DIRECTION.get(direction));
                switch (redstoneside) {
                    case UP:
                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.GREEN_COLORS[i], direction, Direction.UP, -0.5F, 0.5F);
                    case SIDE:
                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.GREEN_COLORS[i], Direction.DOWN, direction, 0.0F, 0.5F);
                        break;
                    case NONE:
                    default:
                        this.spawnParticlesAlongLine(level, random, pos, DyestoneClientNeoForge.GREEN_COLORS[i], Direction.DOWN, direction, 0.0F, 0.3F);
                }
            }
        }

    }
}
