/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModBlocks;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.tick.LevelTickEvent;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class SummonLinkedMarkerProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onWorldTick(LevelTickEvent.Post event) {
/* 24 */     execute((Event)event, (LevelAccessor)event.getLevel());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world) {
/* 28 */     execute(null, world);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world) {
/* 32 */     if (KlleyysHeartsModBlocks.DATA_BLOCK.get() != world.getBlockState(new BlockPos(21, -64, 21)).getBlock()) {
/*    */       
/* 34 */       BlockPos _bp = new BlockPos(21, -64, 21);
/* 35 */       BlockState _bs = ((Block)KlleyysHeartsModBlocks.DATA_BLOCK.get()).defaultBlockState();
/* 36 */       BlockState _bso = world.getBlockState(_bp);
/* 37 */       for (Property<?> _propertyOld : (Iterable<Property<?>>)_bso.getProperties()) {
/* 38 */         Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
/* 39 */         if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
/*    */           try {
/* 41 */             _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
/* 42 */           } catch (Exception exception) {}
/*    */         }
/*    */       } 
/* 45 */       BlockEntity _be = world.getBlockEntity(_bp);
/* 46 */       CompoundTag _bnbt = null;
/* 47 */       if (_be != null) {
/* 48 */         _bnbt = _be.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
/* 49 */         _be.setRemoved();
/*    */       } 
/* 51 */       world.setBlock(_bp, _bs, 3);
/* 52 */       if (_bnbt != null) {
/* 53 */         _be = world.getBlockEntity(_bp);
/* 54 */         if (_be != null) {
/*    */           try {
/* 56 */             _be.loadWithComponents(_bnbt, (HolderLookup.Provider)world.registryAccess());
/* 57 */           } catch (Exception exception) {}
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 63 */     if (KlleyysHeartsModBlocks.DATA_BLOCK.get() == world.getBlockState(new BlockPos(21, -63, 21)).getBlock()) {
/* 64 */       world.setBlock(new BlockPos(21, -63, 21), Blocks.BEDROCK.defaultBlockState(), 3);
/*    */     } else {
/* 66 */       world.setBlock(new BlockPos(21, -63, 21), ((Block)KlleyysHeartsModBlocks.DATA_BLOCK.get()).defaultBlockState(), 3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SummonLinkedMarkerProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */