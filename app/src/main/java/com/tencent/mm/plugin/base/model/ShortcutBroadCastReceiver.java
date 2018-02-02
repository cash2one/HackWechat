package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
        } else {
            h.bu(context, context.getString(a.h.dDL));
        }
    }
}
