package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;

class MSurfaceView$1 implements Runnable {
    final /* synthetic */ MSurfaceView iLr;

    MSurfaceView$1(MSurfaceView mSurfaceView) {
        this.iLr = mSurfaceView;
    }

    public final void run() {
        if (!MSurfaceView.a(this.iLr)) {
            Canvas lockCanvas = MSurfaceView.b(this.iLr).lockCanvas();
            if (lockCanvas != null) {
                lockCanvas.drawColor(-1);
                this.iLr.d(lockCanvas);
                MSurfaceView.b(this.iLr).unlockCanvasAndPost(lockCanvas);
            }
        }
    }
}
