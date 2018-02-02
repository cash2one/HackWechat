package com.tencent.mm.plugin.webview.wepkg.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.webview.wepkg.downloader.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a {
    private static int nbo = -1;
    private static a tLE;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!ar.Hj() || ar.Cs()) {
                x.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
            }
            int netType = an.getNetType(ac.getContext());
            if (netType != a.nbo) {
                a.nbo = netType;
                x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = " + netType);
                if (netType == 0) {
                    boolean zK = g.zZ().zK();
                    if (bh.by(Long.valueOf(bh.c((Long) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xvV, Long.valueOf(0)))).longValue()) > 1800) {
                        netType = 1;
                    } else {
                        netType = 0;
                    }
                    if (netType == 0) {
                        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[]{Long.valueOf(1800)});
                    }
                    if (!zK && netType != 0) {
                        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xvV, Long.valueOf(bh.Wo()));
                        b tvVar = new tv();
                        tvVar.fMD.fpr = 0;
                        com.tencent.mm.sdk.b.a.xef.m(tvVar);
                        return;
                    }
                    return;
                }
                d.bVe().bVf();
            }
        }
    }

    public static void aPU() {
        if (tLE == null) {
            tLE = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ac.getContext().registerReceiver(tLE, intentFilter);
        } catch (Exception e) {
        }
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
    }

    public static void aPV() {
        if (tLE != null) {
            try {
                ac.getContext().unregisterReceiver(tLE);
            } catch (Exception e) {
            }
        }
        tLE = null;
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
    }
}
