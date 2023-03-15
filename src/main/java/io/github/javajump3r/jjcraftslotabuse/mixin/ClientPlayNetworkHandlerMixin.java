package io.github.javajump3r.jjcraftslotabuse.mixin;

import io.github.javajump3r.jjcraftslotabuse.CraftSlotAbuseInit;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
    public abstract class ClientPlayNetworkHandlerMixin
    {
        @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
        private void onPacketSend(Packet<?> packet, CallbackInfo ci) {
            if(CraftSlotAbuseInit.abuseEnabled())
            if(packet instanceof CloseHandledScreenC2SPacket) {
                if (((CloseHandledScreenC2SPacket) packet).getSyncId() == 0) {
                    ci.cancel();
                }
            }
        }
}
