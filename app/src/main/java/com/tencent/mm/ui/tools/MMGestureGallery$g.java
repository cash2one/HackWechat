package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.a;

class MMGestureGallery$g extends a {
    float[] mVx = new float[9];
    final /* synthetic */ MMGestureGallery zlk;

    public MMGestureGallery$g(MMGestureGallery mMGestureGallery) {
        this.zlk = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.zlk).post(new Runnable(this) {
            final /* synthetic */ MMGestureGallery$g zll;

            {
                this.zll = r1;
            }

            public final void run() {
                MMGestureGallery.a(this.zll.zlk).getImageMatrix().getValues(this.zll.mVx);
                float scale = ((float) MMGestureGallery.a(this.zll.zlk).imageHeight) * MMGestureGallery.a(this.zll.zlk).getScale();
                float f = this.zll.mVx[5] + scale;
                float d = (float) MMGestureGallery.d(this.zll.zlk);
                if (scale < ((float) MMGestureGallery.d(this.zll.zlk))) {
                    d = (((float) MMGestureGallery.d(this.zll.zlk)) / 2.0f) + (scale / 2.0f);
                }
                d -= f;
                if (d <= 0.0f) {
                    this.zll.fdb = true;
                } else if (Math.abs(d) <= 5.0f) {
                    this.zll.fdb = true;
                } else {
                    d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                }
                MMGestureGallery.a(this.zll.zlk).K(0.0f, d);
            }
        });
    }
}
