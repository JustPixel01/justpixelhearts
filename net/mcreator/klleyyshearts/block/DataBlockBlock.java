/*    */ package net.mcreator.klleyyshearts.block;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.block.entity.DataBlockBlockEntity;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.Container;
/*    */ import net.minecraft.world.Containers;
/*    */ import net.minecraft.world.MenuProvider;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.EntityBlock;
/*    */ import net.minecraft.world.level.block.SoundType;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ public class DataBlockBlock
/*    */   extends Block implements EntityBlock {
/*    */   public DataBlockBlock() {
/* 21 */     super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0F, 3600000.0F));
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
/* 26 */     return 15;
/*    */   }
/*    */ 
/*    */   
/*    */   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
/* 31 */     BlockEntity tileEntity = worldIn.getBlockEntity(pos);
/* 32 */     MenuProvider menuProvider = (MenuProvider)tileEntity; return (tileEntity instanceof MenuProvider) ? menuProvider : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
/* 37 */     return (BlockEntity)new DataBlockBlockEntity(pos, state);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
/* 42 */     super.triggerEvent(state, world, pos, eventID, eventParam);
/* 43 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 44 */     return (blockEntity == null) ? false : blockEntity.triggerEvent(eventID, eventParam);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
/* 49 */     if (state.getBlock() != newState.getBlock()) {
/* 50 */       BlockEntity blockEntity = world.getBlockEntity(pos);
/* 51 */       if (blockEntity instanceof DataBlockBlockEntity) { DataBlockBlockEntity be = (DataBlockBlockEntity)blockEntity;
/* 52 */         Containers.dropContents(world, pos, (Container)be);
/* 53 */         world.updateNeighbourForOutputSignal(pos, this); }
/*    */       
/* 55 */       super.onRemove(state, world, pos, newState, isMoving);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasAnalogOutputSignal(BlockState state) {
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
/* 66 */     BlockEntity tileentity = world.getBlockEntity(pos);
/* 67 */     if (tileentity instanceof DataBlockBlockEntity) { DataBlockBlockEntity be = (DataBlockBlockEntity)tileentity;
/* 68 */       return AbstractContainerMenu.getRedstoneSignalFromContainer((Container)be); }
/*    */     
/* 70 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\block\DataBlockBlock.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */