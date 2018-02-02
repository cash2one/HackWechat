package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements IdleHandler {
    final /* synthetic */ e hPt;

    public e$1(e eVar) {
        this.hPt = eVar;
    }

    public final boolean queueIdle() {
        if (g.CG().foreground) {
            x.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
        } else {
            x.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
            e.a(this.hPt).lD(false);
        }
        return false;
    }
}
