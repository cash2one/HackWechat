package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.j;

class MMGestureGallery$j$1 implements Runnable {
    final /* synthetic */ j zlo;

    MMGestureGallery$j$1(j jVar) {
        this.zlo = jVar;
    }

    public final void run() {
        MMGestureGallery.a(this.zlo.zlk).getImageMatrix().getValues(this.zlo.mVx);
        float scale = ((float) MMGestureGallery.a(this.zlo.zlk).imageWidth) * MMGestureGallery.a(this.zlo.zlk).getScale();
        float f = this.zlo.mVx[2] + scale;
        float b = (float) MMGestureGallery.b(this.zlo.zlk);
        if (scale < ((float) MMGestureGallery.b(this.zlo.zlk))) {
            b = (((float) MMGestureGallery.b(this.zlo.zlk)) / 2.0f) + (scale / 2.0f);
        }
        b -= f;
        if (b <= 0.0f) {
            this.zlo.fdb = true;
        } else if (Math.abs(b) <= 5.0f) {
            this.zlo.fdb = true;
        } else {
            b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
        }
        MMGestureGallery.a(this.zlo.zlk).K(b, 0.0f);
    }
}
