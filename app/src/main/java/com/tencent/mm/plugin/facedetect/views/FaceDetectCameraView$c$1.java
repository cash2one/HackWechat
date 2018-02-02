package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c$1 implements Runnable {
    final /* synthetic */ long mmj;
    final /* synthetic */ c mmk;

    FaceDetectCameraView$c$1(c cVar, long j) {
        this.mmk = cVar;
        this.mmj = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Object obj = 1;
        synchronized (FaceDetectCameraView.e(this.mmk.mmc)) {
            x.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[]{Long.valueOf(bh.bA(this.mmj))});
            long Wq = bh.Wq();
            if (this.mmk.mmg == null) {
                x.e("MicroMsg.FaceDetectCameraView", "hy: already released");
                if (FaceDetectCameraView.i(this.mmk.mmc) != null) {
                    ag.y(new 1(this));
                }
            } else {
                try {
                    this.mmk.mmg.mgZ = new Point(FaceDetectCameraView.j(this.mmk.mmc), FaceDetectCameraView.k(this.mmk.mmc));
                    l lVar = this.mmk.mmg;
                    if (lVar.gEB == null || !lVar.mhf) {
                        obj = null;
                    }
                    if (obj == null) {
                        this.mmk.mmg.e(FaceDetectCameraView.l(this.mmk.mmc));
                    }
                    FaceDetectCameraView.a(this.mmk.mmc, this.mmk.mmg.mgY);
                    l lVar2 = this.mmk.mmg;
                    SurfaceTexture l = FaceDetectCameraView.l(this.mmk.mmc);
                    long Wq2 = bh.Wq();
                    if (!(lVar2.gEB == null || lVar2.mgX)) {
                        if (l != null) {
                            x.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
                            lVar2.gEB.setPreviewTexture(l);
                        }
                        com.tencent.mm.plugin.facedetect.model.c.ct(lVar2.aGM(), lVar2.aGN());
                        lVar2.gEB.startPreview();
                        lVar2.mgX = true;
                        x.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq2))});
                    }
                    this.mmk.mmg.setPreviewCallback(this.mmk.mmh);
                    if (FaceDetectCameraView.i(this.mmk.mmc) != null) {
                        ag.y(new Runnable(this) {
                            final /* synthetic */ FaceDetectCameraView$c$1 mml;

                            {
                                this.mml = r1;
                            }

                            public final void run() {
                                FaceDetectCameraView.i(this.mml.mmk.mmc).pD(0);
                            }
                        });
                    }
                    x.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
                    FaceDetectCameraView.f(this.mmk.mmc);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceDetectCameraView", e, "hy: exception caused", new Object[0]);
                    if (FaceDetectCameraView.i(this.mmk.mmc) != null) {
                        ag.y(new 3(this));
                    }
                }
            }
        }
    }
}
