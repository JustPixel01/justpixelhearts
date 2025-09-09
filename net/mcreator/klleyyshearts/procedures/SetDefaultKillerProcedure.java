/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.tick.PlayerTickEvent;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class SetDefaultKillerProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(PlayerTickEvent.Post event) {
/* 21 */     execute((Event)event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, Entity entity) {
/* 25 */     execute(null, world, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
/* 29 */     if (entity == null)
/*    */       return; 
/* 31 */     if (getBlockNBTString(world, new BlockPos(21, -64, 21), "$" + entity.getDisplayName().getString()).equals("") && 
/* 32 */       !world.isClientSide()) {
/* 33 */       BlockPos _bp = new BlockPos(21, -64, 21);
/* 34 */       BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 35 */       BlockState _bs = world.getBlockState(_bp);
/* 36 */       if (_blockEntity != null)
/* 37 */         _blockEntity.getPersistentData().putString("$" + entity.getDisplayName().getString(), "[Intentional Game Design]"); 
/* 38 */       if (world instanceof Level) { Level _level = (Level)world;
/* 39 */         _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
/* 45 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 46 */     if (blockEntity != null)
/* 47 */       return blockEntity.getPersistentData().getString(tag); 
/* 48 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SetDefaultKillerProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */