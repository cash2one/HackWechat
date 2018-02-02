package com.tencent.mm.plugin.multitalk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends BroadcastReceiver {
    final /* synthetic */ e oGz;

    e$2(e eVar) {
        this.oGz = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!this.oGz.bct()) {
            return;
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.oGz.oGw.removeCallbacksAndMessages(null);
            this.oGz.oGw.postDelayed(new 1(this), 8000);
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[]{Integer.valueOf(i.q(context, intent))});
        if (i.q(context, intent) == 0) {
            ag.y(new Runnable(this) {
                final /* synthetic */ e$2 oGA;

                {
                    this.oGA = r1;
                }

                public final void run() {
                    o.bcU().oFQ.nM(false);
                }
            });
        } else {
            ag.y(new Runnable(this) {
                final /* synthetic */ e$2 oGA;

                {
                    this.oGA = r1;
                }

                public final void run() {
                    o.bcU().oFQ.nM(true);
                }
            });
        }
    }
}
