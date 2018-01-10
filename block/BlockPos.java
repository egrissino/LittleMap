package com.wegrizz.littlemap.block;

public class BlockPos {
	
	public int XPos;
	public int YPos;
	public int ZPos;
	public boolean isSet = false;
	
	public BlockPos(int x, int y, int z, boolean set){
		XPos = x;
		YPos = y;
		ZPos = z;
		
		isSet = set;
	}
	
	public BlockPos(int x, int y, int z) {
		XPos = x;
		YPos = y;
		ZPos = z;
	}
	
	public static boolean isEqual(BlockPos pos1, BlockPos pos2) {
		if(pos1.XPos == pos2.XPos && pos1.YPos == pos2.YPos && pos1.ZPos == pos2.ZPos ) {
			return true;
		}
		
		return false;
	}
	
	public void set(int x, int y, int z, boolean set) {
		XPos = x;
		YPos = y;
		ZPos = z;
		
		isSet = set;
	}
	
	public void add(int dx, int dy, int dz) {
		XPos += dx;
		YPos += dy;
		ZPos += dz;
		
		isSet = true;
	}
	
	
	
}
