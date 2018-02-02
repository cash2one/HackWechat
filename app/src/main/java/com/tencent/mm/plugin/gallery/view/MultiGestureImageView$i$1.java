package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.i;

class MultiGestureImageView$i$1 implements Runnable {
    final /* synthetic */ i mVD;

    MultiGestureImageView$i$1(i iVar) {
        this.mVD = iVar;
    }

    public final void run() {
        this.mVD.mVy.getImageMatrix().getValues(this.mVD.mVx);
        float f = this.mVD.mVx[5];
        float scale = this.mVD.mVy.getScale() * ((float) this.mVD.mVy.imageHeight);
        if (scale < ((float) MultiGestureImageView.i(this.mVD.mVw))) {
            scale = (((float) MultiGestureImageView.i(this.mVD.mVw)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.mVD.fdb = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.mVD.fdb = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        this.mVD.mVy.K(0.0f, scale);
    }
}
