/*     */ package net.mcreator.klleyyshearts.network;
/*     */ 
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.network.protocol.PacketFlow;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.neoforged.neoforge.network.handling.IPayloadContext;
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
/*     */ public final class PlayerVariablesSyncMessage
/*     */   extends Record
/*     */   implements CustomPacketPayload
/*     */ {
/*     */   private final KlleyysHeartsModVariables.PlayerVariables data;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #115	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #115	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #115	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lnet/mcreator/klleyyshearts/network/KlleyysHeartsModVariables$PlayerVariablesSyncMessage;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*     */   
/*     */   public PlayerVariablesSyncMessage(KlleyysHeartsModVariables.PlayerVariables data) {
/* 115 */     this.data = data; } public KlleyysHeartsModVariables.PlayerVariables data() { return this.data; }
/* 116 */    public static final CustomPacketPayload.Type<PlayerVariablesSyncMessage> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath("klleyys_hearts", "player_variables_sync")); public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC;
/*     */   static {
/* 118 */     STREAM_CODEC = StreamCodec.of((buffer, message) -> buffer.writeNbt((Tag)message.data().serializeNBT((HolderLookup.Provider)buffer.registryAccess())), buffer -> {
/*     */           PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new KlleyysHeartsModVariables.PlayerVariables());
/*     */           message.data.deserializeNBT((HolderLookup.Provider)buffer.registryAccess(), buffer.readNbt());
/*     */           return message;
/*     */         });
/*     */   }
/*     */   
/*     */   public CustomPacketPayload.Type<PlayerVariablesSyncMessage> type() {
/* 126 */     return TYPE;
/*     */   }
/*     */   
/*     */   public static void handleData(PlayerVariablesSyncMessage message, IPayloadContext context) {
/* 130 */     if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null)
/* 131 */       context.enqueueWork(() -> ((KlleyysHeartsModVariables.PlayerVariables)context.player().getData(KlleyysHeartsModVariables.PLAYER_VARIABLES)).deserializeNBT((HolderLookup.Provider)context.player().registryAccess(), message.data.serializeNBT((HolderLookup.Provider)context.player().registryAccess()))).exceptionally(e -> {
/*     */             context.connection().disconnect((Component)Component.literal(e.getMessage()));
/*     */             return null;
/*     */           }); 
/*     */   }
/*     */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\network\KlleyysHeartsModVariables$PlayerVariablesSyncMessage.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */