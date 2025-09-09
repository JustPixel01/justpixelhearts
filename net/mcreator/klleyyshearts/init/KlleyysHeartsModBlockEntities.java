/*    */ package net.mcreator.klleyyshearts.init;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.block.entity.DataBlockBlockEntity;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.capabilities.Capabilities;
/*    */ import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
/*    */ import net.neoforged.neoforge.items.IItemHandler;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
/*    */ public class KlleyysHeartsModBlockEntities
/*    */ {
/* 23 */   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, "klleyys_hearts");
/* 24 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DATA_BLOCK = register("data_block", (DeferredHolder)KlleyysHeartsModBlocks.DATA_BLOCK, DataBlockBlockEntity::new);
/*    */ 
/*    */ 
/*    */   
/*    */   private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
/* 29 */     return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, new Block[] { (Block)block.get() }).build(null));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerCapabilities(RegisterCapabilitiesEvent event) {
/* 34 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)DATA_BLOCK.get(), (blockEntity, side) -> ((DataBlockBlockEntity)blockEntity).getItemHandler());
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\init\KlleyysHeartsModBlockEntities.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */