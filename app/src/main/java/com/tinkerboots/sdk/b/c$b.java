package com.tinkerboots.sdk.b;

import android.content.Context;
import android.content.IntentFilter;
import com.tinkerboots.sdk.b.c.a;

public class c$b {
    public c$b(Context context, a aVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new 1(this, aVar), intentFilter);
    }
}
