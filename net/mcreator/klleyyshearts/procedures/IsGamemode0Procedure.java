/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.PlayerInfo;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.GameType;
/*    */ 
/*    */ public class IsGamemode0Procedure {
/*    */   public static boolean execute(Entity entity) {
/* 12 */     if (entity == null)
/* 13 */       return false; 
/* 14 */     return (getEntityGameType(entity) == GameType.SURVIVAL);
/*    */   }
/*    */   
/*    */   private static GameType getEntityGameType(Entity entity) {
/* 18 */     if (entity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)entity;
/* 19 */       return serverPlayer.gameMode.getGameModeForPlayer(); }
/* 20 */      if (entity instanceof Player) { Player player = (Player)entity; if (player.level().isClientSide()) {
/* 21 */         PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
/* 22 */         if (playerInfo != null)
/* 23 */           return playerInfo.getGameMode(); 
/*    */       }  }
/* 25 */      return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\IsGamemode0Procedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */