/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ 
/*    */ public class SoulAmuletItemIsDroppedByPlayerProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, double x, double y, double z) {
/* 10 */     if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SEND_SOUL_AMULET_INFORMATION) && 
/* 11 */       !world.isClientSide() && world.getServer() != null)
/* 12 */       world.getServer().getPlayerList().broadcastSystemMessage(
/* 13 */           (Component)Component.literal("§4§lKlleyy's Hearts >> §r§eTHE §4§lSOUL AMULET §r§eWAS DROPPED AT §5§l" + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + "§r§e."), false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SoulAmuletItemIsDroppedByPlayerProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */