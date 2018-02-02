package com.tencent.mm.plugin.wear.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class WearYoUI$4 extends BroadcastReceiver {
    final /* synthetic */ WearYoUI tjp;

    WearYoUI$4(WearYoUI wearYoUI) {
        this.tjp = wearYoUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
            this.tjp.finish();
        }
    }
}
