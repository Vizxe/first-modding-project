package net.parsa.fuckingmod.item.custom.fuck_teller;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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

    private void outputMessage(PlayerEntity user) {
        user.sendMessage(Text.literal(RandomFuckingMessage.getRandomFuckingMessage()));
    }


}
