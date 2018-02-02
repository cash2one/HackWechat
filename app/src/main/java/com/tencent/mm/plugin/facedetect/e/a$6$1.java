package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.6;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class a$6$1 implements Runnable {
    final /* synthetic */ byte[] ibn;
    final /* synthetic */ 6 mly;

    a$6$1(6 6, byte[] bArr) {
        this.mly = 6;
        this.ibn = bArr;
    }

    public final void run() {
        SightVideoJNI.mirrorCameraData(this.ibn, a.i(this.mly.mlr), a.j(this.mly.mlr), false);
        if (a.g(this.mly.mlr).bay() != null) {
            a.g(this.mly.mlr).bay().R(this.ibn);
        }
    }
}
