/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class SetDefaultHeartsProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/* 23 */     execute((Event)event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, Entity entity) {
/* 27 */     execute(null, world, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
/* 31 */     if (entity == null)
/*    */       return; 
/* 33 */     if (!getBlockNBTLogic(world, new BlockPos(21, -64, 21), "#" + entity.getDisplayName().getString())) {
/* 34 */       if (!world.isClientSide()) {
/* 35 */         BlockPos _bp = new BlockPos(21, -64, 21);
/* 36 */         BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 37 */         BlockState _bs = world.getBlockState(_bp);
/* 38 */         if (_blockEntity != null)
/* 39 */           _blockEntity.getPersistentData().putBoolean("#" + entity.getDisplayName().getString(), true); 
/* 40 */         if (world instanceof Level) { Level _level = (Level)world;
/* 41 */           _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */       
/* 43 */       }  if (!world.isClientSide()) {
/* 44 */         BlockPos _bp = new BlockPos(21, -64, 21);
/* 45 */         BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 46 */         BlockState _bs = world.getBlockState(_bp);
/* 47 */         if (_blockEntity != null)
/* 48 */           _blockEntity.getPersistentData().putDouble("?" + entity.getDisplayName().getString(), 3.0D); 
/* 49 */         if (world instanceof Level) { Level _level = (Level)world;
/* 50 */           _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */       
/*    */       } 
/*    */     } 
/* 54 */     KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 55 */     _vars.hearts = getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString());
/* 56 */     _vars.syncPlayerVariables(entity);
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
/* 61 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 62 */     if (blockEntity != null)
/* 63 */       return blockEntity.getPersistentData().getBoolean(tag); 
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 68 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 69 */     if (blockEntity != null)
/* 70 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 71 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SetDefaultHeartsProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */