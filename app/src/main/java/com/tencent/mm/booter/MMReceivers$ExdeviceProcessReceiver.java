package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;

public class MMReceivers$ExdeviceProcessReceiver extends BroadcastReceiver {
    private static a gye = null;

    public static void a(a aVar) {
        gye = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (gye != null) {
            gye.onReceive(context, intent);
        }
    }
}
