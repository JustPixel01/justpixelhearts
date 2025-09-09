/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ 
/*    */ public class GetCommandNEWProcedure
/*    */ {
/*    */   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 16 */     if (entity == null)
/*    */       return; 
/* 18 */     if (entity.hasPermissions(4) && 
/* 19 */       entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) {
/* 20 */         _player.displayClientMessage(
/* 21 */             (Component)Component.literal("Player " + 
/* 22 */               StringArgumentType.getString(arguments, "player") + " currently has " + getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + StringArgumentType.getString(arguments, "player")) + " hearts."), false);
/*    */       } }
/*    */   
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 28 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 29 */     if (blockEntity != null)
/* 30 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 31 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\GetCommandNEWProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */