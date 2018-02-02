package com.tencent.mm.plugin.fingerprint.b;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.fingerprint.b.h.a;
import com.tencent.mm.sdk.platformtools.x;

class h$a$2 implements Runnable {
    final /* synthetic */ String mzl;
    final /* synthetic */ a mzu;

    h$a$2(a aVar, String str) {
        this.mzu = aVar;
        this.mzl = str;
    }

    public final void run() {
        x.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
        Message obtainMessage = this.mzu.mzs.mzj.obtainMessage();
        obtainMessage.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("rsaKey", this.mzl);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }
}
