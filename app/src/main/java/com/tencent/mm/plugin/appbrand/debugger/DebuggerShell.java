package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

public final class DebuggerShell extends BroadcastReceiver implements a, b {
    private static boolean iPQ = false;
    private final Map<String, a> iPP = new HashMap();

    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("action");
        if (!bh.ov(stringExtra) && this.iPP.containsKey(stringExtra)) {
            ((a) this.iPP.get(stringExtra)).t(intent);
        }
    }

    public final void DT() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        ac.getContext().registerReceiver(this, intentFilter);
        a(new b());
        a(new c());
        a(new e());
    }

    public final void DU() {
        ac.getContext().unregisterReceiver(this);
        this.iPP.clear();
    }

    private void a(a aVar) {
        if (!bh.ov(aVar.name())) {
            this.iPP.put(aVar.name(), aVar);
        }
    }

    public static boolean acg() {
        return iPQ;
    }

    public static boolean ach() {
        return iPQ;
    }
}
