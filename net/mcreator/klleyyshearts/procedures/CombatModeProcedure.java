/*    */ package net.mcreator.klleyyshearts.procedures;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.bus.api.Event;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class CombatModeProcedure
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onEntityAttacked(LivingDamageEvent.Post event) {
/* 25 */     if (event.getEntity() != null) {
/* 26 */       execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getSource(), (Entity)event.getEntity());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
/* 31 */     execute(null, world, damagesource, entity);
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
/*    */     // Byte code:
/*    */     //   0: aload_2
/*    */     //   1: ifnull -> 8
/*    */     //   4: aload_3
/*    */     //   5: ifnonnull -> 9
/*    */     //   8: return
/*    */     //   9: dconst_0
/*    */     //   10: dstore #4
/*    */     //   12: aload_2
/*    */     //   13: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   16: aload_3
/*    */     //   17: if_acmpeq -> 814
/*    */     //   20: aload_2
/*    */     //   21: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   24: instanceof net/minecraft/world/entity/player/Player
/*    */     //   27: ifeq -> 814
/*    */     //   30: aload_3
/*    */     //   31: instanceof net/minecraft/world/entity/player/Player
/*    */     //   34: ifeq -> 814
/*    */     //   37: aload_2
/*    */     //   38: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   41: astore #18
/*    */     //   43: aload #18
/*    */     //   45: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   48: ifeq -> 151
/*    */     //   51: aload #18
/*    */     //   53: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   56: astore #6
/*    */     //   58: aload #6
/*    */     //   60: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   63: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   66: aload #6
/*    */     //   68: instanceof net/minecraft/world/entity/player/Player
/*    */     //   71: ifeq -> 92
/*    */     //   74: aload #6
/*    */     //   76: checkcast net/minecraft/world/entity/player/Player
/*    */     //   79: astore #7
/*    */     //   81: aload #7
/*    */     //   83: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   86: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   89: goto -> 97
/*    */     //   92: aload #6
/*    */     //   94: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   97: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   100: ifnull -> 151
/*    */     //   103: aload #6
/*    */     //   105: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   108: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   111: aload #6
/*    */     //   113: instanceof net/minecraft/world/entity/player/Player
/*    */     //   116: ifeq -> 137
/*    */     //   119: aload #6
/*    */     //   121: checkcast net/minecraft/world/entity/player/Player
/*    */     //   124: astore #8
/*    */     //   126: aload #8
/*    */     //   128: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   131: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   134: goto -> 142
/*    */     //   137: aload #6
/*    */     //   139: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   142: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   145: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   148: goto -> 153
/*    */     //   151: ldc ''
/*    */     //   153: aload_3
/*    */     //   154: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   157: ifeq -> 259
/*    */     //   160: aload_3
/*    */     //   161: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   164: astore #9
/*    */     //   166: aload #9
/*    */     //   168: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   171: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   174: aload #9
/*    */     //   176: instanceof net/minecraft/world/entity/player/Player
/*    */     //   179: ifeq -> 200
/*    */     //   182: aload #9
/*    */     //   184: checkcast net/minecraft/world/entity/player/Player
/*    */     //   187: astore #10
/*    */     //   189: aload #10
/*    */     //   191: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   194: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   197: goto -> 205
/*    */     //   200: aload #9
/*    */     //   202: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   205: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   208: ifnull -> 259
/*    */     //   211: aload #9
/*    */     //   213: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   216: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   219: aload #9
/*    */     //   221: instanceof net/minecraft/world/entity/player/Player
/*    */     //   224: ifeq -> 245
/*    */     //   227: aload #9
/*    */     //   229: checkcast net/minecraft/world/entity/player/Player
/*    */     //   232: astore #11
/*    */     //   234: aload #11
/*    */     //   236: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   239: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   242: goto -> 250
/*    */     //   245: aload #9
/*    */     //   247: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   250: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   253: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   256: goto -> 261
/*    */     //   259: ldc ''
/*    */     //   261: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   264: ifeq -> 507
/*    */     //   267: aload_2
/*    */     //   268: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   271: astore #18
/*    */     //   273: aload #18
/*    */     //   275: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   278: ifeq -> 381
/*    */     //   281: aload #18
/*    */     //   283: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   286: astore #12
/*    */     //   288: aload #12
/*    */     //   290: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   293: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   296: aload #12
/*    */     //   298: instanceof net/minecraft/world/entity/player/Player
/*    */     //   301: ifeq -> 322
/*    */     //   304: aload #12
/*    */     //   306: checkcast net/minecraft/world/entity/player/Player
/*    */     //   309: astore #13
/*    */     //   311: aload #13
/*    */     //   313: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   316: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   319: goto -> 327
/*    */     //   322: aload #12
/*    */     //   324: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   327: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   330: ifnull -> 381
/*    */     //   333: aload #12
/*    */     //   335: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   338: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   341: aload #12
/*    */     //   343: instanceof net/minecraft/world/entity/player/Player
/*    */     //   346: ifeq -> 367
/*    */     //   349: aload #12
/*    */     //   351: checkcast net/minecraft/world/entity/player/Player
/*    */     //   354: astore #14
/*    */     //   356: aload #14
/*    */     //   358: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   361: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   364: goto -> 372
/*    */     //   367: aload #12
/*    */     //   369: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   372: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   375: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   378: goto -> 383
/*    */     //   381: ldc ''
/*    */     //   383: ldc ''
/*    */     //   385: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   388: ifeq -> 814
/*    */     //   391: aload_3
/*    */     //   392: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   395: ifeq -> 497
/*    */     //   398: aload_3
/*    */     //   399: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   402: astore #15
/*    */     //   404: aload #15
/*    */     //   406: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   409: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   412: aload #15
/*    */     //   414: instanceof net/minecraft/world/entity/player/Player
/*    */     //   417: ifeq -> 438
/*    */     //   420: aload #15
/*    */     //   422: checkcast net/minecraft/world/entity/player/Player
/*    */     //   425: astore #16
/*    */     //   427: aload #16
/*    */     //   429: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   432: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   435: goto -> 443
/*    */     //   438: aload #15
/*    */     //   440: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   443: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   446: ifnull -> 497
/*    */     //   449: aload #15
/*    */     //   451: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   454: invokevirtual getScoreboard : ()Lnet/minecraft/world/scores/Scoreboard;
/*    */     //   457: aload #15
/*    */     //   459: instanceof net/minecraft/world/entity/player/Player
/*    */     //   462: ifeq -> 483
/*    */     //   465: aload #15
/*    */     //   467: checkcast net/minecraft/world/entity/player/Player
/*    */     //   470: astore #17
/*    */     //   472: aload #17
/*    */     //   474: invokevirtual getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   477: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   480: goto -> 488
/*    */     //   483: aload #15
/*    */     //   485: invokevirtual getStringUUID : ()Ljava/lang/String;
/*    */     //   488: invokevirtual getPlayersTeam : (Ljava/lang/String;)Lnet/minecraft/world/scores/PlayerTeam;
/*    */     //   491: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   494: goto -> 499
/*    */     //   497: ldc ''
/*    */     //   499: ldc ''
/*    */     //   501: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   504: ifeq -> 814
/*    */     //   507: ldc2_w -1.0
/*    */     //   510: aload_3
/*    */     //   511: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*    */     //   514: ldc 'combatTicks'
/*    */     //   516: invokevirtual getDouble : (Ljava/lang/String;)D
/*    */     //   519: dcmpl
/*    */     //   520: ifeq -> 542
/*    */     //   523: ldc2_w -1.0
/*    */     //   526: aload_2
/*    */     //   527: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   530: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*    */     //   533: ldc 'combatTicks'
/*    */     //   535: invokevirtual getDouble : (Ljava/lang/String;)D
/*    */     //   538: dcmpl
/*    */     //   539: ifne -> 679
/*    */     //   542: aload_3
/*    */     //   543: instanceof net/minecraft/world/entity/player/Player
/*    */     //   546: ifeq -> 608
/*    */     //   549: aload_3
/*    */     //   550: checkcast net/minecraft/world/entity/player/Player
/*    */     //   553: astore #18
/*    */     //   555: aload #18
/*    */     //   557: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   560: invokevirtual isClientSide : ()Z
/*    */     //   563: ifne -> 608
/*    */     //   566: aload #18
/*    */     //   568: ldc 'msg.combatmode.1-1'
/*    */     //   570: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   573: invokevirtual getString : ()Ljava/lang/String;
/*    */     //   576: aload_2
/*    */     //   577: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   580: invokevirtual getDisplayName : ()Lnet/minecraft/network/chat/Component;
/*    */     //   583: invokeinterface getString : ()Ljava/lang/String;
/*    */     //   588: ldc 'msg.combatmode.1-2'
/*    */     //   590: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   593: invokevirtual getString : ()Ljava/lang/String;
/*    */     //   596: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*    */     //   601: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   604: iconst_0
/*    */     //   605: invokevirtual displayClientMessage : (Lnet/minecraft/network/chat/Component;Z)V
/*    */     //   608: aload_2
/*    */     //   609: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   612: astore #19
/*    */     //   614: aload #19
/*    */     //   616: instanceof net/minecraft/world/entity/player/Player
/*    */     //   619: ifeq -> 679
/*    */     //   622: aload #19
/*    */     //   624: checkcast net/minecraft/world/entity/player/Player
/*    */     //   627: astore #18
/*    */     //   629: aload #18
/*    */     //   631: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*    */     //   634: invokevirtual isClientSide : ()Z
/*    */     //   637: ifne -> 679
/*    */     //   640: aload #18
/*    */     //   642: ldc 'msg.combatmode.1-3'
/*    */     //   644: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   647: invokevirtual getString : ()Ljava/lang/String;
/*    */     //   650: aload_3
/*    */     //   651: invokevirtual getDisplayName : ()Lnet/minecraft/network/chat/Component;
/*    */     //   654: invokeinterface getString : ()Ljava/lang/String;
/*    */     //   659: ldc 'msg.combatmode.1-2'
/*    */     //   661: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   664: invokevirtual getString : ()Ljava/lang/String;
/*    */     //   667: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*    */     //   672: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*    */     //   675: iconst_0
/*    */     //   676: invokevirtual displayClientMessage : (Lnet/minecraft/network/chat/Component;Z)V
/*    */     //   679: aload_3
/*    */     //   680: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*    */     //   683: ldc 'combatTicks'
/*    */     //   685: ldc2_w 600.0
/*    */     //   688: invokevirtual putDouble : (Ljava/lang/String;D)V
/*    */     //   691: aload_2
/*    */     //   692: invokevirtual getEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   695: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*    */     //   698: ldc 'combatTicks'
/*    */     //   700: ldc2_w 600.0
/*    */     //   703: invokevirtual putDouble : (Ljava/lang/String;D)V
/*    */     //   706: aload_1
/*    */     //   707: invokeinterface isClientSide : ()Z
/*    */     //   712: ifne -> 814
/*    */     //   715: new net/minecraft/core/BlockPos
/*    */     //   718: dup
/*    */     //   719: bipush #21
/*    */     //   721: bipush #-64
/*    */     //   723: bipush #21
/*    */     //   725: invokespecial <init> : (III)V
/*    */     //   728: astore #18
/*    */     //   730: aload_1
/*    */     //   731: aload #18
/*    */     //   733: invokeinterface getBlockEntity : (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;
/*    */     //   738: astore #19
/*    */     //   740: aload_1
/*    */     //   741: aload #18
/*    */     //   743: invokeinterface getBlockState : (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;
/*    */     //   748: astore #20
/*    */     //   750: aload #19
/*    */     //   752: ifnull -> 789
/*    */     //   755: aload #19
/*    */     //   757: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*    */     //   760: aload_3
/*    */     //   761: invokevirtual getDisplayName : ()Lnet/minecraft/network/chat/Component;
/*    */     //   764: invokeinterface getString : ()Ljava/lang/String;
/*    */     //   769: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   774: aload_2
/*    */     //   775: invokevirtual getDirectEntity : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   778: invokevirtual getDisplayName : ()Lnet/minecraft/network/chat/Component;
/*    */     //   781: invokeinterface getString : ()Ljava/lang/String;
/*    */     //   786: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
/*    */     //   789: aload_1
/*    */     //   790: instanceof net/minecraft/world/level/Level
/*    */     //   793: ifeq -> 814
/*    */     //   796: aload_1
/*    */     //   797: checkcast net/minecraft/world/level/Level
/*    */     //   800: astore #21
/*    */     //   802: aload #21
/*    */     //   804: aload #18
/*    */     //   806: aload #20
/*    */     //   808: aload #20
/*    */     //   810: iconst_3
/*    */     //   811: invokevirtual sendBlockUpdated : (Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;I)V
/*    */     //   814: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #35	-> 0
/*    */     //   #36	-> 8
/*    */     //   #37	-> 9
/*    */     //   #38	-> 12
/*    */     //   #39	-> 37
/*    */     //   #40	-> 103
/*    */     //   #41	-> 151
/*    */     //   #42	-> 153
/*    */     //   #43	-> 211
/*    */     //   #44	-> 259
/*    */     //   #42	-> 261
/*    */     //   #45	-> 267
/*    */     //   #46	-> 333
/*    */     //   #47	-> 381
/*    */     //   #48	-> 391
/*    */     //   #49	-> 449
/*    */     //   #50	-> 497
/*    */     //   #51	-> 507
/*    */     //   #52	-> 542
/*    */     //   #53	-> 566
/*    */     //   #55	-> 608
/*    */     //   #56	-> 640
/*    */     //   #58	-> 679
/*    */     //   #59	-> 691
/*    */     //   #60	-> 706
/*    */     //   #61	-> 715
/*    */     //   #62	-> 730
/*    */     //   #63	-> 740
/*    */     //   #64	-> 750
/*    */     //   #65	-> 755
/*    */     //   #66	-> 789
/*    */     //   #67	-> 802
/*    */     //   #70	-> 814
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   81	11	7	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   126	11	8	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   58	93	6	_teamEnt	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   189	11	10	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   234	11	11	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   166	93	9	_teamEnt	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   311	11	13	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   356	11	14	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   288	93	12	_teamEnt	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   427	11	16	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   472	11	17	_pl	Lnet/minecraft/world/entity/player/Player;
/*    */     //   404	93	15	_teamEnt	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   555	53	18	_player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   629	50	18	_player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   802	12	21	_level	Lnet/minecraft/world/level/Level;
/*    */     //   730	84	18	_bp	Lnet/minecraft/core/BlockPos;
/*    */     //   740	74	19	_blockEntity	Lnet/minecraft/world/level/block/entity/BlockEntity;
/*    */     //   750	64	20	_bs	Lnet/minecraft/world/level/block/state/BlockState;
/*    */     //   0	815	0	event	Lnet/neoforged/bus/api/Event;
/*    */     //   0	815	1	world	Lnet/minecraft/world/level/LevelAccessor;
/*    */     //   0	815	2	damagesource	Lnet/minecraft/world/damagesource/DamageSource;
/*    */     //   0	815	3	entity	Lnet/minecraft/world/entity/Entity;
/*    */     //   12	803	4	ticks	D
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\procedures\CombatModeProcedure.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */