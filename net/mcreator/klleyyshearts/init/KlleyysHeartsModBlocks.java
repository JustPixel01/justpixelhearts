/*    */ package net.mcreator.klleyyshearts.init;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.registries.DeferredBlock;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KlleyysHeartsModBlocks
/*    */ {
/* 16 */   public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks("klleyys_hearts");
/* 17 */   public static final DeferredBlock<Block> DATA_BLOCK = REGISTRY.register("data_block", net.mcreator.klleyyshearts.block.DataBlockBlock::new);
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\init\KlleyysHeartsModBlocks.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */