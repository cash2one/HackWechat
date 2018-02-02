package com.tencent.mm.plugin.appbrand.media;

import android.os.Looper;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.appbrand.media.encode.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements a {
    final /* synthetic */ f jzQ;

    f$4(f fVar) {
        this.jzQ = fVar;
    }

    public final void b(byte[] bArr, int i, boolean z) {
        f fVar = this.jzQ;
        x.i("MicroMsg.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        b liVar = new li();
        liVar.fCH.state = "frameRecorded";
        if (fVar.jzG != null) {
            liVar.fCH.appId = fVar.jzG.appId;
        }
        liVar.fCH.action = 5;
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        liVar.fCH.fCI = obj;
        liVar.fCH.fCJ = z;
        com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
    }
}
