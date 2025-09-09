/*    */ package net.mcreator.klleyyshearts.command;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.mcreator.klleyyshearts.procedures.DebugprocProcedure;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.neoforge.common.util.FakePlayer;
/*    */ import net.neoforged.neoforge.common.util.FakePlayerFactory;
/*    */ import net.neoforged.neoforge.event.RegisterCommandsEvent;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class KhdebugCommand {
/*    */   @SubscribeEvent
/*    */   public static void registerCommand(RegisterCommandsEvent event) {
/* 21 */     event.getDispatcher().register((LiteralArgumentBuilder)Commands.literal("khdebug")
/*    */         
/* 23 */         .executes(arguments -> {
/*    */             FakePlayer fakePlayer;
/*    */             Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
/*    */             double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*    */             double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*    */             double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*    */             Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*    */             if (entity == null && world instanceof ServerLevel) {
/*    */               ServerLevel _servLevel = (ServerLevel)world;
/*    */               fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*    */             } 
/*    */             Direction direction = Direction.DOWN;
/*    */             if (fakePlayer != null)
/*    */               direction = fakePlayer.getDirection(); 
/*    */             DebugprocProcedure.execute((LevelAccessor)world, (Entity)fakePlayer);
/*    */             return 0;
/*    */           }));
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\command\KhdebugCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */