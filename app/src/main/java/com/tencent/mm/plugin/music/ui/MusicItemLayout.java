package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector lVX;

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.lVX = new GestureDetector(getContext(), new a(this, (byte) 0));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b$a com_tencent_mm_plugin_music_ui_b_a = (b$a) getTag();
        if (!com_tencent_mm_plugin_music_ui_b_a.beH()) {
            Object obj;
            if (com_tencent_mm_plugin_music_ui_b_a.oNw.getX() <= motionEvent.getX() && motionEvent.getX() <= com_tencent_mm_plugin_music_ui_b_a.oNw.getX() + ((float) com_tencent_mm_plugin_music_ui_b_a.oNw.getMeasuredWidth()) && com_tencent_mm_plugin_music_ui_b_a.oNw.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) com_tencent_mm_plugin_music_ui_b_a.oNw.getMeasuredHeight()) + com_tencent_mm_plugin_music_ui_b_a.oNw.getY()) {
                    obj = 1;
                    if (obj == null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.lVX.onTouchEvent(motionEvent);
        return true;
    }
}
