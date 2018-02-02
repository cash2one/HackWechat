package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    d$1() {
    }

    public final void v(float f, float f2) {
        try {
            String valueOf = String.valueOf(f);
            String valueOf2 = String.valueOf(f2);
            if (j.aLO().AR(d.aLD()) != null) {
                g.pQN.h(12073, new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf});
                x.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2});
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + m.f(e));
        }
    }
}
