/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.KlleyysHeartsMod;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class GetHeartsProcedure
/*    */ {
/*    */   public static double execute(LevelAccessor world, Entity entity) {
/* 11 */     if (entity == null)
/* 12 */       return 0.0D; 
/* 13 */     KlleyysHeartsMod.queueServerWork(20, () -> {
/*    */         
/* 15 */         }); return ((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).hearts;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\GetHeartsProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */