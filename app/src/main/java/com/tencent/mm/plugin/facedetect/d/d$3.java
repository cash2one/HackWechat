package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ d mii;

    d$3(d dVar) {
        this.mii = dVar;
    }

    public final void run() {
        synchronized (this.mii.mic) {
            if (this.mii.mhP >= this.mii.mhO.length - 1) {
                x.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                this.mii.mhx = true;
                f fVar = f.mgf;
                byte[] d = FileOp.d(this.mii.mhN.mho, -1, -1);
                g gVar = fVar.mgg.mil;
                if (gVar.mgj == null) {
                    x.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                } else {
                    gVar.mgj.engineSetVoiceData(d);
                }
            } else {
                x.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                d dVar = this.mii;
                dVar.mhP++;
                this.mii.mhQ = -1;
                this.mii.eU(true);
                this.mii.aHc();
            }
        }
    }
}
