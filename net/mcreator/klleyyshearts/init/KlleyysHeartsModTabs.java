/*    */ package net.mcreator.klleyyshearts.init;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.item.CreativeModeTab;
/*    */ import net.minecraft.world.item.CreativeModeTabs;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
/*    */ public class KlleyysHeartsModTabs
/*    */ {
/* 20 */   public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "klleyys_hearts");
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
/* 24 */     if (tabData.getTabKey() == CreativeModeTabs.COMBAT)
/* 25 */       tabData.accept((ItemLike)KlleyysHeartsModItems.SOUL_AMULET.get()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\elian\Desktop\klleyys_hearts-2.0.2 HOTFIX-neoforge-1.21.1(1).jar!\net\mcreator\klleyyshearts\init\KlleyysHeartsModTabs.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */