package net.parsa.fuckingmod.item.custom.fuck_teller;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.parsa.fuckingmod.item.custom.base.FuckItemBase;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FuckTeller extends FuckItemBase {
    public FuckTeller(Settings settings) {
        super(settings, "Right click for weird ass insults I got off merriam-webster");
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            outputMessage(user);
            user.getItemCooldownManager().set(this, 10);
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    private void outputMessage(PlayerEntity user) {
        user.sendMessage(Text.literal(RandomFuckingMessage.getRandomFuckingMessage()));
    }


}
