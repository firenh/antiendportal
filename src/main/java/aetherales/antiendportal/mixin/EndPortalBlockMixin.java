package aetherales.antiendportal.mixin;

import aetherales.antiendportal.AntiEndPortal;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.portal.TeleportTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndPortalBlock.class)
public class EndPortalBlockMixin {
	@Inject(at = @At("HEAD"), method = "getPortalDestination", cancellable = true)
	private void blockPortalTeleportation(ServerLevel currentLevel, Entity entity, BlockPos portalEntryPos, CallbackInfoReturnable<TeleportTransition> cir) {
		if (!currentLevel.getServer().getGameRules().get(AntiEndPortal.END_PORTAL_WORKS)) {
			cir.setReturnValue(null);
		}
	}
}