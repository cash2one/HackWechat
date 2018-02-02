package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class q extends j {
    private static volatile q iPb;

    public static q abY() {
        if (iPb == null) {
            synchronized (q.class) {
                if (iPb == null) {
                    iPb = new q();
                }
            }
        }
        return iPb;
    }

    public static void release() {
        synchronized (q.class) {
            iPb = null;
        }
    }

    private q() {
    }

    public final void b(String str, int i, Object obj) {
        super.b(str, i, obj);
        ((e) f.u(e.class)).b(str, i, obj);
    }

    public final void c(a aVar) {
        super.a(aVar, c.Dm().oAt.getLooper());
    }

    public static boolean i(String str, int i, boolean z) {
        boolean z2 = false;
        p Zh = f.Zh();
        if (bh.ov(str)) {
            return false;
        }
        WxaAttributes e = Zh.e(str, "appOpt");
        if (e == null) {
            return false;
        }
        int i2 = e.field_appOpt;
        i2 = !z ? i2 & (i ^ -1) : i2 | i;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i2));
        if (Zh.hhp.update("WxaAttributesTable", contentValues, String.format("%s=?", new Object[]{"username"}), new String[]{str}) > 0) {
            z2 = true;
        }
        if (z2) {
            b kyVar = new ky();
            kyVar.fCh.fnl = str;
            kyVar.fCh.fCi = i2;
            com.tencent.mm.sdk.b.a.xef.m(kyVar);
        }
        return z2;
    }

    public static t qN(String str) {
        if (bh.ov(str) || !g.Dh().Cy()) {
            return null;
        }
        WxaAttributes e = f.Zh().e(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "registerSource", "bindWxaInfo");
        if (e == null) {
            return null;
        }
        t tVar = new t();
        tVar.username = str;
        tVar.appId = e.field_appId;
        tVar.fpL = e.field_nickname;
        tVar.signature = e.field_signature;
        tVar.iPN = e.field_brandIconURL;
        tVar.iPz = e.aca().iPz;
        tVar.iPF = e.acb() == null ? -1 : e.acb().iPF;
        tVar.iPl = e.acc();
        try {
            tVar.hpu = bh.ov(e.field_registerSource) ? "" : new JSONObject(e.field_registerSource).optString("RegisterBody", "");
        } catch (Exception e2) {
        }
        return tVar;
    }

    public static i a(String str, String str2, int i, long j) {
        int i2;
        WxaAttributes e = f.Zh().e(str2, "appId", "nickname", "brandIconURL", "appInfo");
        String valueOf = String.valueOf(str);
        String str3 = e == null ? "" : e.field_appId;
        String str4 = e == null ? "" : e.field_nickname;
        String str5 = e == null ? "" : e.field_brandIconURL;
        if (e == null) {
            i2 = 0;
        } else {
            i2 = e.abZ().hoL;
        }
        return new i(valueOf, str2, str3, str4, str5, i2, i, f.Zh().qM(str2), f.Zn().an(str2, i), j);
    }

    public static AppBrandSysConfig qO(String str) {
        boolean z = false;
        WxaAttributes f = f.Zh().f(str, new String[0]);
        if (f == null) {
            return null;
        }
        AppBrandSysConfig appBrandSysConfig;
        if (f != null) {
            appBrandSysConfig = new AppBrandSysConfig();
            appBrandSysConfig.fnl = f.field_username;
            appBrandSysConfig.frn = f.field_nickname;
            appBrandSysConfig.iOg = f.field_brandIconURL;
            appBrandSysConfig.appId = f.field_appId;
            appBrandSysConfig.iOh = f.abZ().iPt;
            appBrandSysConfig.iOo = f.aca().iPy.iOo;
            appBrandSysConfig.iOp = f.aca().iPy.iOp;
            appBrandSysConfig.iOs = f.aca().iPy.iOs;
            appBrandSysConfig.iOt = f.aca().iPy.iOt;
            appBrandSysConfig.iOu = f.aca().iPy.iOu;
            appBrandSysConfig.iOv = f.aca().iPy.iOv;
            appBrandSysConfig.iOr = f.aca().iPy.iOr;
            appBrandSysConfig.iOq = f.aca().iPy.iOq;
            appBrandSysConfig.iOw = (long) f.aca().iPy.iPC;
            appBrandSysConfig.iOx = f.aca().iPy.iPD;
            appBrandSysConfig.iOA = (ArrayList) com.tencent.mm.plugin.appbrand.p.e.e(new ArrayList(), f.abZ().iPp);
            appBrandSysConfig.iOB = (ArrayList) com.tencent.mm.plugin.appbrand.p.e.e(new ArrayList(), f.abZ().iPq);
            appBrandSysConfig.iOD = (ArrayList) com.tencent.mm.plugin.appbrand.p.e.e(new ArrayList(), f.abZ().iPs);
            appBrandSysConfig.iOC = (ArrayList) com.tencent.mm.plugin.appbrand.p.e.e(new ArrayList(), f.abZ().iPr);
            appBrandSysConfig.iOK = new cz();
            appBrandSysConfig.iOK.vId = f.abZ().iJK;
            appBrandSysConfig.iOK.vIk = f.abZ().iPn;
            appBrandSysConfig.iOE = f.aca().iPy.iOE;
            appBrandSysConfig.iOF = f.aca().iPy.iOF;
            appBrandSysConfig.iOG = f.aca().iPy.iOG;
            appBrandSysConfig.iOH = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("ClientBenchmarkLevel", -1);
        } else {
            appBrandSysConfig = null;
        }
        if (appBrandSysConfig != null) {
            String str2 = appBrandSysConfig.appId;
            boolean parseBoolean = (bh.ov(str2) || f.Zl() == null) ? false : Boolean.parseBoolean(f.Zl().get(str2 + "_AppDebugEnabled", "false"));
            appBrandSysConfig.iOi = parseBoolean;
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100216");
            if (fn.isValid() && "1".equals(fn.chI().get("isOpenJSCore"))) {
                z = true;
            }
            appBrandSysConfig.iOy = z;
            appBrandSysConfig.iOj = "1".equals(f.Zl().get(appBrandSysConfig.appId + "_PerformancePanelEnabled", "0"));
        }
        return appBrandSysConfig;
    }

    public static long qM(String str) {
        return f.Zh().qM(str);
    }

    public static String[] qP(String str) {
        if (bh.ov(str) || f.Zh().e(str, "roundedSquareIconURL", "bigHeadURL") == null) {
            return null;
        }
        return new String[]{f.Zh().e(str, "roundedSquareIconURL", "bigHeadURL").field_roundedSquareIconURL, f.Zh().e(str, "roundedSquareIconURL", "bigHeadURL").field_bigHeadURL};
    }

    public static String qQ(String str) {
        if (bh.ov(str)) {
            return null;
        }
        WxaAttributes e = f.Zh().e(str, "appId");
        if (e != null) {
            return e.field_appId;
        }
        return null;
    }

    public static String qR(String str) {
        if (bh.ov(str)) {
            return null;
        }
        WxaAttributes f = f.Zh().f(str, "nickname");
        if (f != null) {
            return f.field_nickname;
        }
        return null;
    }

    public static String qS(String str) {
        if (bh.ov(str)) {
            return null;
        }
        WxaAttributes f = f.Zh().f(str, "username");
        if (f != null) {
            return f.field_username;
        }
        return null;
    }

    public static void qT(String str) {
        if (!bh.ov(str)) {
            p Zh = f.Zh();
            if (!bh.ov(str)) {
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("syncVersion", "");
                contentValues.put("syncTimeSecond", Long.valueOf(0));
                Zh.hhp.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
            }
        }
    }

    public static void qU(String str) {
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.e.c wxaAttributes = new WxaAttributes();
            wxaAttributes.field_username = str;
            f.Zh().a(wxaAttributes, new String[]{"username"});
        }
    }
}
