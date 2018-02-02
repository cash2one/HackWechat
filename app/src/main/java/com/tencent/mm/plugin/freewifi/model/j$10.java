package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.f.a;
import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class j$10 extends c<gg> {
    final /* synthetic */ j mEM;

    j$10(j jVar) {
        this.mEM = jVar;
        this.xen = gg.class.getName().hashCode();
    }

    private static boolean a(gg ggVar) {
        if (ggVar.fwr.data == "MAIN_UI_EVENT_UPDATE_VIEW" && m.aLh()) {
            String str = "InterruptedProtocol31-" + System.currentTimeMillis();
            b aLI = a.aLK().aLI();
            if (!(aLI == null || aLI.mEl || System.currentTimeMillis() - aLI.mDY > 180000 || m.AA(aLI.mEj) || m.AA(aLI.mEi) || m.AA(aLI.mEk))) {
                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[]{str, Integer.valueOf(1), aLI.mEi, aLI.mEj, aLI.mEk, Long.valueOf(aLI.mDY)});
                WifiInfo aLE = d.aLE();
                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", new Object[]{str, Integer.valueOf(2), aLE});
                if (aLE != null) {
                    String AB = m.AB(aLE.getSSID());
                    if (m.AB(aLI.mEi).equals(AB)) {
                        String bssid = aLE.getBSSID();
                        String macAddress = aLE.getMacAddress();
                        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                            macAddress = m.aLj();
                        }
                        synchronized (a.aLK()) {
                            if (aLI != a.aLK().aLI()) {
                            } else {
                                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[]{str, Integer.valueOf(3), AB, bssid, macAddress});
                                new g(AB, bssid, macAddress).b(new c$1(str, aLI));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
