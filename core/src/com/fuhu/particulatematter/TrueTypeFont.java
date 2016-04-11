package com.fuhu.particulatematter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by sabrinakuo on 2016/3/17.
 */
public enum TrueTypeFont {
    HOUSE_A_RAMA_KINGPIN(Gdx.files.internal("fonts/" + "house-a-rama-kingpin.ttf")),
    ROBOTO_BLACK(Gdx.files.internal("fonts/" + "Roboto-Black.ttf")),
    ROBOTO_BOLD(Gdx.files.internal("fonts/" + "Roboto-Bold.ttf")),
    ROBOTO_MEDIUM(Gdx.files.internal("fonts/" + "Roboto-Medium.ttf")),
    ROBOTO_REGULAR(Gdx.files.internal("fonts/" + "Roboto-Regular.ttf"));

    public FileHandle fileHandle;

    TrueTypeFont(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}
