package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.sdk.platformtools.x;

class a$6 implements b {
    final /* synthetic */ a mlr;

    a$6(a aVar) {
        this.mlr = aVar;
    }

    public final void au(byte[] bArr) {
        x.v("MicroMsg.FaceVideoRecorder", "hy: on video data come");
        a.s(this.mlr).F(new 1(this, bArr));
    }

    public final a<byte[]> aGs() {
        return j.ouM;
    }
}
