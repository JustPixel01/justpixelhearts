/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.KlleyysHeartsMod;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.tick.PlayerTickEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class AnimationDebugProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(PlayerTickEvent.Post event) {
/* 20 */     execute((Event)event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, Entity entity) {
/* 24 */     execute(null, world, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
/* 28 */     if (entity == null)
/*    */       return; 
/* 30 */     if (((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).Animation)
/* 31 */       KlleyysHeartsMod.queueServerWork(84, () -> {
/*    */             KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/*    */             _vars.Animation = false;
/*    */             _vars.syncPlayerVariables(entity);
/*    */           }); 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\AnimationDebugProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */