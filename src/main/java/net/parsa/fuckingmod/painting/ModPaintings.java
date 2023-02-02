package net.parsa.fuckingmod.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.parsa.fuckingmod.FirstMod;

public class ModPaintings {

    public static final PaintingVariant DAWN_FUCK = registerPainting("dawnfuck", new PaintingVariant(32,16));
    public static final PaintingVariant HUH_FUCK = registerPainting("huhfuck", new PaintingVariant(16,16));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(FirstMod.MOD_ID, name), paintingVariant);
    }

    public static void registerModPaintings(){
        FirstMod.LOGGER.debug("Registering mod paintings for: " + FirstMod.MOD_ID);
    }


}
