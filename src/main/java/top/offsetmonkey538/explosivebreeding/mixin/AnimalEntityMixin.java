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
        final AnimalEntity thisEntity = ((AnimalEntity) (Object) this);


        world.createExplosion(null, null, null, other.getPos(), (thisEntity.getHeight() + thisEntity.getWidth()) * 2, false, World.ExplosionSourceType.MOB);
    }
}
