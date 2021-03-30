package com.rutgerkloppenburg.api.RaspPiApi.api.screen;

import com.google.gson.JsonObject;
import com.rutgerkloppenburg.api.RaspPiApi.RaspPiApiApplication;
import de.pi3g.pi.oled.Font;
import java.sql.Timestamp;
import java.util.Random;

public class Screen {

    private boolean clean;
    private String text;
    private String font;
    private Font textSize;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void setFont(String font) {
        this.font = font;
        if(font.equals("small") || font.equals("big")) {
            if ("small".equals(font)) {
                this.textSize = Font.FONT_4X5;
            } else {
                this.textSize = Font.FONT_5X8;
            }
        } else {
            Random random = new Random();
            int rand = random.nextInt(2);
            if (rand == 0) {
                this.textSize = Font.FONT_4X5;
            } else {
                this.textSize = Font.FONT_5X8;
            }
        }
    }

    public boolean isClean() {
        return clean;
    }

    public void setScreen() throws Exception {
        if (clean) {
            RaspPiApiApplication.app.screen.clean();
        }
        RaspPiApiApplication.app.screen.writeTo(getText(), this.textSize, 25, 25);
        saveScreenText();
    }

    private void saveScreenText(){
        JsonObject object = RaspPiApiApplication.app.fileWrapper.getFile("screen_history.json");
        JsonObject screen_history = new JsonObject();
        screen_history.addProperty("screen_text", this.getText());
        screen_history.addProperty("text_size", this.font);
        screen_history.addProperty("screen_cleaned", this.clean);
        object.add("" + new Timestamp(System.currentTimeMillis()).getTime(), screen_history);
        RaspPiApiApplication.app.fileWrapper.writeFile("screen_history.json", object);
    }
}
