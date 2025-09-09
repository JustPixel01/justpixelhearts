/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*    */ import net.minecraft.commands.CommandSource;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.phys.Vec2;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class CombatJoinProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/* 27 */     execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity());
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
/* 31 */     execute(null, world, x, y, z, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
/* 35 */     if (entity == null)
/*    */       return; 
/* 37 */     if (0.0D < entity.getPersistentData().getDouble("combatTicks") && 
/* 38 */       world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world;
/* 39 */       _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kill " + entity
/* 40 */           .getDisplayName().getString()); }
/*    */     
/* 42 */     if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.USE_LINKED_HEARTS) && !getBlockNBTLogic(world, new BlockPos(21, -64, 21), entity.getDisplayName().getString()) && 0.0D == 
/* 43 */       getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()) && getBlockNBTLogic(world, new BlockPos(21, -64, 21), "#" + entity.getDisplayName().getString())) {
/* 44 */       if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world;
/* 45 */         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kick " + entity
/* 46 */             .getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }
/* 47 */        if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world;
/* 48 */         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "ban " + entity
/* 49 */             .getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }
/* 50 */        if (!world.isClientSide() && world.getServer() != null) {
/* 51 */         world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§ePlayer §5§l" + entity.getDisplayName().getString() + "§r§e's linked heart partner lost their linked heart. Since they didn't have any other hearts left they are out."), false);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
/* 57 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 58 */     if (blockEntity != null)
/* 59 */       return blockEntity.getPersistentData().getBoolean(tag); 
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 64 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 65 */     if (blockEntity != null)
/* 66 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 67 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\CombatJoinProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */