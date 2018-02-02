package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements Runnable {
    final /* synthetic */ long gyu;
    final /* synthetic */ long otd;
    final /* synthetic */ int ote;
    final /* synthetic */ n otf;
    final /* synthetic */ Context val$context;

    n$1(n nVar, long j, long j2, Context context, int i) {
        this.otf = nVar;
        this.otd = j;
        this.gyu = j2;
        this.val$context = context;
        this.ote = i;
    }

    public final void run() {
        x.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[]{Long.valueOf(this.otd), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(bh.Wp() - this.gyu)});
        synchronized (this.otf.lock) {
            try {
                this.otf.otc = d.o(this.val$context, this.ote);
            } catch (Exception e) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", new Object[]{e.getMessage()});
                this.otf.otc = null;
            }
            if (this.otf.otb && this.otf.otc != null) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", new Object[]{Long.valueOf(bh.Wp() - this.gyu)});
                try {
                    Camera camera = this.otf.otc.gEB;
                    camera.setPreviewCallback(null);
                    camera.stopPreview();
                    camera.release();
                    this.otf.otc = null;
                } catch (Exception e2) {
                    x.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", new Object[]{e2.getMessage()});
                }
            }
            this.otf.lock.notify();
        }
    }
}
