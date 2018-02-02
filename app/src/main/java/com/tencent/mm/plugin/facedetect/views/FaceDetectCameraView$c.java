package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.d.a;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c implements b {
    final /* synthetic */ FaceDetectCameraView mmc;
    l mmg;
    PreviewCallback mmh;
    private d.b mmi;

    private FaceDetectCameraView$c(FaceDetectCameraView faceDetectCameraView) {
        this.mmc = faceDetectCameraView;
        this.mmg = null;
        this.mmh = new PreviewCallback(this) {
            final /* synthetic */ FaceDetectCameraView$c mmk;

            {
                this.mmk = r1;
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                x.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                d aGr = d.aGr();
                synchronized (d.mLock) {
                    x.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish");
                    if (aGr.mfW == null || aGr.mfW.size() == 0) {
                        x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                    } else if (bArr == null || bArr.length == 0) {
                        x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                    } else {
                        for (a aVar : aGr.mfW) {
                            int length = bArr.length;
                            aVar.data = (byte[]) aVar.mfX.aGs().b(Integer.valueOf(length));
                            System.arraycopy(bArr, 0, aVar.data, 0, length);
                            aVar.mfX.au(aVar.data);
                        }
                    }
                }
            }
        };
        this.mmi = new d.b(this) {
            final /* synthetic */ FaceDetectCameraView$c mmk;

            {
                this.mmk = r1;
            }

            public final void au(byte[] bArr) {
                if (!FaceDetectCameraView.n(this.mmk.mmc)) {
                    if (FaceDetectCameraView.o(this.mmk.mmc) == null) {
                        FaceDetectCameraView.a(this.mmk.mmc, c.mfT.h(Integer.valueOf(bArr.length)));
                    }
                    System.arraycopy(bArr, 0, FaceDetectCameraView.o(this.mmk.mmc), 0, bArr.length);
                    FaceDetectCameraView.a(this.mmk.mmc, bArr);
                }
                c.mfT.D(bArr);
                f.aGB().post(new 1(this));
            }

            public final com.tencent.mm.memory.a<byte[]> aGs() {
                return c.mfT;
            }
        };
        this.mmg = new l(faceDetectCameraView.getContext());
        FaceDetectCameraView.a(faceDetectCameraView, -1);
        FaceDetectCameraView.d(faceDetectCameraView);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(c cVar) {
        FaceDetectCameraView.a(this.mmc, cVar);
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            if (this.mmg == null) {
                x.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            } else if (this.mmg.mgX) {
                x.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
                FaceDetectCameraView.f(this.mmc);
            }
        }
    }

    public final void stopPreview() {
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            if (this.mmg != null && this.mmg.mgX) {
                l lVar = this.mmg;
                if (lVar.gEB != null) {
                    lVar.gEB.stopPreview();
                    lVar.mgX = false;
                    c.mfT.Es();
                }
            }
        }
    }

    public final void aHB() {
        if (!FaceDetectCameraView.m(this.mmc)) {
            FaceDetectCameraView.b(this.mmc, true);
            e.post(new Runnable(this) {
                final /* synthetic */ FaceDetectCameraView$c mmk;

                {
                    this.mmk = r1;
                }

                public final void run() {
                    synchronized (FaceDetectCameraView.e(this.mmk.mmc)) {
                        if (this.mmk.mmg == null) {
                            return;
                        }
                        x.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                        this.mmk.mmg.setPreviewCallback(null);
                        d aGr = d.aGr();
                        synchronized (d.mLock) {
                            if (aGr.mfW != null) {
                                aGr.mfW.clear();
                            }
                        }
                        if (FaceDetectCameraView.l(this.mmk.mmc) != null) {
                            FaceDetectCameraView.l(this.mmk.mmc).release();
                        }
                        this.mmk.mmg.release();
                        this.mmk.mmg = null;
                        x.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                        FaceDetectCameraView.b(this.mmk.mmc, false);
                    }
                }
            }, "FaceDetectCameraView_Camera");
        }
    }

    public final int aGM() {
        int aGM;
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            aGM = this.mmg.aGM();
        }
        return aGM;
    }

    public final int aGN() {
        int aGN;
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            aGN = this.mmg.aGN();
        }
        return aGN;
    }

    public final int getRotation() {
        int i;
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            i = this.mmg.mhc;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cS(long j) {
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            if (this.mmg == null) {
                x.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                return;
            }
            x.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", Long.valueOf(j));
            FaceDetectCameraView.b(this.mmc, j);
            if (FaceDetectCameraView.q(this.mmc)) {
                x.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
            } else if (this.mmg == null || !this.mmg.mgX) {
                x.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
                FaceDetectCameraView.a(this.mmc, true);
            } else {
                x.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
                FaceDetectCameraView.a(this.mmc, false);
                d.aGr().a(this.mmi);
                FaceDetectCameraView.r(this.mmc);
            }
        }
    }

    public final void aHC() {
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            if (this.mmg != null && this.mmg.mgX) {
                d.aGr().b(this.mmi);
                if (!FaceDetectCameraView.n(this.mmc)) {
                    FaceDetectCameraView.a(this.mmc, null);
                }
            }
        }
    }

    public final Point aHD() {
        Point point;
        synchronized (FaceDetectCameraView.e(this.mmc)) {
            point = this.mmg.mhg;
        }
        return point;
    }
}
