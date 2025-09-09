/*    */ package net.mcreator.klleyyshearts.init;
/*    */ 
/*    */ import net.minecraft.world.level.GameRules;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
/*    */ public class KlleyysHeartsModGameRules
/*    */ {
/*    */   public static GameRules.Key<GameRules.BooleanValue> BAN_IF_NO_HEARTS;
/*    */   public static GameRules.Key<GameRules.BooleanValue> TNT_ACTIVATE_COMBATMODE;
/*    */   public static GameRules.Key<GameRules.BooleanValue> ALLOW_TRADING_HEARTS;
/*    */   public static GameRules.Key<GameRules.BooleanValue> SEND_SOUL_AMULET_INFORMATION;
/*    */   public static GameRules.Key<GameRules.BooleanValue> SHOW_DEATH_SCREEN;
/*    */   public static GameRules.Key<GameRules.BooleanValue> USE_LINKED_HEARTS;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerGameRules(FMLCommonSetupEvent event) {
/* 24 */     BAN_IF_NO_HEARTS = GameRules.register("banIfNoHearts", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
/* 25 */     TNT_ACTIVATE_COMBATMODE = GameRules.register("tntActivateCombatmode", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
/* 26 */     ALLOW_TRADING_HEARTS = GameRules.register("allowTradingHearts", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
/* 27 */     SEND_SOUL_AMULET_INFORMATION = GameRules.register("sendSoulAmuletInformation", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
/* 28 */     SHOW_DEATH_SCREEN = GameRules.register("showDeathScreen", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
/* 29 */     USE_LINKED_HEARTS = GameRules.register("useLinkedHearts", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\init\KlleyysHeartsModGameRules.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */