package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static String ce(Context context) {
        if (!an.isConnected(context)) {
            return "offline";
        }
        if (an.isWifi(context)) {
            return "wifi";
        }
        if (an.is4G(context)) {
            return "4g";
        }
        if (an.is3G(context)) {
            return "3g";
        }
        if (an.is2G(context)) {
            return "2g";
        }
        return "unknown";
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", new Object[]{Integer.valueOf(13533), Integer.valueOf(i), bh.ou(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3});
        g.pQN.h(13533, new Object[]{Integer.valueOf(i), bh.ou(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4});
    }

    public static void a(String str, int i, int i2, int i3, String str2) {
        int tX = tX(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, appState : %d, eventId %d, scene %d, sceneId %s, appType %s", new Object[]{Integer.valueOf(13801), str, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(tX)});
        g.pQN.h(13801, new Object[]{str, Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(bh.Wo()), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(tX)});
    }

    public static void a(String str, int i, int i2, long j, boolean z) {
        String ce = ce(ac.getContext());
        if (bh.ov(ce)) {
            ce = "unknown";
        }
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[]{Integer.valueOf(13537), Integer.valueOf(1000), "", "", str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", ce, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(j), Long.valueOf(bh.Wo()), Boolean.valueOf(z), Integer.valueOf(tX(str))});
        g gVar = g.pQN;
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(1000);
        objArr[1] = "";
        objArr[2] = "";
        objArr[3] = str;
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = "";
        objArr[8] = ce;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(i2);
        objArr[11] = Integer.valueOf(0);
        objArr[12] = Long.valueOf(j);
        objArr[13] = Long.valueOf(r2);
        objArr[14] = Integer.valueOf(z ? 1 : 0);
        objArr[15] = Integer.valueOf(r1);
        gVar.h(13537, objArr);
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(str);
        if (oT == null) {
            x.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        String str4 = "";
        if (!bh.ov(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = p.encode(bh.ou(str4), "UTF-8");
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(str);
        int i4 = oS == null ? 0 : oS.iOI.iGL;
        int i5 = oS == null ? 0 : oS.iOI.iGK + 1;
        String ou = bh.ou(str3);
        if (i == 18) {
            if (!bh.ov(str3)) {
                if (str3.contains(".html")) {
                    ou = str3.substring(0, str3.lastIndexOf(".html") + 5);
                }
            }
            try {
                ou = p.encode(bh.ou(ou), "UTF-8");
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
            }
        }
        String ou2 = bh.ou(oT.fnp);
        String ou3 = bh.ou(h.ph(str).irG);
        if (oT.scene == 0) {
            oT.scene = 1000;
        }
        int i6 = oT.fIs;
        String str6 = oT.fIt;
        int tX = tX(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[]{Integer.valueOf(13539), Integer.valueOf(oT.scene), ou2, ou3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(oT.jHc), str4, Integer.valueOf(i), ou, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(tX)});
        g.pQN.h(13539, new Object[]{Integer.valueOf(oT.scene), ou2, ou3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(oT.jHc), str5, Integer.valueOf(i), ou, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(tX)});
    }

    public static void z(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str)) {
            int i3;
            Object obj;
            int i4 = 1000;
            String str2 = "";
            int i5 = 0;
            int i6 = 0;
            if (bh.ov(str)) {
                String str3 = str2;
                i3 = 0;
                i6 = 1000;
                i5 = 1000;
                i4 = 0;
            } else {
                AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(str);
                if (oT != null) {
                    i6 = oT.scene == 0 ? 1000 : oT.scene;
                    str2 = bh.ou(oT.fnp);
                    i4 = i6;
                    i6 = oT.jHc;
                }
                AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(str);
                if (!(oS == null || oS.iOI == null)) {
                    i5 = oS.iOI.iGL;
                }
                if (!(i2 != 0 || oS == null || oS.iOI == null)) {
                    i2 = oS.iOI.iGK + 1;
                }
                obj = str2;
                i3 = i6;
                i6 = tX(str);
                int i7 = i5;
                i5 = i4;
                i4 = i7;
            }
            x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[]{Integer.valueOf(13541), Integer.valueOf(i5), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(i6)});
            g.pQN.h(13541, new Object[]{Integer.valueOf(i5), obj, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(3), "", Integer.valueOf(i6)});
        }
    }

    public static void a(String str, int i, int i2, int i3, int i4) {
        g.pQN.h(14369, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1)});
    }

    public static int tX(String str) {
        int i = 0;
        if (ac.cfw()) {
            WxaAttributes f = f.Zh().f(str, "appInfo", "brandIconURL", "nickname");
            if (f != null) {
                i = f.abZ().hoL;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
            }
        } else if (!bh.ov(str)) {
            e oQ = com.tencent.mm.plugin.appbrand.a.oQ(str);
            AppBrandInitConfig appBrandInitConfig = oQ == null ? null : oQ.iqw;
            if (appBrandInitConfig != null) {
                i = appBrandInitConfig.fnv;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[]{Integer.valueOf(b.tY(str))});
                i = r1;
            }
        }
        return i + 1000;
    }
}
