/*    */ package net.mcreator.klleyyshearts.client.screens;
/*    */ 
/*    */ import com.mojang.blaze3d.platform.GlStateManager;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.mcreator.klleyyshearts.procedures.AnimationFrameCounterProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldAnimationShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp1ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp2ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp3ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp4ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp5ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp6ShowProcedure;
/*    */ import net.mcreator.klleyyshearts.procedures.ShouldSp7ShowProcedure;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
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
/*    */ public class AnimationOverlayOverlay
/*    */ {
/*    */   @SubscribeEvent(priority = EventPriority.HIGHEST)
/*    */   public static void eventHandler(RenderGuiEvent.Pre event) {
/* 36 */     int w = event.getGuiGraphics().guiWidth();
/* 37 */     int h = event.getGuiGraphics().guiHeight();
/* 38 */     Level world = null;
/* 39 */     double x = 0.0D;
/* 40 */     double y = 0.0D;
/* 41 */     double z = 0.0D;
/* 42 */     LocalPlayer localPlayer = (Minecraft.getInstance()).player;
/* 43 */     if (localPlayer != null) {
/* 44 */       world = localPlayer.level();
/* 45 */       x = localPlayer.getX();
/* 46 */       y = localPlayer.getY();
/* 47 */       z = localPlayer.getZ();
/*    */     } 
/* 49 */     RenderSystem.disableDepthTest();
/* 50 */     RenderSystem.depthMask(false);
/* 51 */     RenderSystem.enableBlend();
/* 52 */     RenderSystem.setShader(GameRenderer::getPositionTexShader);
/* 53 */     RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/* 54 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 55 */     if (ShouldAnimationShowProcedure.execute((LevelAccessor)world, (Entity)localPlayer)) {
/* 56 */       event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/animation_background.png"), 0, 0, 0.0F, 0.0F, w, h, w, h);
/* 57 */       if (ShouldSp1ShowProcedure.execute((Entity)localPlayer)) {
/* 58 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_1.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 61 */       if (ShouldSp2ShowProcedure.execute((Entity)localPlayer)) {
/* 62 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_2.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 65 */       if (ShouldSp3ShowProcedure.execute((Entity)localPlayer)) {
/* 66 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_3.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 69 */       if (ShouldSp4ShowProcedure.execute((Entity)localPlayer)) {
/* 70 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_4.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 73 */       if (ShouldSp5ShowProcedure.execute((Entity)localPlayer)) {
/* 74 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_5.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 77 */       if (ShouldSp6ShowProcedure.execute((Entity)localPlayer)) {
/* 78 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_6.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */       
/* 81 */       if (ShouldSp7ShowProcedure.execute((Entity)localPlayer)) {
/* 82 */         event.getGuiGraphics().blit(ResourceLocation.parse("klleyys_hearts:textures/screens/spritenew1_7.png"), w / 2 + -320, h / 2 + -173, Mth.clamp((int)AnimationFrameCounterProcedure.execute((Entity)localPlayer) * 641, 0, 7051), 0.0F, 641, 361, 7692, 361);
/*    */       }
/*    */     } 
/*    */     
/* 86 */     RenderSystem.depthMask(true);
/* 87 */     RenderSystem.defaultBlendFunc();
/* 88 */     RenderSystem.enableDepthTest();
/* 89 */     RenderSystem.disableBlend();
/* 90 */     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\client\screens\AnimationOverlayOverlay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */