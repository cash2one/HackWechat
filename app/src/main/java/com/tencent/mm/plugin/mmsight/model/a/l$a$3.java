package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.a.l.a;
import com.tencent.mm.sdk.platformtools.x;

class l$a$3 implements Runnable {
    final /* synthetic */ a ovC;
    final /* synthetic */ String ovD;

    l$a$3(a aVar, String str) {
        this.ovC = aVar;
        this.ovD = str;
    }

    public final void run() {
        try {
            FileOp.deleteFile(this.ovD);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
        }
    }
}
