/*     */ package net.mcreator.klleyyshearts.command;
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.arguments.BoolArgumentType;
/*     */ import com.mojang.brigadier.arguments.DoubleArgumentType;
/*     */ import com.mojang.brigadier.arguments.StringArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import net.mcreator.klleyyshearts.procedures.ChangeLinkedStatusProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.CombatCommandProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.GetCommandNEWProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.GetLinkedCommandProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.HeartsCommandProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.SetLinkedCommandProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.SettingShowTimeRemainingInActionbarProcedure;
/*     */ import net.mcreator.klleyyshearts.procedures.TradeProcedure;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.commands.Commands;
/*     */ import net.minecraft.commands.arguments.EntityArgument;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.neoforged.neoforge.common.util.FakePlayer;
/*     */ import net.neoforged.neoforge.common.util.FakePlayerFactory;
/*     */ import net.neoforged.neoforge.event.RegisterCommandsEvent;
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class HeartsCommand {
/*     */   @SubscribeEvent
/*     */   public static void registerCommand(RegisterCommandsEvent event) {
/*  33 */     event.getDispatcher().register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("hearts")
/*     */         
/*  35 */         .then(Commands.literal("set").then(Commands.argument("player", (ArgumentType)StringArgumentType.word()).then(Commands.argument("number", (ArgumentType)DoubleArgumentType.doubleArg(0.0D)).executes(arguments -> {
/*     */                   FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                   if (entity == null && world instanceof ServerLevel) {
/*     */                     ServerLevel _servLevel = (ServerLevel)world;
/*     */                     fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                   } 
/*     */                   Direction direction = Direction.DOWN;
/*     */                   if (fakePlayer != null)
/*     */                     direction = fakePlayer.getDirection(); 
/*     */                   HeartsCommandProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                   return 0;
/*  49 */                 }))))).then(Commands.literal("get").then(Commands.argument("player", (ArgumentType)StringArgumentType.word()).executes(arguments -> {
/*     */                 FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                 double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                 double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                 Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                 if (entity == null && world instanceof ServerLevel) {
/*     */                   ServerLevel _servLevel = (ServerLevel)world;
/*     */                   fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                 } 
/*     */                 Direction direction = Direction.DOWN;
/*     */                 if (fakePlayer != null)
/*     */                   direction = fakePlayer.getDirection(); 
/*     */                 GetCommandNEWProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                 return 0;
/*  63 */               })))).then(Commands.literal("settings").then(Commands.literal("showCombatTimeRemainingInActionbar").then(Commands.argument("logic", (ArgumentType)BoolArgumentType.bool()).executes(arguments -> {
/*     */                   FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                   if (entity == null && world instanceof ServerLevel) {
/*     */                     ServerLevel _servLevel = (ServerLevel)world;
/*     */                     fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                   } 
/*     */                   Direction direction = Direction.DOWN;
/*     */                   if (fakePlayer != null)
/*     */                     direction = fakePlayer.getDirection(); 
/*     */                   SettingShowTimeRemainingInActionbarProcedure.execute(arguments, (Entity)fakePlayer);
/*     */                   return 0;
/*  77 */                 }))))).then(Commands.literal("give").then(Commands.argument("entity", (ArgumentType)EntityArgument.player()).executes(arguments -> {
/*     */                 FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                 double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                 double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                 Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                 if (entity == null && world instanceof ServerLevel) {
/*     */                   ServerLevel _servLevel = (ServerLevel)world;
/*     */                   fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                 } 
/*     */                 Direction direction = Direction.DOWN;
/*     */                 if (fakePlayer != null)
/*     */                   direction = fakePlayer.getDirection(); 
/*     */                 TradeProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                 return 0;
/*  91 */               })))).then(Commands.literal("combat").then(Commands.argument("entity", (ArgumentType)EntityArgument.player()).then(Commands.argument("number", (ArgumentType)DoubleArgumentType.doubleArg(0.0D)).executes(arguments -> {
/*     */                   FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                   if (entity == null && world instanceof ServerLevel) {
/*     */                     ServerLevel _servLevel = (ServerLevel)world;
/*     */                     fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                   } 
/*     */                   Direction direction = Direction.DOWN;
/*     */                   if (fakePlayer != null)
/*     */                     direction = fakePlayer.getDirection(); 
/*     */                   CombatCommandProcedure.execute(arguments, (Entity)fakePlayer);
/*     */                   return 0;
/* 105 */                 }))))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("linked").then(Commands.literal("get").then(Commands.argument("player", (ArgumentType)StringArgumentType.word()).executes(arguments -> {
/*     */                   FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                   if (entity == null && world instanceof ServerLevel) {
/*     */                     ServerLevel _servLevel = (ServerLevel)world;
/*     */                     fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                   } 
/*     */                   Direction direction = Direction.DOWN;
/*     */                   if (fakePlayer != null)
/*     */                     direction = fakePlayer.getDirection(); 
/*     */                   GetLinkedCommandProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                   return 0;
/* 119 */                 })))).then(Commands.literal("pair").then(Commands.argument("player1", (ArgumentType)StringArgumentType.word()).then(Commands.argument("player2", (ArgumentType)StringArgumentType.word()).executes(arguments -> {
/*     */                     FakePlayer fakePlayer; Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel(); double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                     double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                     double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                     Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                     if (entity == null && world instanceof ServerLevel) {
/*     */                       ServerLevel _servLevel = (ServerLevel)world;
/*     */                       fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                     } 
/*     */                     Direction direction = Direction.DOWN;
/*     */                     if (fakePlayer != null)
/*     */                       direction = fakePlayer.getDirection(); 
/*     */                     SetLinkedCommandProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                     return 0;
/* 133 */                   }))))).then(Commands.literal("set").then(Commands.argument("player", (ArgumentType)StringArgumentType.word()).then(Commands.argument("logic", (ArgumentType)BoolArgumentType.bool()).executes(arguments -> {
/*     */                     FakePlayer fakePlayer;
/*     */                     Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
/*     */                     double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
/*     */                     double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
/*     */                     double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
/*     */                     Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
/*     */                     if (entity == null && world instanceof ServerLevel) {
/*     */                       ServerLevel _servLevel = (ServerLevel)world;
/*     */                       fakePlayer = FakePlayerFactory.getMinecraft(_servLevel);
/*     */                     } 
/*     */                     Direction direction = Direction.DOWN;
/*     */                     if (fakePlayer != null)
/*     */                       direction = fakePlayer.getDirection(); 
/*     */                     ChangeLinkedStatusProcedure.execute((LevelAccessor)world, arguments, (Entity)fakePlayer);
/*     */                     return 0;
/*     */                   }))))));
/*     */   }
/*     */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\command\HeartsCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */