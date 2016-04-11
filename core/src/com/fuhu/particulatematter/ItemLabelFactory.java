package com.fuhu.particulatematter;

/**
 * Created by sabrinakuo on 2016/3/31.
 */
public class ItemLabelFactory {

    public static SimpleLabel createLabel(String text, LabelStyle style, int index) {


        return new SimpleLabel(text, style.fontName, style.fontSize, style.color, style.rowWidth, index);
    }
}
