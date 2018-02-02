package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.h;

class MMGestureGallery$h$1 implements Runnable {
    final /* synthetic */ h zlm;

    MMGestureGallery$h$1(h hVar) {
        this.zlm = hVar;
    }

    public final void run() {
        float d;
        float b;
        MMGestureGallery.a(this.zlm.zlk).getImageMatrix().getValues(this.zlm.mVx);
        float scale = MMGestureGallery.a(this.zlm.zlk).getScale() * ((float) MMGestureGallery.a(this.zlm.zlk).imageWidth);
        float scale2 = MMGestureGallery.a(this.zlm.zlk).getScale() * ((float) MMGestureGallery.a(this.zlm.zlk).imageHeight);
        float f = this.zlm.mVx[2];
        float f2 = this.zlm.mVx[5];
        float f3 = this.zlm.mVx[2] + scale;
        float f4 = this.zlm.mVx[5] + scale2;
        float d2 = (float) MMGestureGallery.d(this.zlm.zlk);
        float b2 = (float) MMGestureGallery.b(this.zlm.zlk);
        if (scale2 < ((float) MMGestureGallery.d(this.zlm.zlk))) {
            d2 = (((float) MMGestureGallery.d(this.zlm.zlk)) / 2.0f) - (scale2 / 2.0f);
            d = (((float) MMGestureGallery.d(this.zlm.zlk)) / 2.0f) + (scale2 / 2.0f);
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
        if (scale < ((float) MMGestureGallery.b(this.zlm.zlk))) {
            d = (((float) MMGestureGallery.b(this.zlm.zlk)) / 2.0f) - (scale / 2.0f);
            b = (((float) MMGestureGallery.b(this.zlm.zlk)) / 2.0f) + (scale / 2.0f);
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
            this.zlm.fdb = true;
        }
        MMGestureGallery.a(this.zlm.zlk).K(d, d2);
    }
}
