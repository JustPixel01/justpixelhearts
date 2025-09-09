/*    */ package net.mcreator.klleyyshearts;
/*    */ 
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class NetworkMessage<T extends CustomPacketPayload>
/*    */   extends Record
/*    */ {
/*    */   private final StreamCodec<? extends FriendlyByteBuf, T> reader;
/*    */   private final IPayloadHandler<T> handler;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #61	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #61	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #61	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	8	0	this	Lnet/mcreator/klleyyshearts/KlleyysHeartsMod$NetworkMessage<TT;>;
/*    */   }
/*    */   
/*    */   private NetworkMessage(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
/* 61 */     this.reader = reader; this.handler = handler; } public StreamCodec<? extends FriendlyByteBuf, T> reader() { return this.reader; } public IPayloadHandler<T> handler() { return this.handler; }
/*    */ 
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\KlleyysHeartsMod$NetworkMessage.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */