package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$a extends BroadcastReceiver {
    private o$a() {
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            if (g.Dh().Cy()) {
                g.Dh();
                if (!a.Cs()) {
                    String str;
                    if (intent == null || bh.ov(intent.getAction())) {
                        String str2 = "MicroMsg.NetTypeReporter";
                        String str3 = "onReceive %s  ";
                        Object[] objArr = new Object[1];
                        if (intent == null) {
                            str = "intent is null";
                        } else {
                            str = "action is null";
                        }
                        objArr[0] = str;
                        x.e(str2, str3, objArr);
                        return;
                    }
                    str = intent.getAction();
                    x.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", str, Boolean.valueOf(b.foreground));
                    if (!b.foreground) {
                        return;
                    }
                    if (str.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                        o.iC(1001);
                        return;
                    } else if (str.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                        o.iC(1002);
                        return;
                    } else if (str.equals("android.net.wifi.STATE_CHANGE")) {
                        o.iC(1003);
                        return;
                    } else if (str.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        o.iC(1004);
                        return;
                    } else if (str.equals("android.net.wifi.SCAN_RESULTS")) {
                        o.iC(1005);
                        return;
                    } else if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        o.iC(1006);
                        com.tencent.mm.sdk.b.a.xef.m(new ja());
                        return;
                    } else {
                        return;
                    }
                }
            }
            Object[] objArr2 = new Object[2];
            objArr2[0] = Boolean.valueOf(g.Dh().Cy());
            g.Dh();
            objArr2[1] = Boolean.valueOf(a.Cs());
            x.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", objArr2);
        } catch (Throwable th) {
            x.e("MicroMsg.NetTypeReporter", "onReceive : %s", bh.i(th));
        }
    }
}
