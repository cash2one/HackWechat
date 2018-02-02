package com.tencent.mm.plugin.fingerprint.b;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements a {
    final /* synthetic */ h mzs;

    h$1(h hVar) {
        this.mzs = hVar;
    }

    public final boolean handleMessage(Message message) {
        if (1 != message.what) {
            return false;
        }
        Object string = message.getData().getString("rsaKey");
        if (TextUtils.isEmpty(string)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
            ag.y(new Runnable(this) {
                final /* synthetic */ h$1 mzt;

                {
                    this.mzt = r1;
                }

                public final void run() {
                    this.mzt.mzs.mzn.ac(-1, this.mzt.mzs.mzp.getString(i.uJi));
                }
            });
        }
        this.mzs.mzp.b(new e(string), false);
        return true;
    }
}
