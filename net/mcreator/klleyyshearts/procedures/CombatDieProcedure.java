/*     */ package net.mcreator.klleyyshearts.procedures;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.annotation.Nullable;
/*     */ import net.mcreator.klleyyshearts.KlleyysHeartsMod;
/*     */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModGameRules;
/*     */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModItems;
/*     */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*     */ import net.minecraft.advancements.AdvancementHolder;
/*     */ import net.minecraft.advancements.AdvancementProgress;
/*     */ import net.minecraft.commands.CommandSource;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.GameRules;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.neoforged.bus.api.Event;
/*     */ import net.neoforged.bus.api.SubscribeEvent;
/*     */ import net.neoforged.fml.common.EventBusSubscriber;
/*     */ import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class CombatDieProcedure
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEntityDeath(LivingDeathEvent event) {
/*  41 */     if (event.getEntity() != null) {
/*  42 */       execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
/*  47 */     execute(null, world, x, y, z, entity);
/*     */   }
/*     */   
/*     */   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
/*  51 */     if (entity == null)
/*     */       return; 
/*  53 */     if (entity instanceof Player) {
/*  54 */       if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SHOW_DEATH_SCREEN)) {
/*  55 */         ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DO_IMMEDIATE_RESPAWN)).set(true, world.getServer());
/*     */       }
/*  57 */       Player _playerHasItem = (Player)entity; if (-1.0D == entity.getPersistentData().getDouble("combatTicks") || (entity instanceof Player && _playerHasItem.getInventory().contains(new ItemStack((ItemLike)KlleyysHeartsModItems.SOUL_AMULET.get()))))
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 164 */         Player player = (Player)entity; if (entity instanceof Player && player.getInventory().contains(new ItemStack((ItemLike)KlleyysHeartsModItems.SOUL_AMULET.get())))
/* 165 */           if (-1.0D != entity.getPersistentData().getDouble("combatTicks"))
/* 166 */           { if (!world.isClientSide() && world.getServer() != null)
/* 167 */               world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("msg.combatdie.2-1").getString() + Component.translatable("msg.combatdie.2-1").getString() + entity.getDisplayName().getString() + "$" + 
/* 168 */                     Component.translatable(" §r§edied in a fight with §5§l").getString() + "§r§e. §4§lSaved by Soul Amulet!"), false); 
/* 169 */             if (entity instanceof ServerPlayer) { ServerPlayer _player = (ServerPlayer)entity;
/* 170 */               AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("klleyys_hearts:use_soul_amulet_advancement"));
/* 171 */               if (_adv != null) {
/* 172 */                 AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
/* 173 */                 if (!_ap.isDone())
/* 174 */                   for (String criteria : _ap.getRemainingCriteria()) {
/* 175 */                     _player.getAdvancements().award(_adv, criteria);
/*     */                   } 
/*     */               }  }
/*     */              }
/* 179 */           else if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.SEND_SOUL_AMULET_INFORMATION) && 
/* 180 */             !world.isClientSide() && world.getServer() != null)
/* 181 */           { world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§ePlayer §5§l" + entity.getDisplayName().getString() + " §r§elost the §4§lSOUL AMULET §r§eduring death at §5§l" + 
/* 182 */                   Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + "§r§e."), false); }   } else { if (!world.isClientSide() && world.getServer() != null) world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("msg.combatdie.1-1").getString() + Component.translatable("msg.combatdie.1-1").getString() + entity.getDisplayName().getString() + Component.translatable("msg.combatdie.1-2").getString() + " §4§l(-1 HEART)"), false);  if (!world.isClientSide()) { BlockPos _bp = new BlockPos(21, -64, 21); BlockEntity _blockEntity = world.getBlockEntity(_bp); BlockState _bs = world.getBlockState(_bp); if (_blockEntity != null) _blockEntity.getPersistentData().putDouble("?" + entity.getDisplayName().getString(), getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString()) - 1.0D);  if (world instanceof Level) { Level _level = (Level)world; _level.sendBlockUpdated(_bp, _bs, _bs, 3); }  }  entity.getPersistentData().putDouble("combatTicks", 0.0D); if (0.0D == getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString())) { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.USE_LINKED_HEARTS)) { if (!getBlockNBTLogic(world, new BlockPos(21, -64, 21), "!" + entity.getDisplayName().getString())) { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.BAN_IF_NO_HEARTS)) { if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kick " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "ban " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  KlleyysHeartsMod.LOGGER.info("1Klleyy's Hearts >> Banned player (lost all hearts). Disable this by entering /gamerule BanIfNoHearts false"); }  if (!world.isClientSide() && world.getServer() != null) world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("msg.combatdie.2-1").getString() + Component.translatable("msg.combatdie.2-1").getString() + entity.getDisplayName().getString()), false);  } else { if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eYour linked heart partner is: §5§l" + getBlockNBTString(world, new BlockPos(21, -64, 21), entity.getDisplayName().getString()) + "§r§e."), false);  }  if (entity instanceof Player) { Player _player = (Player)entity; if (!_player.level().isClientSide()) _player.displayClientMessage((Component)Component.literal("§4§lKlleyy's Hearts >> §r§eYour linked heart partner is: §5§l" + getBlockNBTString(world, new BlockPos(21, -64, 21), entity.getDisplayName().getString()) + "§r§e."), true);  }  }  } else { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.BAN_IF_NO_HEARTS)) { if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kick " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "ban " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  KlleyysHeartsMod.LOGGER.info("2Klleyy's Hearts >> Banned player (lost all hearts). Disable this by entering /gamerule BanIfNoHearts false"); }  if (!world.isClientSide() && world.getServer() != null) world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("msg.combatdie.2-1").getString() + Component.translatable("msg.combatdie.2-1").getString() + entity.getDisplayName().getString()), false);  }  } else if (-1.0D == getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString())) { if (world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.BAN_IF_NO_HEARTS)) { if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kick " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "ban " + entity.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  KlleyysHeartsMod.LOGGER.info("3Klleyy's Hearts >> Banned player (lost all hearts). Disable this by entering /gamerule BanIfNoHearts false"); }  if (!world.isClientSide() && world.getServer() != null)
/*     */             world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("msg.combatdie.2-1").getString() + Component.translatable("msg.combatdie.2-1").getString() + entity.getDisplayName().getString()), false);  if (!world.isClientSide()) { BlockPos _bp = new BlockPos(21, -64, 21); BlockEntity _blockEntity = world.getBlockEntity(_bp); BlockState _bs = world.getBlockState(_bp); if (_blockEntity != null)
/*     */               _blockEntity.getPersistentData().putBoolean("!" + entity.getDisplayName().getString(), false);  if (world instanceof Level) { Level _level = (Level)world; _level.sendBlockUpdated(_bp, _bs, _bs, 3); }  }  if (!world.isClientSide()) { BlockPos _bp = new BlockPos(21, -64, 21); BlockEntity _blockEntity = world.getBlockEntity(_bp); BlockState _bs = world.getBlockState(_bp); if (_blockEntity != null)
/*     */               _blockEntity.getPersistentData().putBoolean("!" + getBlockNBTString(world, new BlockPos(21, -64, 21), entity.getDisplayName().getString()), false);  if (world instanceof Level) { Level level = (Level)world; level.sendBlockUpdated(_bp, _bs, _bs, 3); }  }  for (Entity entityiterator : new ArrayList(world.players())) { if (getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entityiterator.getDisplayName().getString()) == 0.0D && entityiterator.getDisplayName().getString().equals(getBlockNBTString(world, new BlockPos(21, -64, 21), entity.getDisplayName().getString())) && world.getLevelData().getGameRules().getBoolean(KlleyysHeartsModGameRules.BAN_IF_NO_HEARTS)) { if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "kick " + entityiterator.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  if (world instanceof ServerLevel) { ServerLevel _level = (ServerLevel)world; _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "ban " + entityiterator.getDisplayName().getString() + " §4§lKlleyy's Hearts >> §r§eLost all hearts!"); }  if (!world.isClientSide() && world.getServer() != null)
/* 186 */                 world.getServer().getPlayerList().broadcastSystemMessage((Component)Component.literal(Component.translatable("§4§lKlleyy's Hearts >> §r§ePlayer §5§l").getString() + Component.translatable("§4§lKlleyy's Hearts >> §r§ePlayer §5§l").getString() + entityiterator.getDisplayName().getString()), false);  }  }  }  DebugprocProcedure.execute(world, entity); }  KlleyysHeartsModVariables.PlayerVariables _vars = (KlleyysHeartsModVariables.PlayerVariables)entity.getData(KlleyysHeartsModVariables.PLAYER_VARIABLES);
/* 187 */       _vars.hearts = getBlockNBTNumber(world, new BlockPos(21, -64, 21), "?" + entity.getDisplayName().getString());
/* 188 */       _vars.syncPlayerVariables(entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
/* 194 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 195 */     if (blockEntity != null)
/* 196 */       return blockEntity.getPersistentData().getString(tag); 
/* 197 */     return "";
/*     */   }
/*     */   
/*     */   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
/* 201 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 202 */     if (blockEntity != null)
/* 203 */       return blockEntity.getPersistentData().getDouble(tag); 
/* 204 */     return -1.0D;
/*     */   }
/*     */   
/*     */   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
/* 208 */     BlockEntity blockEntity = world.getBlockEntity(pos);
/* 209 */     if (blockEntity != null)
/* 210 */       return blockEntity.getPersistentData().getBoolean(tag); 
/* 211 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\CombatDieProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */