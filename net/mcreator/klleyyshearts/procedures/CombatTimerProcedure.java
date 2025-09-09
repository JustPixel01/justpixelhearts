/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.tick.PlayerTickEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class CombatTimerProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(PlayerTickEvent.Post event) {
/* 20 */     execute((Event)event, (Entity)event.getEntity());
/*    */   }
/*    */   
/*    */   public static void execute(Entity entity) {
/* 24 */     execute(null, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, Entity entity) {
/* 28 */     if (entity == null)
/*    */       return; 
/* 30 */     if (0.0D < entity.getPersistentData().getDouble("combatTicks")) {
/* 31 */       if (Math.round(entity.getPersistentData().getDouble("combatTicks") / 2.0D) == entity.getPersistentData().getDouble("combatTicks") / 2.0D && ((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).showCombatTimeRemainingInActionBar && 
/* 32 */         entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 33 */           _player.displayClientMessage((Component)Component.literal("§4-§e" + entity.getPersistentData().getDouble("combatTicks") / 20.0D + "s§4-"), true);  }
/*    */       
/* 35 */       entity.getPersistentData().putDouble("combatTicks", entity.getPersistentData().getDouble("combatTicks") - 1.0D);
/* 36 */     } else if (0.0D == entity.getPersistentData().getDouble("combatTicks")) {
/* 37 */       if (((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).showCombatTimeRemainingInActionBar && 
/* 38 */         entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 39 */           _player.displayClientMessage((Component)Component.literal("§4-§e" + entity.getPersistentData().getDouble("combatTicks") / 20.0D + "s§4-"), true);  }
/*    */       
/* 41 */       if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 42 */           _player.displayClientMessage((Component)Component.literal(Component.translatable("msg.combattimer.1-1").getString()), false);  }
/* 43 */        entity.getPersistentData().putDouble("combatTicks", entity.getPersistentData().getDouble("combatTicks") - 1.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\CombatTimerProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */