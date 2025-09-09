/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.DoubleArgumentType;
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
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
/*    */ public class HeartsCommandProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 21 */     if (entity == null)
/*    */       return; 
/* 23 */     if (entity.hasPermissions(4))
/* 24 */     { if (DoubleArgumentType.getDouble(arguments, "number") <= 3.0D)
/* 25 */       { if (!world.isClientSide()) {
/* 26 */           BlockPos _bp = new BlockPos(21, -64, 21);
/* 27 */           BlockEntity _blockEntity = world.getBlockEntity(_bp);
/* 28 */           BlockState _bs = world.getBlockState(_bp);
/* 29 */           if (_blockEntity != null)
/* 30 */             _blockEntity.getPersistentData().putDouble("?" + StringArgumentType.getString(arguments, "player"), DoubleArgumentType.getDouble(arguments, "number")); 
/* 31 */           if (world instanceof Level) { Level _level = (Level)world;
/* 32 */             _level.sendBlockUpdated(_bp, _bs, _bs, 3); }
/*    */         
/* 34 */         }  if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 35 */             _player.displayClientMessage((Component)Component.literal(Component.translatable("msg.heartscommand.1-1").getString() + Component.translatable("msg.heartscommand.1-1").getString() + StringArgumentType.getString(arguments, "player") + Component.translatable("msg.heartscommand.1-2").getString()), false);
/*    */           } }
/*    */          }
/* 38 */       else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 39 */           _player.displayClientMessage((Component)Component.literal(Component.translatable("msg.heartscommand.2-1").getString()), false);
/*    */         } }
/*    */        }
/* 42 */     else if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 43 */         _player.displayClientMessage((Component)Component.literal(Component.translatable("msg.heartscommand.3-1").getString()), false);
/*    */       } }
/*    */     
/* 46 */     KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 47 */     _vars.hearts = getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString());
/* 48 */     _vars.syncPlayerVariables(entity);
/*    */   }
/*    */ 
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 53 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 54 */     if (blockEntity != null)
/* 55 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 56 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\HeartsCommandProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */