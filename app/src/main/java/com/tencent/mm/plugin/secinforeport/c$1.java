package com.tencent.mm.plugin.secinforeport;

import android.util.Base64;
import com.tencent.c.a.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements b {
    final /* synthetic */ c qfc;

    c$1(c cVar) {
        this.qfc = cVar;
    }

    public final boolean m(int i, byte[] bArr) {
        if (i == 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            Object[][] objArr = new Object[1][];
            objArr[0] = new Object[]{"\u001e<:& *\u001e&3\u0005!3'\u0007%(?ol", encodeToString};
            c.a(this.qfc, d.oSu.a(objArr));
            return true;
        }
        x.w("MicroMsg.SecInfoReporterImpl", "TuringService recvReqData failed, code: " + i);
        return false;
    }
}
