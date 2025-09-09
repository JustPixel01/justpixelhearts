/*    */ package net.mcreator.klleyyshearts.item;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.procedures.SoulAmuletItemIsDroppedByPlayerProcedure;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class SoulAmuletItem
/*    */   extends Item {
/*    */   public SoulAmuletItem() {
/* 13 */     super((new Item.Properties()).stacksTo(1).rarity(Rarity.EPIC));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
/* 18 */     SoulAmuletItemIsDroppedByPlayerProcedure.execute((LevelAccessor)entity.level(), entity.getX(), entity.getY(), entity.getZ());
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\item\SoulAmuletItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */