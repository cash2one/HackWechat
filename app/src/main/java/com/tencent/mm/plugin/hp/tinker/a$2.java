package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ Runnable jDA;
    final /* synthetic */ a nBe;
    final /* synthetic */ long nBf = 6000;

    a$2(a aVar, Runnable runnable, long j) {
        this.nBe = aVar;
        this.jDA = runnable;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
            this.nBe.handler.postDelayed(this.jDA, this.nBf);
            return;
        }
        a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
        this.nBe.handler.removeCallbacks(this.jDA);
        context.unregisterReceiver(this);
    }
}
