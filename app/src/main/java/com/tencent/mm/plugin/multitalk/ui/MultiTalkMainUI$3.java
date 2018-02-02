package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.e;

class MultiTalkMainUI$3 extends BroadcastReceiver {
    final /* synthetic */ MultiTalkMainUI oHM;

    MultiTalkMainUI$3(MultiTalkMainUI multiTalkMainUI) {
        this.oHM = multiTalkMainUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && o.bcV().oGh == e.oIx) {
            o.bcV().stopRing();
            MultiTalkMainUI.a(this.oHM);
        }
    }
}
