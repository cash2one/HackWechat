package com.tencent.mm.plugin.ipcall;

import android.telephony.PhoneStateListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends PhoneStateListener {
    final /* synthetic */ c nCj;

    c$1(c cVar) {
        this.nCj = cVar;
    }

    public final void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        x.d("MicroMsg.IPCallManager", "onCallStateChanged " + i);
        if (i == 2) {
            x.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
            this.nCj.cI(0, 0);
        }
    }
}
