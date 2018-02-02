package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g;

class MultiGestureImageView$g$1 implements Runnable {
    final /* synthetic */ g mVB;

    MultiGestureImageView$g$1(g gVar) {
        this.mVB = gVar;
    }

    public final void run() {
        this.mVB.mVy.getImageMatrix().getValues(this.mVB.mVx);
        float f = this.mVB.mVx[2];
        float scale = this.mVB.mVy.getScale() * ((float) this.mVB.mVy.imageWidth);
        if (scale < ((float) MultiGestureImageView.g(this.mVB.mVw))) {
            scale = (((float) MultiGestureImageView.g(this.mVB.mVw)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.mVB.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.mVB.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        this.mVB.mVy.K(scale, 0.0f);
    }
}
