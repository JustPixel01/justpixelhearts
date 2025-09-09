/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import com.mojang.brigadier.arguments.DoubleArgumentType;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.arguments.EntityArgument;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class CombatCommandProcedure
/*    */ {
/*    */   public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
/* 13 */     if (entity == null)
/*    */       return; 
/* 15 */     if (entity.hasPermissions(4)) {
/* 16 */       commandParameterEntity(arguments, "entity").getPersistentData().putDouble("combatTicks", DoubleArgumentType.getDouble(arguments, "number") * 20.0D);
/*    */     }
/*    */   }
/*    */   
/*    */   private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
/*    */     try {
/* 22 */       return EntityArgument.getEntity(arguments, parameter);
/* 23 */     } catch (CommandSyntaxException e) {
/* 24 */       e.printStackTrace();
/* 25 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\CombatCommandProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */