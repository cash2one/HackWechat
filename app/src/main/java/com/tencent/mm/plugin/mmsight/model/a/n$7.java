package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;

class n$7 implements Runnable {
    final /* synthetic */ String ovD;
    final /* synthetic */ n ovP;

    n$7(n nVar, String str) {
        this.ovP = nVar;
        this.ovD = str;
    }

    public final void run() {
        try {
            FileOp.deleteFile(this.ovD);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
        }
    }
}
