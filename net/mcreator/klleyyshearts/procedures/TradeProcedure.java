/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.arguments.EntityArgument;
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
/*    */ public class TradeProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 22 */     if (entity == null)
/*    */       return; 
/* 24 */     if (1.0D < getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()) && 3.0D > 
/* 25 */       getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + commandParameterEntity(arguments, "entity").getDisplayName().getString()) && world
/* 26 */       .getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.ALLOW_TRADING_HEARTS))
/* 27 */     { if (!world.isClientSide()) {
/* 28 */         BlockPos _bp = new BlockPos(21, -64, 21);
/* 29 */         BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 30 */         BlockState _bs = world.getBlockState(_bp);
/* 31 */         if (_blockEntity != null)
/* 32 */           _blockEntity.getPersistentData().putDouble("?" + entity.getDisplayName().getString(), ((KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).hearts - 1.0D); 
/* 33 */         if (world instanceof Level) { Level _level = (Level)world;
/* 34 */           _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */       
/* 36 */       }  if (!world.isClientSide()) {
/* 37 */         BlockPos _bp = new BlockPos(21, -64, 21);
/* 38 */         BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 39 */         BlockState _bs = world.getBlockState(_bp);
/* 40 */         if (_blockEntity != null)
/* 41 */           _blockEntity.getPersistentData().putDouble("?" + entity.getDisplayName().getString(), ((KlleyysHeartsModVariables.PlayerVariables)commandParameterEntity(arguments, "entity").getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).hearts + 1.0D); 
/* 42 */         if (world instanceof Level) { Level _level = (Level)world;
/* 43 */           _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */       
/* 45 */       }  if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 46 */           _player.displayClientMessage((Component)Component.literal("You just gave 1 heart to " + commandParameterEntity(arguments, "entity").getDisplayName().getString()), false);  }
/* 47 */        Entity entity1 = commandParameterEntity(arguments, "entity"); if (entity1 instanceof Player) { Player _player = (Player)entity1; if (!_player.level().isClientSide())
/* 48 */           _player.displayClientMessage((Component)Component.literal(entity.getDisplayName().getString() + " just gave you 1 heart."), false);  }  }
/* 49 */     else if (!world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.ALLOW_TRADING_HEARTS))
/* 50 */     { if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 51 */           _player.displayClientMessage((Component)Component.literal("This function is disabled on this server. If you are an admin, use /gamerule allowTradingHearts true."), false);  }  }
/* 52 */     else if (1.0D >= getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()))
/* 53 */     { if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 54 */           _player.displayClientMessage((Component)Component.literal("You have only 1 heart left. You can't give this to anyone."), false);  }  }
/* 55 */     else if (3.0D <= getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + commandParameterEntity(arguments, "entity").getDisplayName().getString()) && 
/* 56 */       entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 57 */         _player.displayClientMessage((Component)Component.literal("The targeted user already has 3 hearts."), false);  }
/*    */   
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 62 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 63 */     if (blockEntity != null)
/* 64 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 65 */     return -1.0D;
/*    */   }
/*    */   
/*    */   private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
/*    */     try {
/* 70 */       return EntityArgument.getEntity(arguments, parameter);
/* 71 */     } catch (CommandSyntaxException e) {
/* 72 */       e.printStackTrace();
/* 73 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\TradeProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */