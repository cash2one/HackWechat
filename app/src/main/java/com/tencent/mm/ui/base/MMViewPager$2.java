package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMViewPager$2 implements OnTouchListener {
    final /* synthetic */ MMViewPager yeI;

    MMViewPager$2(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouch;
        if (MMViewPager.f(this.yeI) != null) {
            onTouch = MMViewPager.f(this.yeI).onTouch(view, motionEvent);
        } else {
            onTouch = false;
        }
        MultiTouchImageView g = MMViewPager.g(this.yeI);
        if (g == null) {
            MMViewPager.a(this.yeI, motionEvent);
            MMViewPager.b(this.yeI, null);
            MMViewPager.h(this.yeI).onTouchEvent(motionEvent);
            return (MMViewPager.i(this.yeI) || MMViewPager.j(this.yeI)) ? true : onTouch;
        } else {
            MMViewPager.a(this.yeI, g);
            boolean a = MMViewPager.a(this.yeI, MMViewPager.a(this.yeI), motionEvent);
            if (MMViewPager.k(this.yeI) != null) {
                MMViewPager.k(this.yeI).recycle();
            }
            MMViewPager.b(this.yeI, MotionEvent.obtainNoHistory(motionEvent));
            MMViewPager.h(this.yeI).onTouchEvent(motionEvent);
            this.yeI.computeScroll();
            return a || onTouch;
        }
    }
}
