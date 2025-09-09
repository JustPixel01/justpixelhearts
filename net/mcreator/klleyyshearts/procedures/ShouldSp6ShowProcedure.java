/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class ShouldSp6ShowProcedure
/*    */ {
/*    */   public static boolean execute(Entity entity) {
/*  9 */     if (entity == null)
/* 10 */       return false; 
/* 11 */     return (((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).animationTick <= 72.0D && ((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).animationTick > 60.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\ShouldSp6ShowProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */