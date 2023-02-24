package top.offsetmonkey538.explosivebreeding.mixin;

import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin {

    @Inject(
            at = @At("HEAD"),
            method = "breed"
    )
    private void explosivebreeding$makeBredAnimalsExplode(ServerWorld world, AnimalEntity other, CallbackInfo ci) {
        world.createExplosion(null, null, null, other.getPos(), 4, false, World.ExplosionSourceType.MOB);
    }
}
