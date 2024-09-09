package net.shadowedleaves.tutorialmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.shadowedleaves.tutorialmod.TutorialMod;
import net.shadowedleaves.tutorialmod.entity.custom.PorcupineEntity;

public class PorcupineRenderer extends MobEntityRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/porcupine.png");

    public PorcupineRenderer(EntityRendererFactory.Context context) {
        super(context, new PorcupineModel<>(context.getPart(ModModelLayers.PORCUPINE)), 0.6f);
    }

    @Override
    public Identifier getTexture(PorcupineEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PorcupineEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
