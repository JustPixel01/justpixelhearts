/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.BoolArgumentType;
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ 
/*    */ public class ChangeLinkedStatusProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 21 */     if (entity == null)
/*    */       return; 
/* 23 */     if (entity.hasPermissions(4))
/* 24 */     { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.USE_LINKED_HEARTS))
/* 25 */       { if (getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player")).equals("")) {
/* 26 */           if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 27 */               _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§ePlayer §5§l" + StringArgumentType.getString(arguments, "player") + " §r§ecurrenty doesn't have a linked heart partner. Configure by typing /hearts linked pair {player1} {player2} (Please pay attention to upper and lower case letters)"), false);  }
/*    */         
/*    */         } else {
/* 30 */           if (!world.isClientSide()) {
/* 31 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 32 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 33 */             BlockState _bs = world.getBlockState(_bp);
/* 34 */             if (_blockEntity != null)
/* 35 */               _blockEntity.getPersistentData().putBoolean("!" + StringArgumentType.getString(arguments, "player"), BoolArgumentType.getBool(arguments, "logic")); 
/* 36 */             if (world instanceof Level) { Level _level = (Level)world;
/* 37 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 39 */           }  if (!world.isClientSide()) {
/* 40 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 41 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 42 */             BlockState _bs = world.getBlockState(_bp);
/* 43 */             if (_blockEntity != null)
/* 44 */               _blockEntity.getPersistentData().putBoolean("!" + getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player")), BoolArgumentType.getBool(arguments, "logic")); 
/* 45 */             if (world instanceof Level) { Level _level = (Level)world;
/* 46 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 48 */           }  if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 49 */               _player.displayClientMessage(
/* 50 */                   (Component)Component.literal("§4§lKlleyy's Hearts >> §r§eSet state of linked heart for players: §5§l" + StringArgumentType.getString(arguments, "player") + " §r§eand §5§l" + 
/* 51 */                     getBlockNBTString(world, new BlockPos(21, -64, 21), StringArgumentType.getString(arguments, "player")) + "§r§e to §4§l" + BoolArgumentType.getBool(arguments, "logic")), false);
/*    */             } }
/*    */         
/*    */         }  }
/* 55 */       else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 56 */           _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThis server has disabled linked hearts. Activate by typing /gamerule useLinkedHearts true"), false);
/*    */         } }
/*    */        }
/* 59 */     else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 60 */         _player.displayClientMessage((Component)Component.literal("§cInsufficient permissions."), false);  }
/*    */   
/*    */   }
/*    */   
/*    */   private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
/* 65 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 66 */     if (blockEntity != null)
/* 67 */       return blockEntity.getPersistentData().getString(tag); 
/* 68 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\ChangeLinkedStatusProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */