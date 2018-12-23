package enders.additions.world.worldgen.ores;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class Oregen implements IWorldGenerator {
 
 @Override
 public void generate(Random random, int chunkX, int chunkZ, World world,
  IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
  /* runs 'generateNether' or 'generateSurface' depending on which dimension you're loading */
  switch (world.provider.dimensionId) {
   case -1:
    generateNether(world, random, chunkX * 16, chunkZ * 16);
    break;
   case 0:
    generateSurface(world, random, chunkX * 16, chunkZ * 16);
    break;
  }
 }
 
 	/**
 	 * this.addOreSpawn(block, world, random, posX, posZ, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);
 	 *@param block - block
 	 *@param world - world
 	 *@param random - random
 	 *@param posX - x
 	 *@param posZ - z
 	 *@param maxX - chunk
 	 *@param maxZ - chunk
 	 *@param maxVeinSize - integer
 	 *@param chancesToSpawn - integer
 	 *@param minY - 0-256
 	 *@param maxY  - 0-256
 	 **/
 public void generateSurface(World world, Random random, int x, int z) {
	 this.addOreSpawn(enders.additions.register.blocks.magic_ore, world, random, x, z, 16, 16, 8, 16, 1, 256);
	 this.addOreSpawn(enders.additions.register.blocks.salt_ore, world, random, x, z, 16, 16, 8, 8, 1, 256);
	 this.addOreSpawn(enders.additions.register.blocks.ruby_ore, world, random, x, z, 16, 16, 4, 8, 12, 36);
 }
 public void generateNether(World world, Random random, int x, int z) {}
 
 
 public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
  for (int i = 0; i < chancesToSpawn; i++) {
   int posX = blockXPos + random.nextInt(maxX);
   int posY = minY + random.nextInt(maxY - minY);
   int posZ = blockZPos + random.nextInt(maxZ);
   new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
  }
 }
}