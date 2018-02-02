package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectView$4 implements c {
    final /* synthetic */ FaceDetectView mmK;
    final /* synthetic */ c mmN;

    public FaceDetectView$4(FaceDetectView faceDetectView, c cVar) {
        this.mmK = faceDetectView;
        this.mmN = cVar;
    }

    public final void pD(int i) {
        x.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", Integer.valueOf(i));
        if (i == 0) {
            FaceDetectView.a(this.mmK, false);
            FaceDetectView.h(this.mmK);
        }
        if (this.mmN != null) {
            this.mmN.pD(i);
        }
    }
}
