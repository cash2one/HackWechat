package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.model.f.a;
import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements e {
    final /* synthetic */ int mEU = 3;
    final /* synthetic */ String mEV;
    final /* synthetic */ b mEW;

    public c$1(String str, b bVar) {
        this.mEV = str;
        this.mEW = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        r3 = new Object[5];
        int i3 = this.mEU + 1;
        r3[1] = Integer.valueOf(i3);
        r3[2] = Integer.valueOf(i);
        r3[3] = Integer.valueOf(i2);
        r3[4] = str;
        x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s", r3);
        if (i == 0 && i2 == 0) {
            synchronized (a.aLK()) {
                if (this.mEW != a.aLK().aLI()) {
                    return;
                }
                a.aLK().aLJ();
            }
        } else if (i2 == -30020) {
            synchronized (a.aLK()) {
                if (this.mEW != a.aLK().aLI()) {
                    return;
                }
                a.aLK().aLJ();
            }
        }
    }
}
