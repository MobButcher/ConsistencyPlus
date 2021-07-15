package io.github.consistencyplus.consistency_plus.mixin;

import io.github.consistencyplus.consistency_plus.core.blocks.HasUngrownVariant;
import io.github.consistencyplus.consistency_plus.core.blocks.IsSpreadableMyceliumBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MyceliumBlock;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Random;

@Mixin(MyceliumBlock.class)
public abstract class MyceliumBlockMixin extends SpreadableBlock implements HasUngrownVariant, IsSpreadableMyceliumBlock {

    protected MyceliumBlockMixin(Settings settings) {
        super(settings);
    }

    @Unique
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        grow(state, world, pos, random);
    }

    @Unique
    @Override
    public BlockState getUngrownVariant(World world, BlockPos pos) {
        return Blocks.DIRT.getDefaultState();
    }
}
