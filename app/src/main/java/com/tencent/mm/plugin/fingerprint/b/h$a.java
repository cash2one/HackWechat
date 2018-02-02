package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class h$a implements o$a {
    final /* synthetic */ h mzs;

    private h$a(h hVar) {
        this.mzs = hVar;
    }

    public final void sj(String str) {
        if (TextUtils.isEmpty(str)) {
            ag.y(new Runnable(this) {
                final /* synthetic */ h$a mzu;

                {
                    this.mzu = r1;
                }

                public final void run() {
                    this.mzu.mzs.mzn.ac(-1, this.mzu.mzs.mzp.getString(a$i.uJi));
                }
            });
            x.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
            return;
        }
        ag.y(new 2(this, str));
    }
}
