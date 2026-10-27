package aetherales.antiendportal.mixin;

import aetherales.antiendportal.AntiEndPortal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.EnderEyeItem;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public class EnderEyeItemMixin {
    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private static void blockFillingPortal(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (context.getLevel() instanceof ServerLevel serverLevel && !serverLevel.getGameRules().get(AntiEndPortal.END_PORTAL_WORKS)) {
            cir.setReturnValue(InteractionResult.FAIL);
        }
    }
}
