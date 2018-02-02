package com.tencent.mm.plugin.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$2 extends BroadcastReceiver {
    final /* synthetic */ b kHR;

    b$2(b bVar) {
        this.kHR = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        boolean z = true;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    z = true;
                    break;
                }
                break;
            case -1886648615:
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    z = true;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    z = false;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                b.b(this.kHR, true);
                break;
            case true:
                b.b(this.kHR, false);
                break;
            case true:
                b.c(this.kHR, true);
                break;
            case true:
                b.c(this.kHR, false);
                break;
        }
        if (!b.j(this.kHR) || b.k(this.kHR)) {
            if (b.l(this.kHR) != null) {
                ar.Dm();
                ag.K(b.l(this.kHR));
                b.b(this.kHR, null);
            }
            b.m(this.kHR);
            return;
        }
        x.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
        if (b.l(this.kHR) == null) {
            b.b(this.kHR, new 1(this));
            ar.Dm().g(b.l(this.kHR), 300000);
        }
    }
}
