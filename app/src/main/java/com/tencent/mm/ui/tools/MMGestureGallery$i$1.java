package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.i;

class MMGestureGallery$i$1 implements Runnable {
    final /* synthetic */ i zln;

    MMGestureGallery$i$1(i iVar) {
        this.zln = iVar;
    }

    public final void run() {
        MMGestureGallery.a(this.zln.zlk).getImageMatrix().getValues(this.zln.mVx);
        float f = this.zln.mVx[2];
        float scale = MMGestureGallery.a(this.zln.zlk).getScale() * ((float) MMGestureGallery.a(this.zln.zlk).imageWidth);
        if (scale < ((float) MMGestureGallery.b(this.zln.zlk))) {
            scale = (((float) MMGestureGallery.b(this.zln.zlk)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.zln.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.zln.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMGestureGallery.a(this.zln.zlk).K(scale, 0.0f);
    }
}
