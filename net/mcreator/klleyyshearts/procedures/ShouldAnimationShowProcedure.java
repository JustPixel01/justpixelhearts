/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class ShouldAnimationShowProcedure
/*    */ {
/*    */   public static boolean execute(LevelAccessor world, Entity entity) {
/* 11 */     if (entity == null)
/* 12 */       return false; 
/* 13 */     return (((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).Animation && world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SHOW_DEATH_SCREEN));
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\ShouldAnimationShowProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */