package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i mzz;

    i$1(i iVar) {
        this.mzz = iVar;
    }

    public final void ac(int i, String str) {
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            this.mzz.fm(false);
        } else {
            this.mzz.R(1, "");
        }
    }
}
