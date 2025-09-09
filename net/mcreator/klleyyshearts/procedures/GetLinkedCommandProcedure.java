/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ 
/*    */ 
/*    */ public class GetLinkedCommandProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 18 */     if (entity == null)
/*    */       return; 
/* 20 */     if (entity.hasPermissions(4) || (entity.getDisplayName().getString().equals(StringArgumentType.getString(arguments, "player")) && getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()) == 0.0D))
/* 21 */     { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.USE_LINKED_HEARTS))
/* 22 */       { if ("".equals(getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player"))))
/* 23 */         { if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 24 */               _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§ePlayer §5§l" + StringArgumentType.getString(arguments, "player") + "§r§e Currently doesn't have a linked heart partner. (please pay attention to upper and lower case letters)"), false);  }
/*    */            }
/* 26 */         else if (getBlockNBTLogic(world, new BlockPos(21, -64, 21), "!" + StringArgumentType.getString(arguments, "player")))
/* 27 */         { if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 28 */               _player.displayClientMessage(
/* 29 */                   (Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThe linked heart partner of player §5§l" + StringArgumentType.getString(arguments, "player") + "§r§e is: §5§l" + 
/* 30 */                     getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player")) + "§r§e and the current state of the linked heart is: §4§lactive§r§e."), false);
/*    */             } }
/*    */            }
/* 33 */         else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 34 */             _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThe linked heart partner of player §5§l" + StringArgumentType.getString(arguments, "player") + "§r§e is: §5§l" + 
/* 35 */                   getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player")) + "§r§e and the current state of the linked heart is: §4§linactive§r§e."), false);
/*    */           } }
/*    */         
/*    */          }
/* 39 */       else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 40 */           _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThis server has disabled linked hearts. Activate by typing /gamerule useLinkedHearts true"), false);
/*    */         } }
/*    */        }
/* 43 */     else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 44 */         _player.displayClientMessage((Component)Component.literal("§cInsufficient permissions."), false);  }
/*    */   
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 49 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 50 */     if (blockEntity != null)
/* 51 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 52 */     return -1.0D;
/*    */   }
/*    */   
/*    */   private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
/* 56 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 57 */     if (blockEntity != null)
/* 58 */       return blockEntity.getPersistentData().getString(tag); 
/* 59 */     return "";
/*    */   }
/*    */   
/*    */   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
/* 63 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 64 */     if (blockEntity != null)
/* 65 */       return blockEntity.getPersistentData().getBoolean(tag); 
/* 66 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\GetLinkedCommandProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */