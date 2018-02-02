package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.a;

class MMViewPager$f extends a {
    float[] mVx = new float[9];
    final /* synthetic */ MMViewPager yeI;

    public MMViewPager$f(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
        super(mMViewPager);
    }

    public final void play() {
        MMViewPager.c(this.yeI).post(new Runnable(this) {
            final /* synthetic */ MMViewPager$f yeJ;

            {
                this.yeJ = r1;
            }

            public final void run() {
                MMViewPager.a(this.yeJ.yeI).getImageMatrix().getValues(this.yeJ.mVx);
                float scale = ((float) MMViewPager.a(this.yeJ.yeI).imageHeight) * MMViewPager.a(this.yeJ.yeI).getScale();
                float f = this.yeJ.mVx[5] + scale;
                float d = (float) MMViewPager.d(this.yeJ.yeI);
                if (scale < ((float) MMViewPager.d(this.yeJ.yeI))) {
                    d = (((float) MMViewPager.d(this.yeJ.yeI)) / 2.0f) + (scale / 2.0f);
                }
                d -= f;
                if (d <= 0.0f) {
                    this.yeJ.fdb = true;
                } else if (Math.abs(d) <= 5.0f) {
                    this.yeJ.fdb = true;
                } else {
                    d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                }
                MMViewPager.a(this.yeJ.yeI).K(0.0f, d);
            }
        });
    }
}
