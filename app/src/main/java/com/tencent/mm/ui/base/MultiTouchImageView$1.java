package com.tencent.mm.ui.base;

class MultiTouchImageView$1 implements Runnable {
    final /* synthetic */ float fiX;
    final /* synthetic */ float fiY;
    final /* synthetic */ long hAU;
    final /* synthetic */ float yfA = 128.0f;
    final /* synthetic */ float yfB;
    final /* synthetic */ float yfC;
    final /* synthetic */ MultiTouchImageView yfD;

    MultiTouchImageView$1(MultiTouchImageView multiTouchImageView, float f, long j, float f2, float f3, float f4, float f5) {
        this.yfD = multiTouchImageView;
        this.hAU = j;
        this.yfB = f2;
        this.yfC = f3;
        this.fiX = f4;
        this.fiY = f5;
    }

    public final void run() {
        float min = Math.min(this.yfA, (float) (System.currentTimeMillis() - this.hAU));
        this.yfD.h(this.yfB + (this.yfC * min), this.fiX, this.fiY);
        if (min < this.yfA) {
            this.yfD.mHandler.post(this);
        }
    }
}
