/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class AnimationFrameCounterProcedure
/*    */ {
/*    */   public static double execute(Entity entity) {
/*  9 */     if (entity == null)
/* 10 */       return 0.0D; 
/* 11 */     return (Math.floor(((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).animationTick / 12.0D) - ((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).animationTick / 12.0D) * 12.0D - 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\AnimationFrameCounterProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */