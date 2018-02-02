package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.plugin.appbrand.media.record.a.a;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f jzQ;

    f$1(f fVar) {
        this.jzQ = fVar;
    }

    public final void q(byte[] bArr, int i) {
        if (this.jzQ.jzI != null && this.jzQ.jzD != null) {
            f fVar = this.jzQ;
            int i2 = this.jzQ.jzK;
            com.tencent.mm.plugin.appbrand.media.record.a aVar = this.jzQ.jzD;
            fVar.jzK = (aVar.fkb != null ? aVar.fkb.fku : 20) + i2;
            try {
                if (!this.jzQ.jzI.a(this.jzQ.jzJ, bArr, i)) {
                    x.e("MicroMsg.AudioRecordMgr", "encode pcm fail!");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "onRecPcmDataReady", new Object[0]);
                if (this.jzQ.jzG != null && "mp3".equalsIgnoreCase(this.jzQ.jzG.jfm)) {
                    j.kV(19);
                } else if (this.jzQ.jzG != null && "aac".equalsIgnoreCase(this.jzQ.jzG.jfm)) {
                    j.kV(23);
                }
            }
        }
    }

    public final void aK(int i, int i2) {
        x.i("MicroMsg.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.jzQ.onError(1);
    }
}
