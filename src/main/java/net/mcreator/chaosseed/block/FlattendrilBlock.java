
package net.mcreator.chaosseed.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.chaosseed.ChaosSeedModElements;

import java.util.List;
import java.util.Collections;

@ChaosSeedModElements.ModElement.Tag
public class FlattendrilBlock extends ChaosSeedModElements.ModElement {
	@ObjectHolder("chaos_seed:flattendril")
	public static final Block block = null;
	public FlattendrilBlock(ChaosSeedModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10f, 10f).setLightLevel(s -> 4).harvestLevel(22)
					.harvestTool(ToolType.PICKAXE).setRequiresTool().tickRandomly().setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("flattendril");
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}
	}
}
