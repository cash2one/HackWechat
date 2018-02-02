package com.tencent.mm.plugin.wallet_core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.z.q;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    private static c nXT;
    private static a sMZ;
    private static i sNa;
    private static au sNb = null;
    public JSONArray sNc;

    private static class a implements a$a {
        int hkU = 0;
        WeakReference<Activity> sNd;

        public a(Activity activity) {
            this.sNd = new WeakReference(activity);
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                if (i.sNb == null) {
                    i.sNb = new au();
                }
                String FS = q.FS();
                g.Dk();
                x WO = ((h) g.h(h.class)).EY().WO(FS);
                i.sNb.fWq = WO.getCityCode();
                i.sNb.fWp = WO.cie();
                long j = i.OP().hxS;
                WifiInfo wifiInfo = an.getWifiInfo(ac.getContext());
                String str = "";
                FS = "";
                String str2 = "";
                if (wifiInfo != null) {
                    str = wifiInfo.getSSID();
                    FS = System.currentTimeMillis();
                    str2 = wifiInfo.getBSSID();
                }
                str2 = String.format("latitude=%.6f&longitude=%.6f&location_timestamp=%s&wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{Float.valueOf(f2), Float.valueOf(f), Long.valueOf(j), i.vI(str), i.vI(str2), FS});
                i.MR(str2 + i.bLe());
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "fLongitude=" + f + ";fLatitude=" + f2 + " tryCount: " + this.hkU);
                this.hkU++;
                if (this.hkU > 3) {
                    i.nXT.c(this);
                }
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GpsReportHelper", "get Location fail;isOk=" + z);
            i.nXT.c(this);
            if (!(this.sNd == null || this.sNd.get() == null || com.tencent.mm.plugin.wallet_core.a.a.ifs == null)) {
                com.tencent.mm.plugin.wallet_core.a.a.ifs.as((Context) this.sNd.get());
            }
            return false;
        }
    }

    private i() {
        init();
    }

    private void init() {
        g.Dk();
        String str = (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrt, "");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
        if (!bh.ov(str)) {
            try {
                this.sNc = new JSONArray(str);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[]{e});
            }
        }
    }

    public static i bLd() {
        if (sNa == null) {
            sNa = new i();
        }
        return sNa;
    }

    protected static String bLe() {
        String str = "&scan_ssid%d=%s&scan_bssid%d=%s";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = ac.getContext();
            if (context == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            int i = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(i), vI(scanResult.SSID), Integer.valueOf(i), vI(scanResult.BSSID)}));
                int i2 = i + 1;
                if (i2 >= 10) {
                    break;
                }
                i = i2;
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
    }

    protected static String vI(String str) {
        try {
            str = p.encode(str, "UTF-8");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
        return str;
    }

    protected static void MR(String str) {
        if (sNb == null) {
            sNb = new au();
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "encrpydata %s", new Object[]{str});
        byte[] bArr = new byte[16];
        byte[] bytes = n.cBr().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        bytes = Base64.encode(bArr, 0);
        au auVar = sNb;
        if (l.sNe == null) {
            l.sNe = new l();
        }
        auVar.vFS = l.sNe.aR(bytes);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_key %s", new Object[]{sNb.vFS});
        bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
        sNb.vFR = new String(bytes);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_userinfo %s", new Object[]{new String(bytes)});
    }

    private static c OP() {
        if (nXT == null) {
            nXT = c.OP();
        }
        return nXT;
    }

    public static void i(final Activity activity, final int i) {
        int i2 = 1;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + i);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bLq().bLQ().sPW & 8192) > 0), Integer.valueOf(o.bLq().bLQ().sPW)});
        String str;
        if (!((o.bLq().bLQ().sPW & 8192) > 0)) {
            sMZ = null;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bLq().bLQ().sPW & 262144) > 0), Integer.valueOf(o.bLq().bLQ().sPW)});
            if ((o.bLq().bLQ().sPW & 262144) > 0) {
                WifiInfo wifiInfo = an.getWifiInfo(ac.getContext());
                String str2 = "";
                str = "";
                String str3 = "";
                if (wifiInfo != null) {
                    str2 = wifiInfo.getSSID();
                    str = System.currentTimeMillis();
                    str3 = wifiInfo.getBSSID();
                }
                MR(String.format("wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{vI(str2), vI(str3), str}) + bLe());
            }
        } else if (c.OQ() || c.OR()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "reflashLocationInfo scene:%d", new Object[]{Integer.valueOf(i)});
            if (activity != null) {
                c OP = OP();
                if (sMZ == null) {
                    sMZ = new a(activity);
                } else {
                    a aVar = sMZ;
                    if (activity == null || aVar.sNd == null || !activity.equals(aVar.sNd.get())) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        sMZ = new a(activity);
                    }
                }
                if (sMZ != null) {
                    sMZ.hkU = 0;
                }
                OP.a(sMZ, false);
                return;
            }
            sMZ = null;
        } else if (bLd().zi(i)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "should show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
            g.Dk();
            str = (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xru, activity.getString(com.tencent.mm.plugin.wxpay.a.i.uWm));
            g.Dk();
            String str4 = (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrv, activity.getString(com.tencent.mm.plugin.wxpay.a.i.uWl));
            g.Dk();
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xrs, Long.valueOf(bh.Wo()));
            com.tencent.mm.ui.base.h.a(activity, str4, str, activity.getString(com.tencent.mm.plugin.wxpay.a.i.est), activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEn), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    com.tencent.mm.plugin.report.service.g.pQN.h(13446, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(bh.Wo())});
                    dialogInterface.dismiss();
                }
            }, new 2(), com.tencent.mm.plugin.wxpay.a.c.bui);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "should'n show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public static au bLf() {
        return sNb;
    }

    private boolean zi(int i) {
        if (i == 5 || i == 6) {
            return false;
        }
        boolean z;
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrs, Long.valueOf(0))).longValue();
        if (this.sNc == null) {
            init();
        }
        if (this.sNc != null) {
            z = false;
            for (int i2 = 0; i2 < this.sNc.length(); i2++) {
                JSONObject optJSONObject = this.sNc.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt("scene") == i) {
                    int i3;
                    if (optJSONObject.optInt("is_show_tips", 0) == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    int optInt = optJSONObject.optInt("show_interval", 0);
                    long Wo = bh.Wo();
                    if (i3 != 0 && Wo - longValue > ((long) optInt)) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "shouldShow? %s mLbsConfig: %s ", new Object[]{Boolean.valueOf(z), this.sNc});
        return z;
    }
}
