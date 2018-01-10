package com.wegrizz.littlemap.block;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TowerBlock extends Block {
	
	private String templateName;

	public TowerBlock(String unlocalizedName, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName("littlemap:towerblock");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("pickaxe", 0);
		this.setResistance(2000.0F);
		this.setHardness(1.5F);
		this.setLightLevel(1.0F);
		this.isBlockContainer = true;
		this.templateName = "src/main/resources/assets/littlemap/templates/tower.txt";
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		
		int template[][][] = readTemplate(templateName);
		
		for(int i = 0; i < template.length; i++) {
			for( int j = 0; j < template[0].length; j++) {
				for( int k = 0; k < template[0][0].length; k++) {
					world.setBlock(x + k, y + i, z + j, Block.getBlockById(template[i][j][k]));
				}
			}
		}
		
		
		return true;
	}
	
	private static int[][][] readTemplate(String filename) {
		
		int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        
        // This will reference one line at a time
        String line = null;
        String tokens[] = null;

        try {
        		System.out.println(System.getProperty("user.dir"));
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            String dim_string[] = line.split(";");
            int dimensions[] = new int[3];
            
            for( i = 0; i < 3; i++) {
            		dimensions[i] = Integer.parseInt(dim_string[i]);
            }
            
            
            
            int template[][][] = new int[dimensions[2]][dimensions[1]][dimensions[0]];
            
            i = 0;
            while((line = bufferedReader.readLine()) != null) {
            		
            		// For adding comments to the file
            		if( line.startsWith("*") ) {
            			continue;
            		}
            		
            		tokens = line.split(", ");
            		
                for( k = 0; k < dimensions[0]; k++ ) {
                		template[i][j][k] = Integer.parseInt(tokens[k]);
                }
                
                if( j < dimensions[1] - 1) {
                		j++;
                } else {
                		j = 0;
                		if( i < dimensions[2] - 1) {
                			i ++;
                		} else {
                			break;
                		}
                }
            }   

            // Always close files.
            bufferedReader.close();
            
            return template;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filename + "'");
            return new int[0][0][0];
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
            return new int[0][0][0];
        }
    }
}
