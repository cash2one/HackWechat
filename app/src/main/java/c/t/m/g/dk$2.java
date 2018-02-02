package c.t.m.g;

import android.content.IntentFilter;

class dk$2 implements Runnable {
    private /* synthetic */ dk a;

    dk$2(dk dkVar) {
        this.a = dkVar;
    }

    public final void run() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        try {
            if (dk.c(this.a) != null) {
                dk.d(this.a).a.registerReceiver(this.a, intentFilter, null, dk.c(this.a));
            } else {
                dk.d(this.a).a.registerReceiver(this.a, intentFilter);
            }
        } catch (Exception e) {
        }
    }
}
