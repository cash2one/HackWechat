package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class PluginFTS$8 extends BroadcastReceiver {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$8(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            x.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + intent.getAction());
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                PluginFTS.access$1602(this.mJM, true);
            } else if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                PluginFTS.access$1602(this.mJM, false);
            }
        }
    }
}
