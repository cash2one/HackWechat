package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h;

class MultiGestureImageView$h$1 implements Runnable {
    final /* synthetic */ h mVC;

    MultiGestureImageView$h$1(h hVar) {
        this.mVC = hVar;
    }

    public final void run() {
        this.mVC.mVy.getImageMatrix().getValues(this.mVC.mVx);
        float scale = ((float) this.mVC.mVy.imageWidth) * this.mVC.mVy.getScale();
        float f = this.mVC.mVx[2] + scale;
        float g = (float) MultiGestureImageView.g(this.mVC.mVw);
        if (scale < ((float) MultiGestureImageView.g(this.mVC.mVw))) {
            g = (((float) MultiGestureImageView.g(this.mVC.mVw)) / 2.0f) + (scale / 2.0f);
        }
        g -= f;
        if (g <= 0.0f) {
            this.mVC.fdb = true;
        } else if (Math.abs(g) <= 5.0f) {
            this.mVC.fdb = true;
        } else {
            g = ((float) (((double) Math.abs(g)) - Math.pow(Math.sqrt((double) Math.abs(g)) - 1.0d, 2.0d))) * 2.0f;
        }
        this.mVC.mVy.K(g, 0.0f);
    }
}
