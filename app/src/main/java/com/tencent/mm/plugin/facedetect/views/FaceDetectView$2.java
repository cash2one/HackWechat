package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ag;

class FaceDetectView$2 implements Runnable {
    final /* synthetic */ String hpU;
    final /* synthetic */ FaceDetectView mmK;

    FaceDetectView$2(FaceDetectView faceDetectView, String str) {
        this.mmK = faceDetectView;
        this.hpU = str;
    }

    public final void run() {
        ag.y(new 1(this, n.zK(this.hpU)));
    }
}
