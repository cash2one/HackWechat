package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.f.a;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.sdk.platformtools.x;

class f$a$1 implements Runnable {
    final /* synthetic */ String mzl;
    final /* synthetic */ a mzm;

    f$a$1(a aVar, String str) {
        this.mzm = aVar;
        this.mzl = str;
    }

    public final void run() {
        if (TextUtils.isEmpty(this.mzl)) {
            x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
        }
        k eVar = new e(this.mzl);
        g.Dk();
        g.Di().gPJ.a(eVar, 0);
    }
}
