package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MMReceivers$ToolsProcessReceiver extends BroadcastReceiver {
    private static MMReceivers$a gye = null;

    public static void a(MMReceivers$a mMReceivers$a) {
        gye = mMReceivers$a;
    }

    public void onReceive(Context context, Intent intent) {
        if (gye != null) {
            gye.onReceive(context, intent);
        }
    }
}
