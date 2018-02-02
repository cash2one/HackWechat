package com.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.d.a.a.ab.a;
import java.util.List;

class ab$1 extends BroadcastReceiver {
    final /* synthetic */ ab bng;

    ab$1(ab abVar) {
        this.bng = abVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
            ab abVar = this.bng;
            try {
                List scanResults = abVar.bgP.getScanResults();
                if (scanResults == null || scanResults.isEmpty()) {
                    throw new Exception("WifiScanMsg: null or empty scan result list");
                }
                abVar.c(new a(scanResults));
            } catch (Exception e) {
            }
        }
    }
}
