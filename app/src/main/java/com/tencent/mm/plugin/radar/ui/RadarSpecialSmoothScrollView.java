package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import b.c.b.e;

public class RadarSpecialSmoothScrollView extends ScrollView {
    private final Rect fD = new Rect();
    private RadarSpecialTableLayout pyD;
    private TranslateAnimation pyE;
    private final a pyF = new a();
    private float zb;

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (!(childAt instanceof RadarSpecialTableLayout)) {
                childAt = null;
            }
            this.pyD = (RadarSpecialTableLayout) childAt;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        e.i(motionEvent, "ev");
        if (this.pyD == null) {
            return super.onTouchEvent(motionEvent);
        }
        RadarSpecialTableLayout radarSpecialTableLayout;
        switch (motionEvent.getAction()) {
            case 0:
                this.zb = motionEvent.getY();
                break;
            case 1:
                this.zb = 0.0f;
                if (this.fD.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    radarSpecialTableLayout = this.pyD;
                    if (radarSpecialTableLayout == null) {
                        e.cJy();
                    }
                    this.pyE = new TranslateAnimation(0.0f, 0.0f, (float) (radarSpecialTableLayout.getTop() - this.fD.top), 0.0f);
                    TranslateAnimation translateAnimation = this.pyE;
                    if (translateAnimation == null) {
                        e.cJy();
                    }
                    translateAnimation.setInterpolator(this.pyF);
                    TranslateAnimation translateAnimation2 = this.pyE;
                    if (translateAnimation2 == null) {
                        e.cJy();
                    }
                    radarSpecialTableLayout = this.pyD;
                    if (radarSpecialTableLayout == null) {
                        e.cJy();
                    }
                    translateAnimation2.setDuration((long) Math.abs(radarSpecialTableLayout.getTop() - this.fD.top));
                    radarSpecialTableLayout = this.pyD;
                    if (radarSpecialTableLayout == null) {
                        e.cJy();
                    }
                    radarSpecialTableLayout.startAnimation(this.pyE);
                    RadarSpecialTableLayout radarSpecialTableLayout2 = this.pyD;
                    if (radarSpecialTableLayout2 == null) {
                        e.cJy();
                    }
                    radarSpecialTableLayout2.p(this.fD.left, this.fD.top, this.fD.right, this.fD.bottom);
                    this.fD.setEmpty();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.zb == 0.0f) {
                    this.zb = y;
                }
                RadarSpecialTableLayout radarSpecialTableLayout3 = this.pyD;
                if (radarSpecialTableLayout3 == null) {
                    e.cJy();
                }
                int measuredHeight = radarSpecialTableLayout3.getMeasuredHeight() - getHeight();
                int scrollY = getScrollY();
                if (!(scrollY == 0 || scrollY == measuredHeight)) {
                    i = 0;
                }
                if (i != 0) {
                    RadarSpecialTableLayout radarSpecialTableLayout4;
                    RadarSpecialTableLayout radarSpecialTableLayout5;
                    int right;
                    RadarSpecialTableLayout radarSpecialTableLayout6;
                    i = (int) (this.zb - y);
                    scrollBy(0, i);
                    if (this.fD.isEmpty()) {
                        Rect rect = this.fD;
                        radarSpecialTableLayout3 = this.pyD;
                        if (radarSpecialTableLayout3 == null) {
                            e.cJy();
                        }
                        measuredHeight = radarSpecialTableLayout3.getLeft();
                        radarSpecialTableLayout4 = this.pyD;
                        if (radarSpecialTableLayout4 == null) {
                            e.cJy();
                        }
                        scrollY = radarSpecialTableLayout4.getTop();
                        radarSpecialTableLayout5 = this.pyD;
                        if (radarSpecialTableLayout5 == null) {
                            e.cJy();
                        }
                        right = radarSpecialTableLayout5.getRight();
                        radarSpecialTableLayout6 = this.pyD;
                        if (radarSpecialTableLayout6 == null) {
                            e.cJy();
                        }
                        rect.set(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom());
                    }
                    radarSpecialTableLayout = this.pyD;
                    if (radarSpecialTableLayout == null) {
                        e.cJy();
                    }
                    radarSpecialTableLayout3 = this.pyD;
                    if (radarSpecialTableLayout3 == null) {
                        e.cJy();
                    }
                    measuredHeight = radarSpecialTableLayout3.getLeft();
                    radarSpecialTableLayout4 = this.pyD;
                    if (radarSpecialTableLayout4 == null) {
                        e.cJy();
                    }
                    scrollY = radarSpecialTableLayout4.getTop() - (i / 2);
                    radarSpecialTableLayout5 = this.pyD;
                    if (radarSpecialTableLayout5 == null) {
                        e.cJy();
                    }
                    right = radarSpecialTableLayout5.getRight();
                    radarSpecialTableLayout6 = this.pyD;
                    if (radarSpecialTableLayout6 == null) {
                        e.cJy();
                    }
                    radarSpecialTableLayout.p(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.zb - y)) / 2);
                }
                this.zb = y;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
