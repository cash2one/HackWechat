package com.tencent.mm.plugin.appbrand.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends BroadcastReceiver {
    final String iHm = "reason";
    final String iHn = "homekey";
    final /* synthetic */ d iHo;

    d$1(d dVar) {
        this.iHo = dVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra != null) {
                x.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                if (stringExtra.equals("homekey")) {
                    this.iHo.aaw();
                }
            }
        }
    }
}
