package net.ecocraft.ecoearth.server.world.gen;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;

public class ChunkProviderEarth implements IChunkProvider {
    /**
     * RNG.
     */
    private Random rand;
    /**
     * Reference to the World object.
     */
    private World worldObj;
    private MapGenScatteredFeature scatteredFeatureGenerator;
    /**
     * The biomes that are used to generate the chunk
     */
    private BiomeGenBase[] biomesForGeneration;

    private EarthGen heightmapGenerator;

    public ChunkProviderEarth(World world, long seed, EarthGen heightmapGenerator) {
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
        this.worldObj = world;
        this.rand = new Random(seed);
        this.heightmapGenerator = heightmapGenerator;

        try {
            this.heightmapGenerator.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer chunkPrimer) {
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);

        IBlockState stoneBlock = Blocks.stone.getDefaultState();
        IBlockState liquidBlock = Blocks.water.getDefaultState();

        int oceanHeight = 59;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int height = (heightmapGenerator.getHeightForCoords(x + (chunkX * 16), z + (chunkZ * 16)));

                for (int y = 0; y < Math.max(oceanHeight, height); y++) {
                    if (y < height) {
                        chunkPrimer.setBlockState(x, y, z, stoneBlock);
                    } else {
                        chunkPrimer.setBlockState(x, y, z, liquidBlock);
                    }
                }
            }
        }
    }

    public void func_180517_a(int chunkX, int chunkZ, ChunkPrimer chunkPrimer, BiomeGenBase[] biomes) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, chunkPrimer, this.worldObj);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) {
            return;
        }

        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                BiomeGenBase biome = biomes[x + z * 16];

                if (biome != null) {
                    genTerrainBlocks(biome, this.worldObj, this.rand, chunkPrimer, chunkX * 16 + z, chunkZ * 16 + x);
                }
            }
        }
    }

    public void genTerrainBlocks(BiomeGenBase biome, World world, Random random, ChunkPrimer chunkPrimer, int x, int z) {
        IBlockState topBlock = biome.topBlock;
        IBlockState fillerBlock = biome.fillerBlock;
        int chunkX = x & 15;
        int chunkZ = z & 15;

        IBlockState stoneBlock = Blocks.stone.getDefaultState();

        boolean reachedSurface = false;
        int depthSinceSurface = 0;

        for (int y = 255; y >= 0; --y) {
            if (y <= random.nextInt(5)) {
                chunkPrimer.setBlockState(chunkZ, y, chunkX, Blocks.bedrock.getDefaultState());
            } else {
                IBlockState previousBlock = chunkPrimer.getBlockState(chunkZ, y, chunkX);

                if (previousBlock.getBlock().getMaterial() == Material.air) {
                    reachedSurface = true;
                } else if (previousBlock == stoneBlock) {
                    if (reachedSurface) {
                        if (depthSinceSurface == 0) {
                            chunkPrimer.setBlockState(chunkZ, y, chunkX, topBlock);
                        } else if (depthSinceSurface < 4) {
                            chunkPrimer.setBlockState(chunkZ, y, chunkX, fillerBlock);
                        }

                        depthSinceSurface++;
                    }
                }
            }
        }
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int x, int z) {
        this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(x, z, chunkprimer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.func_180517_a(x, z, chunkprimer, this.biomesForGeneration);

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);

        byte[] biomeArray = chunk.getBiomeArray();

        for (int biomeIndex = 0; biomeIndex < biomeArray.length; ++biomeIndex) {
            biomeArray[biomeIndex] = (byte) this.biomesForGeneration[biomeIndex].biomeID;
        }

        chunk.generateSkylightMap();

        heightmapGenerator.clearCache();

        return chunk;
    }

    /**
     * Checks to see if a chunk exists at x, z
     */
    public boolean chunkExists(int x, int z) {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider provider, int p_73153_2_, int p_73153_3_) {
        BlockFalling.fallInstantly = true;
        int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BlockPos blockpos = new BlockPos(k, 0, l);
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long) p_73153_2_ * i1 + (long) p_73153_3_ * j1 ^ this.worldObj.getSeed());
        boolean flag = false;

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(provider, worldObj, rand, p_73153_2_, p_73153_3_, flag));

        int k1;
        int l1;
        int i2;

        biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
        if (TerrainGen.populate(provider, worldObj, rand, p_73153_2_, p_73153_3_, flag, ANIMALS)) {
            SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        }
        blockpos = blockpos.add(8, 0, 8);

        boolean doGen = TerrainGen.populate(provider, worldObj, rand, p_73153_2_, p_73153_3_, flag, ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1) {
            for (l1 = 0; l1 < 16; ++l1) {
                BlockPos blockpos1 = this.worldObj.getPrecipitationHeight(blockpos.add(k1, 0, l1));
                BlockPos blockpos2 = blockpos1.down();

                if (this.worldObj.canBlockFreezeWater(blockpos2)) {
                    this.worldObj.setBlockState(blockpos2, Blocks.ice.getDefaultState(), 2);
                }

                if (this.worldObj.canSnowAt(blockpos1, true)) {
                    this.worldObj.setBlockState(blockpos1, Blocks.snow_layer.getDefaultState(), 2);
                }
            }
        }
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(provider, worldObj, rand, p_73153_2_, p_73153_3_, flag));

        BlockFalling.fallInstantly = false;
    }

    public boolean populateChunk(IChunkProvider provider, Chunk chunk, int x, int y) {
        return false;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean saveAll, IProgressUpdate progressUpdate) {
        return true;
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    public void saveExtraData() {
    }

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks() {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave() {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString() {
        return "RandomLevelSource";
    }

    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return worldObj.getBiomeGenForCoords(pos).getSpawnableList(creatureType);
    }

    public BlockPos getStrongholdGen(World world, String gen, BlockPos pos) {
        return pos;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(Chunk chunk, int x, int z) {
    }

    public Chunk provideChunk(BlockPos pos) {
        return this.provideChunk(pos.getX() >> 4, pos.getZ() >> 4);
    }
}