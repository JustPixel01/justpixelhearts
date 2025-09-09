/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.tick.LevelTickEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class FrameCounterProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onWorldTick(LevelTickEvent.Post event) {
/* 22 */     execute((Event)event, (LevelAccessor)event.getLevel());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world) {
/* 26 */     execute(null, world);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world) {
/* 30 */     for (Entity entityiterator : new ArrayList(world.players())) {
/* 31 */       if (((KlleyysHeartsModVariables.PlayerVariables)entityiterator.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).Animation && world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SHOW_DEATH_SCREEN)) {
/*    */         
/* 33 */         KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entityiterator.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 34 */         ((KlleyysHeartsModVariables.PlayerVariables)entityiterator.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).animationTick++;
/* 35 */         _vars.syncPlayerVariables(entityiterator);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\FrameCounterProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */