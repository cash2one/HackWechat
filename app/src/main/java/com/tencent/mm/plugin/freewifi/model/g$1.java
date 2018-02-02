package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ int mDo;
    final /* synthetic */ String mDz;
    final /* synthetic */ b mEn;
    final /* synthetic */ g mEo;
    final /* synthetic */ Intent val$intent;

    g$1(g gVar, String str, Intent intent, b bVar, int i) {
        this.mEo = gVar;
        this.mDz = str;
        this.val$intent = intent;
        this.mEn = bVar;
        this.mDo = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        int i = this.mEo.mEm;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
            g.b(this.mDz, 1, this.val$intent);
            String zL = g.zZ().zL();
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", new Object[]{zL});
            if (bh.ov(zL)) {
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                zL = "http://10.1.0.6/redirect";
            }
            String AN = g.AN(zL);
            x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", new Object[]{zL, AN});
            if (!bh.ov(AN)) {
                break;
            }
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", new Object[]{zL, AN});
            try {
                Thread.sleep(500);
                i = i2;
            } catch (Exception e) {
                i = i2;
            }
        }
        if (this.mEn != null) {
            this.mEn.bn(null, this.mDo);
        }
        g.b(this.mDz, 3, this.val$intent);
    }
}
