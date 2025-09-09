/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModBlocks;
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
/*    */ public class SetLinkedCommandProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 21 */     if (entity == null)
/*    */       return; 
/* 23 */     if (entity.hasPermissions(4))
/* 24 */     { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.USE_LINKED_HEARTS))
/* 25 */       { if (KlleyysHeartsModBlocks.DATA_BLOCK.get() == world.getBlockState(new BlockPos(21, -64, 21)).getBlock()) {
/* 26 */           if (!world.isClientSide()) {
/* 27 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 28 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 29 */             BlockState _bs = world.getBlockState(_bp);
/* 30 */             if (_blockEntity != null)
/* 31 */               _blockEntity.getPersistentData().putString(StringArgumentType.getString(arguments, "player1"), StringArgumentType.getString(arguments, "player2")); 
/* 32 */             if (world instanceof Level) { Level _level = (Level)world;
/* 33 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 35 */           }  if (!world.isClientSide()) {
/* 36 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 37 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 38 */             BlockState _bs = world.getBlockState(_bp);
/* 39 */             if (_blockEntity != null)
/* 40 */               _blockEntity.getPersistentData().putString(StringArgumentType.getString(arguments, "player2"), StringArgumentType.getString(arguments, "player1")); 
/* 41 */             if (world instanceof Level) { Level _level = (Level)world;
/* 42 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 44 */           }  if (!world.isClientSide()) {
/* 45 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 46 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 47 */             BlockState _bs = world.getBlockState(_bp);
/* 48 */             if (_blockEntity != null)
/* 49 */               _blockEntity.getPersistentData().putBoolean("!" + StringArgumentType.getString(arguments, "player1"), true); 
/* 50 */             if (world instanceof Level) { Level _level = (Level)world;
/* 51 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 53 */           }  if (!world.isClientSide()) {
/* 54 */             BlockPos _bp = new BlockPos(21, -64, 21);
/* 55 */             BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 56 */             BlockState _bs = world.getBlockState(_bp);
/* 57 */             if (_blockEntity != null)
/* 58 */               _blockEntity.getPersistentData().putBoolean("!" + StringArgumentType.getString(arguments, "player2"), true); 
/* 59 */             if (world instanceof Level) { Level _level = (Level)world;
/* 60 */               _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */           
/* 62 */           }  if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 63 */               _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eLinked player: §5§l" + StringArgumentType.getString(arguments, "player1") + " §r§ewith player: §5§l" + 
/* 64 */                     StringArgumentType.getString(arguments, "player2") + "§r§e."), false);  }
/*    */         
/*    */         }  }
/* 67 */       else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 68 */           _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eThis server has disabled linked hearts. Activate by typing /gamerule useLinkedHearts true"), false);
/*    */         } }
/*    */        }
/* 71 */     else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 72 */         _player.displayClientMessage((Component)Component.literal("§cInsufficient permissions."), false);  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SetLinkedCommandProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */