/*    */ package net.mcreator.klleyyshearts.client.screens;
/*    */ 
/*    */ import com.mojang.blaze3d.platform.GlStateManager;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.mcreator.klleyyshearts.procedures.IsGamemode0Procedure;
/*    */ import net.mcreator.klleyyshearts.procedures.IsHeartsLowerThan1Procedure;
/*    */ import net.mcreator.klleyyshearts.procedures.IsHeartsLowerThan2Procedure;
/*    */ import net.mcreator.klleyyshearts.procedures.IsHeartsLowerThan3Procedure;
/*    */ import net.mcreator.klleyyshearts.procedures.IsNotOnLinkedProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.IsOnLinkedProcedure;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.bus.api.EventPriority;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.client.event.RenderGuiEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber({Dist.CLIENT})
/*    */ public class HeartBarOverlay
/*    */ {
/*    */   @SubscribeEvent(priority = EventPriority.NORMAL)
/*    */   public static void eventHandler(RenderGuiEvent.Pre event) {
/* 32 */     int w = event.getGuiGraphics().guiWidth();
/* 33 */     int h = event.getGuiGraphics().guiHeight();
/* 34 */     Level world = null;
/* 35 */     double x = 0.0D;
/* 36 */     double y = 0.0D;
/* 37 */     double z = 0.0D;
/* 38 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/* 39 */     if (localPlayer != null) {
/* 40 */       world = localPlayer.level();
/* 41 */       x = localPlayer.getX();
/* 42 */       y = localPlayer.getY();
/* 43 */       z = localPlayer.getZ();
/*    */     } 
/* 45 */     RenderSystem.disableDepthTest();
/* 46 */     RenderSystem.depthMask(false);
/* 47 */     RenderSystem.enableBlend();
/* 48 */     RenderSystem.setShader(GameRenderer::getPositionTexShader);
/* 49 */     RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/* 50 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 51 */     if (IsGamemode0Procedure.execute((Entity)localPlayer)) {
/* 52 */       if (IsNotOnLinkedProcedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 53 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/blue_heart.png"), w / 2 + -8, h - 51, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 55 */       if (IsHeartsLowerThan3Procedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 56 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/gray_heart.png"), w / 2 + -8, h - 51, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 58 */       if (IsNotOnLinkedProcedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 59 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/blue_heart.png"), w / 2 + -12, h - 45, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 61 */       if (IsHeartsLowerThan2Procedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 62 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/gray_heart.png"), w / 2 + -13, h - 45, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 64 */       if (IsNotOnLinkedProcedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 65 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/blue_heart.png"), w / 2 + -3, h - 45, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 67 */       if (IsHeartsLowerThan1Procedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 68 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/gray_heart.png"), w / 2 + -3, h - 45, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/* 70 */       if (IsOnLinkedProcedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 71 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/linkedheart.png"), w / 2 + -8, h - 48, 0.0F, 0.0F, 16, 16, 16, 16);
/*    */       }
/*    */     } 
/* 74 */     RenderSystem.depthMask(true);
/* 75 */     RenderSystem.defaultBlendFunc();
/* 76 */     RenderSystem.enableDepthTest();
/* 77 */     RenderSystem.disableBlend();
/* 78 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\client\screens\HeartBarOverlay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */