package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.g;

class MMViewPager$g$1 implements Runnable {
    final /* synthetic */ g yeK;

    MMViewPager$g$1(g gVar) {
        this.yeK = gVar;
    }

    public final void run() {
        float d;
        float b;
        MMViewPager.a(this.yeK.yeI).getImageMatrix().getValues(this.yeK.mVx);
        float scale = MMViewPager.a(this.yeK.yeI).getScale() * ((float) MMViewPager.a(this.yeK.yeI).imageWidth);
        float scale2 = MMViewPager.a(this.yeK.yeI).getScale() * ((float) MMViewPager.a(this.yeK.yeI).imageHeight);
        float f = this.yeK.mVx[2];
        float f2 = this.yeK.mVx[5];
        float f3 = this.yeK.mVx[2] + scale;
        float f4 = this.yeK.mVx[5] + scale2;
        float d2 = (float) MMViewPager.d(this.yeK.yeI);
        float b2 = (float) MMViewPager.b(this.yeK.yeI);
        if (scale2 < ((float) MMViewPager.d(this.yeK.yeI))) {
            d2 = (((float) MMViewPager.d(this.yeK.yeI)) / 2.0f) - (scale2 / 2.0f);
            d = (((float) MMViewPager.d(this.yeK.yeI)) / 2.0f) + (scale2 / 2.0f);
        } else {
            float f5 = d2;
            d2 = 0.0f;
            d = f5;
        }
        d2 -= f2;
        d -= f4;
        if (d2 >= 0.0f) {
            if (d > 0.0f) {
                d2 = d;
            } else {
                d2 = 0.0f;
            }
        }
        if (scale < ((float) MMViewPager.b(this.yeK.yeI))) {
            d = (((float) MMViewPager.b(this.yeK.yeI)) / 2.0f) - (scale / 2.0f);
            b = (((float) MMViewPager.b(this.yeK.yeI)) / 2.0f) + (scale / 2.0f);
        } else {
            b = b2;
            d = 0.0f;
        }
        d -= f;
        b -= f3;
        if (d >= 0.0f) {
            if (b > 0.0f) {
                d = b;
            } else {
                d = 0.0f;
            }
        }
        if (Math.abs(d) > 5.0f || Math.abs(d2) > 5.0f) {
            if (d >= 0.0f) {
                d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                d = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
            }
            if (d2 >= 0.0f) {
                d2 = ((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                d2 = (-((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d)))) * 2.0f;
            }
        } else {
            this.yeK.fdb = true;
        }
        MMViewPager.a(this.yeK.yeI).K(d, d2);
    }
}
