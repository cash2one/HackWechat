package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements f {
    final /* synthetic */ n ovP;

    n$1(n nVar) {
        this.ovP = nVar;
    }

    public final boolean R(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        if (this.ovP.ouR.owk != c.oua && this.ovP.ouR.owk != c.oub) {
            return false;
        }
        if (this.ovP.ouR.owk == c.oub) {
            this.ovP.ouR.owk = c.ouc;
            x.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
        }
        this.ovP.ovM.dN(1);
        if (this.ovP.ovF != null) {
            this.ovP.ovF.bar();
        }
        if (this.ovP.ovG != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            if (this.ovP.ovJ != null) {
                this.ovP.ovJ.sendMessage(obtain);
            }
        }
        return true;
    }
}
