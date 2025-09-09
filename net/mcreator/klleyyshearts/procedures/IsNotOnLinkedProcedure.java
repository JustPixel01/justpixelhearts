/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class IsNotOnLinkedProcedure {
/*    */   public static boolean execute(LevelAccessor world, Entity entity) {
/*  8 */     if (entity == null)
/*  9 */       return false; 
/* 10 */     return !IsOnLinkedProcedure.execute(world, entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\IsNotOnLinkedProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */