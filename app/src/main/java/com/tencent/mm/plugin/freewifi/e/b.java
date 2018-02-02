package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    private static class a {
        private static b mET = new b();
    }

    private b() {
    }

    public static b aMk() {
        return a.mET;
    }

    public static void I(Intent intent) {
        boolean z = true;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("free_wifi_ap_key");
            if (!m.AA(stringExtra)) {
                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                if (2 == intExtra) {
                    intExtra = 11;
                } else if (3 == intExtra) {
                    intExtra = 12;
                } else if (4 == intExtra) {
                    intExtra = 13;
                } else {
                    intExtra = 1;
                }
                intent.putExtra("free_wifi_channel_id", intExtra);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.D(intent) + "_" + m.F(intent) + "_" + m.G(intent) + "_" + System.currentTimeMillis());
                boolean j = com.tencent.mm.plugin.freewifi.e.d.a.aMm().j(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
                com.tencent.mm.plugin.freewifi.k.a aLe = k.aLe();
                aLe.ssid = m.AD(TAG);
                aLe.bssid = m.AE(TAG);
                aLe.fpz = stringExtra;
                aLe.mCu = intent.getStringExtra("free_wifi_schema_ticket");
                aLe.mCv = m.F(intent);
                aLe.mCw = com.tencent.mm.plugin.freewifi.k.b.mCP.mDi;
                aLe.mCx = com.tencent.mm.plugin.freewifi.k.b.mCP.name;
                aLe.fCR = m.G(intent);
                aLe.result = j ? 0 : -1;
                k aLg = aLe.aLg();
                if (j) {
                    z = false;
                }
                aLg.b(intent, z).aLf();
                x.i(TAG, "getLock = " + j);
                m.AG("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + j);
                if (j) {
                    m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                    intent.setClass(ac.getContext(), FreeWifiNetCheckUI.class);
                    intent.addFlags(67108864);
                    d.b(ac.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                }
            }
        }
    }
}
