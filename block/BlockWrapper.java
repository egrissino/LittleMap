package com.wegrizz.littlemap.block;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockWrapper {
	
	public BlockPos pos;
	public Block block;
	public String name;
	public int meta;

	public BlockWrapper(Block block_, BlockPos pos_) {
		block = block_;
		pos = pos_;
	}
	
	public BlockWrapper(Block block_, BlockPos pos_, String name_) {
		block = block_;
		pos = pos_;
		name = name_;
	}
	
	public BlockWrapper(Block block_, BlockPos pos_, int meta_) {
		block = block_;
		pos = pos_;
		meta = meta_;
	}
	
	public BlockWrapper getNearbyBlock(World world, int dx, int dy, int dz) {
		BlockPos nearPos = new BlockPos(pos.XPos + dx, pos.YPos + dy, pos.ZPos + dz);
		Block nearBlock = world.getBlock(pos.XPos + dx, pos.YPos + dy, pos.ZPos + dz);
		int meta = world.getBlockMetadata(pos.XPos + dx, pos.YPos + dy, pos.ZPos + dz);
		return new BlockWrapper(nearBlock, nearPos, meta);
	}
	

}
