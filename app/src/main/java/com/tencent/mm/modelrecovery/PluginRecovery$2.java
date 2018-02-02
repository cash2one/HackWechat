package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PluginRecovery$2 extends BroadcastReceiver {
    final /* synthetic */ PluginRecovery hJZ;

    PluginRecovery$2(PluginRecovery pluginRecovery) {
        this.hJZ = pluginRecovery;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
            PluginRecovery.access$000(this.hJZ);
        } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
            PluginRecovery.access$100(this.hJZ);
        }
    }
}
