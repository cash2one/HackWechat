package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.h;

class MMViewPager$h$1 implements Runnable {
    final /* synthetic */ h yeL;

    MMViewPager$h$1(h hVar) {
        this.yeL = hVar;
    }

    public final void run() {
        MMViewPager.a(this.yeL.yeI).getImageMatrix().getValues(this.yeL.mVx);
        float f = this.yeL.mVx[2];
        float scale = MMViewPager.a(this.yeL.yeI).getScale() * ((float) MMViewPager.a(this.yeL.yeI).imageWidth);
        if (scale < ((float) MMViewPager.b(this.yeL.yeI))) {
            scale = (((float) MMViewPager.b(this.yeL.yeI)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.yeL.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.yeL.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMViewPager.a(this.yeL.yeI).K(scale, 0.0f);
    }
}
