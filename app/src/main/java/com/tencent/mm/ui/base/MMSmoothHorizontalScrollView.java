package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private Rect fD = new Rect();
    private Interpolator fe = new DecelerateInterpolator();
    private TranslateAnimation pyE;
    private View ydu;
    private float za;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFadingEdgeLength(0);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.ydu = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (this.ydu == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.za = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.za = 0.0f;
                if (this.fD.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.pyE = new TranslateAnimation((float) this.ydu.getLeft(), (float) this.fD.left, 0.0f, 0.0f);
                    this.pyE.setInterpolator(this.fe);
                    this.pyE.setDuration((long) Math.abs(this.ydu.getLeft() - this.fD.left));
                    this.ydu.startAnimation(this.pyE);
                    this.ydu.layout(this.fD.left, this.fD.top, this.fD.right, this.fD.bottom);
                    this.fD.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.za == 0.0f) {
                    this.za = x;
                }
                int i3 = ((int) (this.za - x)) / 2;
                scrollBy(i3, 0);
                this.za = x;
                int measuredWidth = this.ydu.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.fD.isEmpty()) {
                        this.fD.set(this.ydu.getLeft(), this.ydu.getTop(), this.ydu.getRight(), this.ydu.getBottom());
                    }
                    this.ydu.layout(this.ydu.getLeft() - i3, this.ydu.getTop(), this.ydu.getRight() - i3, this.ydu.getBottom());
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
