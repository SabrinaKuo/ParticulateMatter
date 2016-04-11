package com.fuhu.particulatematter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.fuhu.gdx.scene.Scene;

/**
 * Created by sabrinakuo on 2016/3/31.
 */
public class LabelStyle {

    public TrueTypeFont fontName = TrueTypeFont.HOUSE_A_RAMA_KINGPIN;
    public int fontSize = 50;
    public Color color = Color.WHITE;
    public float rowWidth = Gdx.app.getGraphics().getWidth();
    public float rowHight = 150;

    public LabelStyle(TrueTypeFont fontName, int fontSize, Color color, float rowHight, float rowWidth){
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.color = color;
        this.rowWidth = rowWidth;
        this.rowHight = rowHight;
    }

    public TrueTypeFont getFont() {
        return fontName;
    }

    public void setFont(TrueTypeFont fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getRowHight() {
        return rowHight;
    }

    public void setRowHight(float rowHight) {
        this.rowHight = rowHight;
    }

    public float getWidth() {
        return rowWidth;
    }

    public void setWidth(float rowWidth) {
        this.rowWidth = rowWidth;
    }
}
