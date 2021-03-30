package com.rutgerkloppenburg.api.RaspPiApi.app.screen;

import de.pi3g.pi.oled.Font;
import de.pi3g.pi.oled.OLEDDisplay;

public class Screen {

    OLEDDisplay oledScreen;

    public Screen() throws Exception{
        oledScreen = new OLEDDisplay();
        initialStartupMessage();
    }

    private void initialStartupMessage() throws Exception {
        writeTo("Raspberry PI RestFull API has started", Font.FONT_5X8, 25, 25);
        writeTo("Powered By Ilco Is Garbage Foundation", Font.FONT_5X8, 25, 50);
    }

    public void writeTo(String text, Font font, int posX, int posY) throws Exception{
        oledScreen.drawString(text, font, posX, posY, true);
        oledScreen.update();
    }

    public void clean(){
        oledScreen.clear();
    }


}
