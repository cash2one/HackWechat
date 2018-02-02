package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.j;

class MMViewPager$j$1 implements Runnable {
    final /* synthetic */ j yeN;

    MMViewPager$j$1(j jVar) {
        this.yeN = jVar;
    }

    public final void run() {
        MMViewPager.a(this.yeN.yeI).getImageMatrix().getValues(this.yeN.mVx);
        float f = this.yeN.mVx[5];
        float scale = MMViewPager.a(this.yeN.yeI).getScale() * ((float) MMViewPager.a(this.yeN.yeI).imageHeight);
        if (scale < ((float) MMViewPager.d(this.yeN.yeI))) {
            scale = (((float) MMViewPager.d(this.yeN.yeI)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.yeN.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.yeN.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMViewPager.a(this.yeN.yeI).K(0.0f, scale);
    }
}
