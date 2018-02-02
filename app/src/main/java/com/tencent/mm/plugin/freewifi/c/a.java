package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    public String bssid;
    public String mDN;
    public String mDO;
    public long mDP;
    public String mDQ;
    public long mDR;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a AH(String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[]{str});
        if (m.AA(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[]{str});
        Map y = bi.y(str, "sysmsg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + y.toString());
        if ("freewifi".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) y.get(".sysmsg.type");
            x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean k = m.k(y, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + k);
                if (k) {
                    aVar.uin = bh.getLong((String) y.get(".sysmsg.uin"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) y.get(".sysmsg.schemamsg.ssid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.AA(aVar.ssid)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        return null;
                    }
                    aVar.bssid = m.AC((String) y.get(".sysmsg.schemamsg.bssid"));
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.mDN = (String) y.get(".sysmsg.schemamsg.mobilemac");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.mDN);
                    if (m.AA(aVar.mDN)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        return null;
                    }
                    aVar.mDO = (String) y.get(".sysmsg.schemamsg.mpappid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.mDO);
                    aVar.mDP = bh.getLong((String) y.get(".sysmsg.schemamsg.mpshopid"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.mDP);
                    aVar.mDQ = (String) y.get(".sysmsg.schemamsg.schemaurl");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.mDQ);
                    if (m.AA(aVar.mDQ)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        return null;
                    }
                    aVar.mDR = bh.getLong((String) y.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.mDR);
                    return aVar;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                return null;
            }
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            return null;
        }
        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        return null;
    }
}
