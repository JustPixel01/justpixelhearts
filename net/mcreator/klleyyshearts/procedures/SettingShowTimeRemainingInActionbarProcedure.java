/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.BoolArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ 
/*    */ public class SettingShowTimeRemainingInActionbarProcedure
/*    */ {
/*    */   public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 15 */     if (entity == null) {
/*    */       return;
/*    */     }
/* 18 */     KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 19 */     _vars.showCombatTimeRemainingInActionBar = BoolArgumentType.getBool(arguments, "logic");
/* 20 */     _vars.syncPlayerVariables(entity);
/*    */     
/* 22 */     if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide())
/* 23 */         _player.displayClientMessage((Component)Component.literal(Component.translatable("msg.settings.1-1").getString() + Component.translatable("msg.settings.1-1").getString() + entity.getDisplayName().getString() + Component.translatable("msg.settings.1-2").getString() + 
/* 24 */               BoolArgumentType.getBool(arguments, "logic")), false);  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\SettingShowTimeRemainingInActionbarProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */