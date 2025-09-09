/*    */ package net.mcreator.klleyyshearts.init;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.item.BlockItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredItem;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KlleyysHeartsModItems
/*    */ {
/* 19 */   public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems("klleyys_hearts");
/* 20 */   public static final DeferredItem<Item> SOUL_AMULET = REGISTRY.register("soul_amulet", net.mcreator.klleyyshearts.item.SoulAmuletItem::new);
/* 21 */   public static final DeferredItem<Item> DATA_BLOCK = block((DeferredHolder)KlleyysHeartsModBlocks.DATA_BLOCK);
/*    */ 
/*    */ 
/*    */   
/*    */   private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
/* 26 */     return REGISTRY.register(block.getId().getPath(), () -> new BlockItem((Block)block.get(), new Item.Properties()));
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\init\KlleyysHeartsModItems.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */