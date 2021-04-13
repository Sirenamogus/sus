package net.mcreator.chaosseed.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.chaosseed.block.FTXPBlock;
import net.mcreator.chaosseed.block.CorruptedGrassBlock;
import net.mcreator.chaosseed.ChaosSeedModElements;
import net.mcreator.chaosseed.ChaosSeedMod;

import java.util.Map;

@ChaosSeedModElements.ModElement.Tag
public class FTXPBlockAddedProcedure extends ChaosSeedModElements.ModElement {
	public FTXPBlockAddedProcedure(ChaosSeedModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency x for procedure FTXPBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency y for procedure FTXPBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency z for procedure FTXPBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency world for procedure FTXPBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), CorruptedGrassBlock.block.getDefaultState(), 3);
		} else {
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).isSolid())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FTXPBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), FTXPBlock.block.getDefaultState(), 3);
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).isSolid())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FTXPBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), FTXPBlock.block.getDefaultState(), 3);
			}
		}
	}
}
