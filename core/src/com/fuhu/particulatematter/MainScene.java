package com.fuhu.particulatematter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fuhu.gdx.scene.Scene;

import java.util.ArrayList;

/**
 * Created by SabrinaKuo on 2016/3/17.
 */
public class MainScene extends Scene {

    private final String TAG = "MainScene";
    private Table mScrollTable;
    private Table mContainTable;
    private PagedScrollPane mScrollPane;

    private ArrayList<SimpleLabel> mListItems = new ArrayList<SimpleLabel>();
    private int mRows = 0;
    private int ROW_HIGHT = 150;

    @Override
    public void enter() {

        createListTable();
    }

    public void createListTable() {

        /* scroll pane */
        mContainTable = new Table();
        mContainTable.left().top();
        mContainTable.setFillParent(true);
        mContainTable.debug();

        mScrollPane = new PagedScrollPane();
        mScrollTable = new Table();
        mScrollTable.debug();

        mListItems = createListItem();
        mRows = mListItems.size();

//        for(int i = 0; i < totalPage; i++) {
            for(int index = 0; index < mRows; index++){
                mScrollTable.add().width(getWorldWidth()).height(ROW_HIGHT).setActor(mListItems.get(index));
                mScrollTable.row();
            }
//        }

        mScrollTable.top();
        mScrollPane.addPage(mScrollTable);
        mScrollPane.setCancelTouchFocus(false);
//        mScrollPane.setFlickScroll(false);

//        mContainTable.add(mScrollTable).fill().expand(true, false);
        mContainTable.add(mScrollPane).fill().expand(true, false);
        getRootLayer().addActor(mContainTable);

    }

    public ArrayList<SimpleLabel> createListItem() {

        ArrayList<String> textList = new ArrayList<String>();
        for (int index = 0; index < 10; index++) {
            textList.add(Integer.toString(index));
        }

        ListView dragListView = new ListView();
        dragListView.setAdapter(textList, new LabelStyle(TrueTypeFont.HOUSE_A_RAMA_KINGPIN, 100, Color.WHITE, 150, 100));
        dragListView.setDraggable(true);

        return dragListView.getDragList();
    }

}
