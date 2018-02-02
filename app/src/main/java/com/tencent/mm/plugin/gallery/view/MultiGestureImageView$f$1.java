package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.f;

class MultiGestureImageView$f$1 implements Runnable {
    final /* synthetic */ f mVA;

    MultiGestureImageView$f$1(f fVar) {
        this.mVA = fVar;
    }

    public final void run() {
        float i;
        float g;
        this.mVA.mVy.getImageMatrix().getValues(this.mVA.mVx);
        float scale = this.mVA.mVy.getScale() * ((float) this.mVA.mVy.imageWidth);
        float scale2 = this.mVA.mVy.getScale() * ((float) this.mVA.mVy.imageHeight);
        float f = this.mVA.mVx[2];
        float f2 = this.mVA.mVx[5];
        float f3 = this.mVA.mVx[2] + scale;
        float f4 = this.mVA.mVx[5] + scale2;
        float i2 = (float) MultiGestureImageView.i(this.mVA.mVw);
        float g2 = (float) MultiGestureImageView.g(this.mVA.mVw);
        if (scale2 < ((float) MultiGestureImageView.i(this.mVA.mVw))) {
            i2 = (((float) MultiGestureImageView.i(this.mVA.mVw)) / 2.0f) - (scale2 / 2.0f);
            i = (((float) MultiGestureImageView.i(this.mVA.mVw)) / 2.0f) + (scale2 / 2.0f);
        } else {
            float f5 = i2;
            i2 = 0.0f;
            i = f5;
        }
        i2 -= f2;
        i -= f4;
        if (i2 >= 0.0f) {
            if (i > 0.0f) {
                i2 = i;
            } else {
                i2 = 0.0f;
            }
        }
        if (scale < ((float) MultiGestureImageView.g(this.mVA.mVw))) {
            i = (((float) MultiGestureImageView.g(this.mVA.mVw)) / 2.0f) - (scale / 2.0f);
            g = (((float) MultiGestureImageView.g(this.mVA.mVw)) / 2.0f) + (scale / 2.0f);
        } else {
            g = g2;
            i = 0.0f;
        }
        i -= f;
        g -= f3;
        if (i >= 0.0f) {
            if (g > 0.0f) {
                i = g;
            } else {
                i = 0.0f;
            }
        }
        if (Math.abs(i) > 5.0f || Math.abs(i2) > 5.0f) {
            if (i >= 0.0f) {
                i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                i = (-((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d)))) * 2.0f;
            }
            if (i2 >= 0.0f) {
                i2 = ((float) (((double) Math.abs(i2)) - Math.pow(Math.sqrt((double) Math.abs(i2)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                i2 = (-((float) (((double) Math.abs(i2)) - Math.pow(Math.sqrt((double) Math.abs(i2)) - 1.0d, 2.0d)))) * 2.0f;
            }
        } else {
            this.mVA.fdb = true;
        }
        this.mVA.mVy.K(i, i2);
    }
}
