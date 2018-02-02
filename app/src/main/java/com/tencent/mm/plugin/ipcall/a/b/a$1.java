package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a nEi;

    public a$1(a aVar) {
        this.nEi = aVar;
    }

    public final int L(byte[] bArr, int i) {
        if (!this.nEi.fAs) {
            return -1;
        }
        if (i.aTy().nEG.playCallback(bArr, i) >= 0) {
            return 0;
        }
        x.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[]{Integer.valueOf(i.aTy().nEG.playCallback(bArr, i))});
        return -1;
    }
}
