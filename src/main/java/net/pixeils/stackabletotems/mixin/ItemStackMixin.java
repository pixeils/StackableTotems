package net.pixeils.stackabletotems.mixin;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void stackableTotems(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(64);
    }
}
