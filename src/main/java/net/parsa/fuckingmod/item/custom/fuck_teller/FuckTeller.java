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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FuckTeller extends Item {
    public FuckTeller(Settings settings) {
        super(settings);
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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown())
            tooltip.add(Text.literal("Right click for weird ass insults I got off merriam-webster").formatted(Formatting.YELLOW));
        else tooltip.add(Text.literal("Shift for more info cunt").formatted(Formatting.YELLOW));

        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputMessage(PlayerEntity user) {
        user.sendMessage(Text.literal(RandomFuckingMessage.getRandomFuckingMessage()));
    }


}
