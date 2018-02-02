package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.et;
import com.tencent.mm.plugin.freewifi.b.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class b {
    private b() {
    }

    public final synchronized void a(et etVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String AB = m.AB(etVar.fto.ssid);
        final String str = etVar.fto.bssid;
        if (m.AA(AB)) {
            a(etVar, 1141, "Ssid is empty.");
        } else if (m.AA(str)) {
            a(etVar, 1142, "Bssid is empty.");
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + etVar.fto.ssid + "; bssid=" + etVar.fto.bssid + "; version=" + etVar.fto.version);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b cA = a.aLp().cA(AB, str);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (cA != null) {
                final String str2 = cA.fpz;
                int i = cA.mCv;
                if (i == 4) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    ag.y(new Runnable(this) {
                        final /* synthetic */ b mDy;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.aLi());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            d.b(ac.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    });
                    a(etVar, 1, null);
                } else if (i == 31) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    ag.y(new Runnable(this) {
                        final /* synthetic */ b mDy;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", AB);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(ac.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            ac.getContext().startActivity(intent);
                        }
                    });
                    a(etVar, 1, null);
                } else {
                    a(etVar, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
                }
            } else if (a.aLp().size() == 0) {
                a(etVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
            } else {
                a(etVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
            }
        }
    }

    private static void a(et etVar, int i, String str) {
        etVar.ftp.fts = i;
        etVar.ftp.ftt = str;
        etVar.ftp.ftr = 1;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (etVar.fqI != null) {
            etVar.fqI.run();
        }
    }
}
