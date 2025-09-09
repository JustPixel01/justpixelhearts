/*     */ package net.mcreator.klleyyshearts.block.entity;
/*     */ 
/*     */ import java.util.stream.IntStream;
/*     */ import javax.annotation.Nullable;
/*     */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModBlockEntities;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.NonNullList;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
/*     */ import net.minecraft.world.ContainerHelper;
/*     */ import net.minecraft.world.WorldlyContainer;
/*     */ import net.minecraft.world.entity.player.Inventory;
/*     */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*     */ import net.minecraft.world.inventory.ChestMenu;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*     */ import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
/*     */ 
/*     */ public class DataBlockBlockEntity
/*     */   extends RandomizableContainerBlockEntity
/*     */   implements WorldlyContainer {
/*  29 */   private NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
/*  30 */   private final SidedInvWrapper handler = new SidedInvWrapper(this, null);
/*     */   
/*     */   public DataBlockBlockEntity(BlockPos position, BlockState state) {
/*  33 */     super((BlockEntityType)KlleyysHeartsModBlockEntities.DATA_BLOCK.get(), position, state);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
/*  38 */     super.loadAdditional(compound, lookupProvider);
/*  39 */     if (!tryLoadLootTable(compound))
/*  40 */       this.stacks = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY); 
/*  41 */     ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
/*  46 */     super.saveAdditional(compound, lookupProvider);
/*  47 */     if (!trySaveLootTable(compound)) {
/*  48 */       ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientboundBlockEntityDataPacket getUpdatePacket() {
/*  54 */     return ClientboundBlockEntityDataPacket.create((BlockEntity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
/*  59 */     return saveWithFullMetadata(lookupProvider);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getContainerSize() {
/*  64 */     return this.stacks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  69 */     for (ItemStack itemstack : this.stacks) {
/*  70 */       if (!itemstack.isEmpty())
/*  71 */         return false; 
/*  72 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Component getDefaultName() {
/*  77 */     return (Component)Component.literal("data_block");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxStackSize() {
/*  82 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public AbstractContainerMenu createMenu(int id, Inventory inventory) {
/*  87 */     return (AbstractContainerMenu)ChestMenu.threeRows(id, inventory);
/*     */   }
/*     */ 
/*     */   
/*     */   public Component getDisplayName() {
/*  92 */     return (Component)Component.literal("Klleyys Hearts Data Block");
/*     */   }
/*     */ 
/*     */   
/*     */   protected NonNullList<ItemStack> getItems() {
/*  97 */     return this.stacks;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setItems(NonNullList<ItemStack> stacks) {
/* 102 */     this.stacks = stacks;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlaceItem(int index, ItemStack stack) {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] getSlotsForFace(Direction side) {
/* 112 */     return IntStream.range(0, getContainerSize()).toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlaceItemThroughFace(int index, ItemStack itemstack, @Nullable Direction direction) {
/* 117 */     return canPlaceItem(index, itemstack);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canTakeItemThroughFace(int index, ItemStack itemstack, Direction direction) {
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public SidedInvWrapper getItemHandler() {
/* 126 */     return this.handler;
/*     */   }
/*     */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\block\entity\DataBlockBlockEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */