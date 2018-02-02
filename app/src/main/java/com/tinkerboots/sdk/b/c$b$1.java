package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tinkerboots.sdk.b.c.a;
import com.tinkerboots.sdk.b.c.b;

class c$b$1 extends BroadcastReceiver {
    final /* synthetic */ a Aux;
    final /* synthetic */ b Auy;

    c$b$1(b bVar, a aVar) {
        this.Auy = bVar;
        this.Aux = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            context.unregisterReceiver(this);
            if (this.Aux != null) {
                this.Aux.aax();
            }
        }
    }
}
