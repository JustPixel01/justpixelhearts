/*    */ package net.mcreator.klleyyshearts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentLinkedQueue;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModBlockEntities;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModBlocks;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModItems;
/*    */ import net.mcreator.klleyyshearts.init.KlleyysHeartsModTabs;
/*    */ import net.mcreator.klleyyshearts.network.KlleyysHeartsModVariables;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.util.Tuple;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.Mod;
/*    */ import net.neoforged.fml.util.thread.SidedThreadGroups;
/*    */ import net.neoforged.neoforge.common.NeoForge;
/*    */ import net.neoforged.neoforge.event.tick.ServerTickEvent;
/*    */ import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadHandler;
/*    */ import net.neoforged.neoforge.network.registration.PayloadRegistrar;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod("klleyys_hearts")
/*    */ public class KlleyysHeartsMod
/*    */ {
/* 36 */   public static final Logger LOGGER = LogManager.getLogger(KlleyysHeartsMod.class);
/*    */   
/*    */   public static final String MODID = "klleyys_hearts";
/*    */ 
/*    */   
/*    */   public KlleyysHeartsMod(IEventBus modEventBus) {
/* 42 */     NeoForge.EVENT_BUS.register(this);
/* 43 */     modEventBus.addListener(this::registerNetworking);
/*    */     
/* 45 */     KlleyysHeartsModBlocks.REGISTRY.register(modEventBus);
/* 46 */     KlleyysHeartsModBlockEntities.REGISTRY.register(modEventBus);
/* 47 */     KlleyysHeartsModItems.REGISTRY.register(modEventBus);
/*    */     
/* 49 */     KlleyysHeartsModTabs.REGISTRY.register(modEventBus);
/* 50 */     KlleyysHeartsModVariables.ATTACHMENT_TYPES.register(modEventBus);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean networkingRegistered = false;
/*    */ 
/*    */   
/* 59 */   private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();
/*    */   private static final class NetworkMessage<T extends CustomPacketPayload> extends Record { private final StreamCodec<? extends FriendlyByteBuf, T> reader; private final IPayloadHandler<T> handler;
/* 61 */     private NetworkMessage(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) { this.reader = reader; this.handler = handler; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #61	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */       // Local variable type table:
/*    */       //   start	length	slot	name	signature
/* 61 */       //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>; } public StreamCodec<? extends FriendlyByteBuf, T> reader() { return this.reader; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #61	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */       // Local variable type table:
/*    */       //   start	length	slot	name	signature
/*    */       //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #61	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */       //   0	8	1	o	Ljava/lang/Object;
/*    */       // Local variable type table:
/*    */       //   start	length	slot	name	signature
/* 61 */       //   0	8	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>; } public IPayloadHandler<T> handler() { return this.handler; }
/*    */      }
/*    */   
/*    */   public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
/* 65 */     if (networkingRegistered)
/* 66 */       throw new IllegalStateException("Cannot register new network messages after networking has been registered"); 
/* 67 */     MESSAGES.put(id, new NetworkMessage(reader, handler));
/*    */   }
/*    */ 
/*    */   
/*    */   private void registerNetworking(RegisterPayloadHandlersEvent event) {
/* 72 */     PayloadRegistrar registrar = event.registrar("klleyys_hearts");
/* 73 */     MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, networkMessage.reader(), networkMessage.handler()));
/* 74 */     networkingRegistered = true;
/*    */   }
/*    */   
/* 77 */   private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
/*    */   
/*    */   public static void queueServerWork(int tick, Runnable action) {
/* 80 */     if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
/* 81 */       workQueue.add(new Tuple(action, Integer.valueOf(tick))); 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void tick(ServerTickEvent.Post event) {
/* 86 */     List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
/* 87 */     workQueue.forEach(work -> {
/*    */           work.setB(Integer.valueOf(((Integer)work.getB()).intValue() - 1));
/*    */           if (((Integer)work.getB()).intValue() == 0)
/*    */             actions.add(work); 
/*    */         });
/* 92 */     actions.forEach(e -> ((Runnable)e.getA()).run());
/* 93 */     workQueue.removeAll(actions);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\KlleyysHeartsMod.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */