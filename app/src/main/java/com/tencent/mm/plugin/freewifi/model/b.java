package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    a mDV;
    BroadcastReceiver mDW;

    private b() {
        this.mDV = new a((byte) 0);
        this.mDW = new 1(this);
    }

    public final void aKS() {
        try {
            ac.getContext().unregisterReceiver(this.mDW);
        } catch (IllegalArgumentException e) {
        }
    }

    static void a(a aVar, a aVar2) {
        m.AG("on mobile connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        com.tencent.mm.plugin.freewifi.f.b.pY(0);
    }

    static void b(a aVar, a aVar2) {
        m.AG("on wifi connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.AG("on wifi roaming.");
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        com.tencent.mm.plugin.freewifi.f.b.pY(1);
    }
}
