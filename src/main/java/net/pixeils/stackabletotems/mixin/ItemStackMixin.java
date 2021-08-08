package net.pixeils.stackabletotems.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract boolean isOf(Item item);

    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void stackableTotems(CallbackInfoReturnable<Integer> cir) {
        if (this.isOf(Items.TOTEM_OF_UNDYING)){
            cir.setReturnValue(64);
        }
    }
}
