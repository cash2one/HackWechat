package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    boolean kwb;
    a mEt;
    BroadcastReceiver mEu;

    private h() {
        this.kwb = false;
        this.mEu = new 1(this);
    }

    public final boolean a(a aVar) {
        if (this.kwb) {
            return false;
        }
        this.kwb = true;
        this.mEt = aVar;
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            return false;
        }
        ac.getContext().registerReceiver(this.mEu, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        return true;
    }
}
