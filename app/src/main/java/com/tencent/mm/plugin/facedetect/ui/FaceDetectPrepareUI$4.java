package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.ui.a.b;

class FaceDetectPrepareUI$4 implements Runnable {
    final /* synthetic */ FaceDetectPrepareUI mjQ;
    final /* synthetic */ boolean mjR = true;
    final /* synthetic */ b mja;

    FaceDetectPrepareUI$4(FaceDetectPrepareUI faceDetectPrepareUI, boolean z, b bVar) {
        this.mjQ = faceDetectPrepareUI;
        this.mja = bVar;
    }

    public final void run() {
        this.mjQ.a(true, this.mjR, this.mja);
    }
}
