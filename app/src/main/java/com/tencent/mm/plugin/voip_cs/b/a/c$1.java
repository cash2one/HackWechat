package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c sxD;

    c$1(c cVar) {
        this.sxD = cVar;
    }

    public final void q(byte[] bArr, int i) {
        if (i <= 0) {
            x.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
            return;
        }
        x.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
        x.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + b.bIS().nEG.recordCallback(bArr, i, 200));
    }

    public final void aK(int i, int i2) {
        x.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
    }
}
