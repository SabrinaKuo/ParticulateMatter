package com.fuhu.particulatematter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by sabrinakuo on 2016/3/17.
 */
public class CustomedLabel extends Label {
    public final static Color DIALOG_TEXT_COLOR = new Color(63 / 255f, 168 / 255f, 244 / 255f, 1f);

    public CustomedLabel(CharSequence text, TrueTypeFont fontName, int fontSize, Color color) {
        super(text, getStyle(fontName, fontSize, color));

        // using setScale instead of creating new font
        this.setFontScale((float) fontSize / (float) getFontSizeBase(fontSize));
        this.getStyle().font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static LabelStyle getStyle(TrueTypeFont fontName, int fontSize, Color color) {
        return new LabelStyle(createBitmapFont(fontName.getFileHandle(), color, fontSize), color);
    }

    public static BitmapFont createBitmapFont(FileHandle ttfFileName, Color color, int textSize) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(ttfFileName);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = textSize;
        BitmapFont bitmapFont = generator.generateFont(parameter);
        bitmapFont.setColor(color);
        generator.dispose();
        Array regions = bitmapFont.getRegions();
        Iterator var8 = regions.iterator();

        while(var8.hasNext()) {
            TextureRegion region = (TextureRegion)var8.next();
            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        return bitmapFont;
    }

    public void changeFontSize(int fontSize) {
        this.setFontScale((float) fontSize / (float) getFontSizeBase(fontSize));
        this.getStyle().font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static int getFontSizeBase(int fontSize) {
        int fontSizeBase = 0;
        if (fontSize > 100) {
            fontSizeBase = 130;
        } else if (fontSize > 70 && fontSize <= 100) {
            fontSizeBase = 85;
        } else if (fontSize > 40 && fontSize <= 70) {
            fontSizeBase = 55;
        } else if (fontSize <= 40) {
            fontSizeBase = 35;
        }

        return fontSizeBase;
    }
}
