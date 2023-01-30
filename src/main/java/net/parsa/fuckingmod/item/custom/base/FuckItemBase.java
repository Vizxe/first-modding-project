package net.parsa.fuckingmod.item.custom.base;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FuckItemBase extends Item {
    private final String onShiftDown;

    public FuckItemBase(Settings settings, String onShiftDown) {
        super(settings);
        this.onShiftDown = onShiftDown;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown())
            tooltip.add(Text.literal(onShiftDown).formatted(Formatting.YELLOW));
        else tooltip.add(Text.literal("Shift for more info.").formatted(Formatting.YELLOW));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
