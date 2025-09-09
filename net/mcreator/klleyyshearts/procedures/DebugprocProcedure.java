/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.KlleyysHeartsMod;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class DebugprocProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, Entity entity) {
/* 11 */     if (entity == null) {
/*    */       return;
/*    */     }
/* 14 */     KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 15 */     _vars.animationTick = 1.0D;
/* 16 */     _vars.syncPlayerVariables(entity);
/*    */ 
/*    */     
/* 19 */     _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 20 */     _vars.Animation = true;
/* 21 */     _vars.syncPlayerVariables(entity);
/*    */     
/* 23 */     KlleyysHeartsMod.queueServerWork(84, () -> {
/*    */           KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/*    */           _vars.Animation = false;
/*    */           _vars.syncPlayerVariables(entity);
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\DebugprocProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */