/*    */ package net.mcreator.klleyyshearts.network;
/*    */ 
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class EventBusVariableHandlers
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
/* 43 */     Player player = event.getEntity(); if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 44 */       ((KlleyysHeartsModVariables.PlayerVariables)serverPlayer.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).syncPlayerVariables((Entity)event.getEntity()); }
/*    */   
/*    */   }
/*    */   @SubscribeEvent
/*    */   public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
/* 49 */     Player player = event.getEntity(); if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 50 */       ((KlleyysHeartsModVariables.PlayerVariables)serverPlayer.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).syncPlayerVariables((Entity)event.getEntity()); }
/*    */   
/*    */   }
/*    */   @SubscribeEvent
/*    */   public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
/* 55 */     Player player = event.getEntity(); if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 56 */       ((KlleyysHeartsModVariables.PlayerVariables)serverPlayer.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).syncPlayerVariables((Entity)event.getEntity()); }
/*    */   
/*    */   }
/*    */   @SubscribeEvent
/*    */   public static void clonePlayer(PlayerEvent.Clone event) {
/* 61 */     KlleyysHeartsModVariables.PlayerVariables original = (KlleyysHeartsModVariables.PlayerVariables)event.getOriginal().getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 62 */     KlleyysHeartsModVariables.PlayerVariables clone = new KlleyysHeartsModVariables.PlayerVariables();
/* 63 */     clone.hearts = original.hearts;
/* 64 */     clone.ticksLeft = original.ticksLeft;
/* 65 */     clone.showCombatTimeRemainingInActionBar = original.showCombatTimeRemainingInActionBar;
/* 66 */     clone.animationTick = original.animationTick;
/* 67 */     clone.Animation = original.Animation;
/* 68 */     clone.khtemp = original.khtemp;
/* 69 */     if (!event.isWasDeath()) {
/* 70 */       clone.isInCombat = original.isInCombat;
/*    */     }
/* 72 */     event.getEntity().setData(KlleyysHeartsModVariables.PLAYER_VARIABLES, clone);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\network\KlleyysHeartsModVariables$EventBusVariableHandlers.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */