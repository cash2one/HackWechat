package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelmulti.n.a;
import com.tencent.mm.sdk.platformtools.x;

class n$1 extends BroadcastReceiver {
    final /* synthetic */ a hGl;
    final /* synthetic */ boolean hGm = false;
    final /* synthetic */ n hGn;

    n$1(n nVar, a aVar, boolean z) {
        this.hGn = nVar;
        this.hGl = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            this.hGn.hGk = Boolean.valueOf(false);
        } else {
            this.hGn.hGk = Boolean.valueOf(true);
        }
        if (this.hGl != null) {
            this.hGl.bO(this.hGn.hGk.booleanValue());
        }
        if (this.hGm) {
            context.unregisterReceiver(this);
        }
    }
}
