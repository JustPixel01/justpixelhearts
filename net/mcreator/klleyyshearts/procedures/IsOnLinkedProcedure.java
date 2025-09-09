/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ 
/*    */ public class IsOnLinkedProcedure {
/*    */   public static boolean execute(LevelAccessor world, Entity entity) {
/* 10 */     if (entity == null)
/* 11 */       return false; 
/* 12 */     return (getBlockNBTLogic(world, new BlockPos(21, -64, 21), "!" + entity.getDisplayName().getString()) && getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()) < 1.0D);
/*    */   }
/*    */   
/*    */   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
/* 16 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 17 */     if (blockEntity != null)
/* 18 */       return blockEntity.getPersistentData().getBoolean(tag); 
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 23 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 24 */     if (blockEntity != null)
/* 25 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 26 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\IsOnLinkedProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */