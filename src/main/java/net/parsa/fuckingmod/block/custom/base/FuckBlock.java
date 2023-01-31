package net.parsa.fuckingmod.block.custom.base;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FuckBlock extends Block {

    private final String onShiftDown;

    public FuckBlock(Settings settings, String onShiftDown) {
        super(settings);
        this.onShiftDown = onShiftDown;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if (Screen.hasShiftDown())
            tooltip.add(Text.literal(onShiftDown).formatted(Formatting.YELLOW));
        else tooltip.add(Text.literal("Shift for more info.").formatted(Formatting.YELLOW));


        super.appendTooltip(stack, world, tooltip, options);
    }
}
