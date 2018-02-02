package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements a {
    final /* synthetic */ p pYq;

    p$1(p pVar) {
        this.pYq = pVar;
    }

    public final void m(int i, Bundle bundle) {
        x.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 0:
                this.pYq.pYh = false;
                return;
            case 1:
                this.pYq.hs(true);
                return;
            case 2:
                this.pYq.hs(true);
                return;
            case 3:
                this.pYq.pXp.bpb();
                return;
            case 4:
                if (bundle != null) {
                    String string = bundle.getString("geta8key_fullurl");
                    if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                        this.pYq.fqw = 2;
                        break;
                    }
                }
                break;
            case 5:
                break;
            default:
                return;
        }
        this.pYq.pXp.hG(true);
        this.pYq.pYh = true;
    }
}
