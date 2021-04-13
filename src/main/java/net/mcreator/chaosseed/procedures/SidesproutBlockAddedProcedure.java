package net.mcreator.chaosseed.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.chaosseed.block.TBZPBlock;
import net.mcreator.chaosseed.block.TBZMBlock;
import net.mcreator.chaosseed.block.TBXPBlock;
import net.mcreator.chaosseed.block.TBXMBlock;
import net.mcreator.chaosseed.block.SidesproutBlock;
import net.mcreator.chaosseed.block.ChaoticeggBlock;
import net.mcreator.chaosseed.ChaosSeedModElements;
import net.mcreator.chaosseed.ChaosSeedMod;

import java.util.Map;

@ChaosSeedModElements.ModElement.Tag
public class SidesproutBlockAddedProcedure extends ChaosSeedModElements.ModElement {
	public SidesproutBlockAddedProcedure(ChaosSeedModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency x for procedure SidesproutBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency y for procedure SidesproutBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency z for procedure SidesproutBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ChaosSeedMod.LOGGER.warn("Failed to load dependency world for procedure SidesproutBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.2)) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), ChaoticeggBlock.block.getDefaultState(), 3);
		}
		if ((Math.random() < 0.15)) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), SidesproutBlock.block.getDefaultState(), 3);
		} else {
			if ((Math.random() < 0.15)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), SidesproutBlock.block.getDefaultState(), 3);
			} else {
				if ((Math.random() < 0.15)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), SidesproutBlock.block.getDefaultState(), 3);
				} else {
					if ((Math.random() < 0.15)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), SidesproutBlock.block.getDefaultState(), 3);
					} else {
						if ((Math.random() < 0.65)) {
							if ((Math.random() < 0.5)) {
								world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SidesproutBlock.block.getDefaultState(), 3);
							} else {
								world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SidesproutBlock.block.getDefaultState(), 3);
							}
						}
					}
				}
			}
		}
		if ((Math.random() < 0.1)) {
			if ((Math.random() < 0.1)) {
				if ((Math.random() < 0.2)) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 20), (int) z), TBXPBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 20), (int) z), TBXMBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 20), (int) (z + 1)), TBZPBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 20), (int) (z - 1)), TBZMBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
