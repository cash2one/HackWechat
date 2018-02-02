package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e;

class MultiGestureImageView$e$1 implements Runnable {
    final /* synthetic */ e mVz;

    MultiGestureImageView$e$1(e eVar) {
        this.mVz = eVar;
    }

    public final void run() {
        this.mVz.mVy.getImageMatrix().getValues(this.mVz.mVx);
        float scale = ((float) this.mVz.mVy.imageHeight) * this.mVz.mVy.getScale();
        float f = this.mVz.mVx[5] + scale;
        float i = (float) MultiGestureImageView.i(this.mVz.mVw);
        if (scale < ((float) MultiGestureImageView.i(this.mVz.mVw))) {
            i = (((float) MultiGestureImageView.i(this.mVz.mVw)) / 2.0f) + (scale / 2.0f);
        }
        i -= f;
        if (i <= 0.0f) {
            this.mVz.fdb = true;
        } else if (Math.abs(i) <= 5.0f) {
            this.mVz.fdb = true;
        } else {
            i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
        }
        this.mVz.mVy.K(0.0f, i);
    }
}
