package com.fuhu.particulatematter;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by sabrinakuo on 2016/3/31.
 */
public class SimpleLabel extends CustomedLabel {
    private int rowIndex = 0;
    private Color fontColor = null;

    public SimpleLabel(CharSequence text, TrueTypeFont fontName, int fontSize, Color color, float rowWidth, int rowIndex) {
        super(text, fontName, fontSize, color);
        this.rowIndex = rowIndex;
        this.fontColor = color;
        this.setWidth(rowWidth);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
}
