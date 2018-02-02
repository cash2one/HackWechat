package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;

class MTextureView$1 implements Runnable {
    final /* synthetic */ MTextureView iLt;

    MTextureView$1(MTextureView mTextureView) {
        this.iLt = mTextureView;
    }

    public final void run() {
        if (this.iLt.isAvailable()) {
            Canvas lockCanvas = this.iLt.lockCanvas();
            if (lockCanvas != null) {
                synchronized (MTextureView.a(this.iLt)) {
                    MTextureView.a(this.iLt, true);
                }
                lockCanvas.drawColor(-1);
                this.iLt.d(lockCanvas);
                this.iLt.unlockCanvasAndPost(lockCanvas);
                synchronized (MTextureView.a(this.iLt)) {
                    MTextureView.a(this.iLt, false);
                    MTextureView.a(this.iLt).notifyAll();
                }
            }
        }
    }
}
