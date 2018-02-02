package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.a;

class MMViewPager$i extends a {
    float[] mVx = new float[9];
    final /* synthetic */ MMViewPager yeI;

    public MMViewPager$i(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
        super(mMViewPager);
    }

    public final void play() {
        MMViewPager.c(this.yeI).post(new Runnable(this) {
            final /* synthetic */ MMViewPager$i yeM;

            {
                this.yeM = r1;
            }

            public final void run() {
                MMViewPager.a(this.yeM.yeI).getImageMatrix().getValues(this.yeM.mVx);
                float scale = ((float) MMViewPager.a(this.yeM.yeI).imageWidth) * MMViewPager.a(this.yeM.yeI).getScale();
                float f = this.yeM.mVx[2] + scale;
                float b = (float) MMViewPager.b(this.yeM.yeI);
                if (scale < ((float) MMViewPager.b(this.yeM.yeI))) {
                    b = (((float) MMViewPager.b(this.yeM.yeI)) / 2.0f) + (scale / 2.0f);
                }
                b -= f;
                if (b <= 0.0f) {
                    this.yeM.fdb = true;
                } else if (Math.abs(b) <= 5.0f) {
                    this.yeM.fdb = true;
                } else {
                    b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                }
                MMViewPager.a(this.yeM.yeI).K(b, 0.0f);
            }
        });
    }
}
