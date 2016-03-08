package net.ecocraft.ecoearth.client.event;

import net.ecocraft.ecoearth.client.gui.GuiStreetView;
import net.ecocraft.ecoearth.client.gui.GuiTeleportPlace;
import net.ecocraft.ecoearth.client.key.EarthKeyBinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class ClientEventHandler {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent event) {
        if (EarthKeyBinds.key_streetview.isPressed()) {
            mc.displayGuiScreen(new GuiStreetView(mc.thePlayer));
        } else if (EarthKeyBinds.key_tp_place.isPressed()) {
            mc.displayGuiScreen(new GuiTeleportPlace());
        }
    }
}
