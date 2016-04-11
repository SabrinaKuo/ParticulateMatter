package com.fuhu.particulatematter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by sabrinakuo on 2016/3/30.
 */
public class ListView {

    protected String TAG = "ListView";
    private ArrayList<Boolean> mItemStatus = new ArrayList<Boolean>();
    private ArrayList<SimpleLabel> mList = new ArrayList<SimpleLabel>();
    private Vector2 startVector = new Vector2();
    private int mRows = 0;
    private float ROW_HIGHT;
    private ClickListener mClickListener = null;
    private ActorGestureListener mActorGestureListener = null;
    private ArrayList<String> mTitleList = new ArrayList<String>();

    public void setAdapter(ArrayList<String> list, LabelStyle style) {
        mTitleList = list;
        ROW_HIGHT = style.rowHight;

        for (int index = 0 ; index < list.size(); index++){
            SimpleLabel label = ItemLabelFactory.createLabel(list.get(index), style, index);
            Gdx.app.log(TAG, "mRows = " + mRows + ",text = " + list.get(index));
            mList.add(label);
            mItemStatus.add(false);
        }
//        setListener(actorGestureListener, true);
    }

    public ArrayList<SimpleLabel> getDragList() {
        return mList;
    }

    public void setDraggable(boolean isdraggable) {
        setListener(mDragListener, isdraggable);
    }

    public void setClickable(boolean isClickable) {
        if (mClickListener != null)
            setListener(mClickListener, isClickable);
    }

    private void setListener(EventListener listener, boolean enable){
        Iterator<SimpleLabel> iterator = mList.iterator();
        if (enable) {
            while(iterator.hasNext()){
                iterator.next().addListener(listener);
            }

        } else {
            while(iterator.hasNext()) {
                iterator.next().removeListener(listener);
            }

        }

    }

    public void setOnItemClickListener(ClickListener listener){
        mClickListener = listener;
        setListener(mClickListener, true);
    }

    public void setOnItemGestrueListener(ActorGestureListener listener) {
        mActorGestureListener = listener;
        setListener(mActorGestureListener, true);
    }

    private DragListener mDragListener = new DragListener(){

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            startVector.set(x, y);
            mRows = mList.size();
//            Gdx.app.log(TAG, "mRows = " + mRows);
            for (int i = 0; i < mRows; i++) {
                mItemStatus.set(i, false);
            }

            return super.touchDown(event, x, y, pointer, button);
        }

        @Override
        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            SimpleLabel actor = (SimpleLabel)event.getListenerActor();
            // limit actor only move y
            actor.moveBy(0, y - startVector.y);

            int index = actor.getRowIndex();
            int targetIndex = index;

            float limitUpArea = ROW_HIGHT * (mRows - index) + ROW_HIGHT / 2;
            float limitDownArea =  ROW_HIGHT * ((mRows - 1) - index) - ROW_HIGHT / 2;

            // item movable area
            if (actor.getY() < 0) {
                actor.setY(0);
            } else if (actor.getY() > ROW_HIGHT * (mRows -1)) {
                actor.setY(ROW_HIGHT * (mRows -1));
            }

            // item move direction
            if (actor.getY() + ROW_HIGHT > limitUpArea) {  // move up
                targetIndex = index - 1;
            } else if (actor.getY() < limitDownArea ) {  // move down
                targetIndex = index + 1;
            }

            // item move action
            if (targetIndex != index) {
                SimpleLabel exchangeActor = mList.get(targetIndex);

                if (!mItemStatus.get(targetIndex)) {
                    mItemStatus.set(targetIndex, true);
                    mItemStatus.set(index, false);

                    actor.setRowIndex(targetIndex);
                    exchangeActor.setRowIndex(index);
                    mList.set(targetIndex, actor);
                    mList.set(index, exchangeActor);

                    exchangeActor.setPosition(exchangeActor.getX(), ROW_HIGHT * ((mRows - 1) - index));
                }
            }

            super.touchDragged(event, x, y, pointer);
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            SimpleLabel actor = (SimpleLabel)event.getListenerActor();
            int rowIndex = actor.getRowIndex();

            actor.setY(ROW_HIGHT * ((mRows -1) - rowIndex));

            super.touchUp(event, x, y, pointer, button);
        }
    };

    private ActorGestureListener actorGestureListener = new ActorGestureListener() {
        @Override
        public boolean longPress(Actor actor, float x, float y) {
            Gdx.app.log(TAG, "longPress");
            return super.longPress(actor, x, y);
        }
    };

}
