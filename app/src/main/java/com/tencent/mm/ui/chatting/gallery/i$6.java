package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class i$6 implements Runnable {
    final /* synthetic */ int jqi;
    final /* synthetic */ i yFV;

    i$6(i iVar, int i) {
        this.yFV = iVar;
        this.jqi = i;
    }

    public final void run() {
        String a = i.a(this.yFV);
        int i = this.jqi;
        r nF = t.nF(a);
        if (nF != null) {
            int i2 = nF.hVH;
            if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                nF.hVH = i;
                nF.fDt = Downloads.RECV_BUFFER_SIZE;
                x.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[]{Boolean.valueOf(t.e(nF)), Integer.valueOf(i2), Integer.valueOf(i)});
            }
        }
    }
}
