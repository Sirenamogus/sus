package net.mcreator.chaosseed.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.chaosseed.block.TBZPBlock;
import net.mcreator.chaosseed.block.TBZMBlock;
import net.mcreator.chaosseed.block.TBXPBlock;
import net.mcreator.chaosseed.block.SproutblockBlock;
import net.mcreator.chaosseed.block.CorruptedGrassBlock;
import net.mcreator.chaosseed.ChaosSeedModElements;
import net.mcreator.chaosseed.ChaosSeedMod;

import java.util.Map;

@ChaosSeedModElements.ModElement.Tag
public class TBXPBlockAddedProcedure extends ChaosSeedModElements.ModElement {
	public TBXPBlockAddedProcedure(ChaosSeedModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency x for procedure TBXPBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency y for procedure TBXPBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency z for procedure TBXPBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency world for procedure TBXPBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), CorruptedGrassBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), CorruptedGrassBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CorruptedGrassBlock.block.getDefaultState(), 3);
		}
		if ((Math.random() < 0.95)) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (((y - Math.random()) + Math.random()) + Math.random()), (int) z),
					TBXPBlock.block.getDefaultState(), 3);
		} else {
			if ((Math.random() < 0.3)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TBZPBlock.block.getDefaultState(), 3);
			} else {
				if ((Math.random() < 0.3)) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TBZMBlock.block.getDefaultState(), 3);
				} else {
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.DIRT.getDefaultState()
							.getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SproutblockBlock.block.getDefaultState(), 3);
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState()
							.getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SproutblockBlock.block.getDefaultState(), 3);
					}
				}
			}
		}
	}
}
