package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.k;

class MMGestureGallery$k$1 implements Runnable {
    final /* synthetic */ k zlp;

    MMGestureGallery$k$1(k kVar) {
        this.zlp = kVar;
    }

    public final void run() {
        MMGestureGallery.a(this.zlp.zlk).getImageMatrix().getValues(this.zlp.mVx);
        float f = this.zlp.mVx[5];
        float scale = MMGestureGallery.a(this.zlp.zlk).getScale() * ((float) MMGestureGallery.a(this.zlp.zlk).imageHeight);
        if (scale < ((float) MMGestureGallery.d(this.zlp.zlk))) {
            scale = (((float) MMGestureGallery.d(this.zlp.zlk)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.zlp.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.zlp.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMGestureGallery.a(this.zlp.zlk).K(0.0f, scale);
    }
}
