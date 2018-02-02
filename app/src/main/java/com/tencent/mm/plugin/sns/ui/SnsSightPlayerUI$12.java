package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class SnsSightPlayerUI$12 extends SimpleOnGestureListener {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$12(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float translationX = (((View) SnsSightPlayerUI.f(this.rGv)).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
        float translationY = (((View) SnsSightPlayerUI.f(this.rGv)).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
        if (SnsSightPlayerUI.l(this.rGv)) {
            ((View) SnsSightPlayerUI.f(this.rGv)).setTranslationX(translationX);
            ((View) SnsSightPlayerUI.f(this.rGv)).setTranslationY(translationY);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        SnsSightPlayerUI.b(this.rGv, true);
        super.onLongPress(motionEvent);
    }
}
