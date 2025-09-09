/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModItems;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class SoulAmuletItemPickedUProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPickup(ItemEntityPickupEvent.Pre event) {
/* 22 */     execute((Event)event, (LevelAccessor)event.getPlayer().level(), (Entity)event.getPlayer(), event.getItemEntity().getItem());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
/* 26 */     execute(null, world, entity, itemstack);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
/* 30 */     if (entity == null)
/*    */       return; 
/* 32 */     if (itemstack.getItem() == KlleyysHeartsModItems.SOUL_AMULET.get() && world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SEND_SOUL_AMULET_INFORMATION) && 
/* 33 */       !world.isClientSide() && world.getServer() != null)
/* 34 */       world.getServer().getPlayerList().broadcastSystemMessage(
/* 35 */           (Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThe §4§lSOUL AMULET §r§ewas picked up by §5§l" + entity.getDisplayName().getString() + "§r§e."), false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SoulAmuletItemPickedUProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */