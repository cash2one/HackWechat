package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import com.tencent.mm.ad.n;
import com.tencent.mm.bq.b;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class p extends i<WxaAttributes> {
    public final h hhp;

    public final /* synthetic */ boolean a(c cVar, boolean z) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        super.a(wxaAttributes, z);
        return e("username", "appId") != null;
    }

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((WxaAttributes) cVar, strArr);
    }

    public p(h hVar) {
        super(hVar, WxaAttributes.iEJ, "WxaAttributesTable", WxaAttributes.fMK);
        this.hhp = hVar;
    }

    public final WxaAttributes e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bh.ov(str) && str.endsWith("@app")) {
            Cursor a = this.hhp.a("WxaAttributesTable", bh.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    public final WxaAttributes f(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bh.ov(str)) {
            Cursor a = this.hhp.a("WxaAttributesTable", bh.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    final long qM(String str) {
        WxaAttributes e = e(str, "appInfo");
        if (e == null || e.abZ() == null) {
            return 0;
        }
        return e.abZ().iJK;
    }

    public final boolean a(String str, b bVar, List<cbe> list) {
        if (bh.cA(list)) {
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (a(wxaAttributes, "username")) {
            boolean z = false;
        } else {
            int i = 1;
        }
        int i2 = 0;
        for (cbe com_tencent_mm_protocal_c_cbe : list) {
            if (com_tencent_mm_protocal_c_cbe != null) {
                i2 = a(wxaAttributes, com_tencent_mm_protocal_c_cbe) | i2;
            }
        }
        if (i2 != 0) {
            if (i != 0) {
                b(wxaAttributes);
            } else {
                c(wxaAttributes, new String[]{"username"});
            }
            try {
                if (g.Dh().Cy()) {
                    com.tencent.mm.ad.h hVar;
                    int i3;
                    boolean z2;
                    af xVar;
                    String str2 = wxaAttributes.field_username;
                    String str3 = wxaAttributes.field_nickname;
                    String str4 = wxaAttributes.field_bigHeadURL;
                    String str5 = wxaAttributes.field_smallHeadURL;
                    com.tencent.mm.ad.h jm = n.JQ().jm(str2);
                    if (jm == null) {
                        hVar = new com.tencent.mm.ad.h();
                        i3 = 1;
                    } else {
                        hVar = jm;
                        z2 = false;
                    }
                    if (!bh.ou(str5).equals(hVar.JH())) {
                        hVar.hlx = str5;
                        i3 = 1;
                    }
                    if (!bh.ou(str4).equals(hVar.JG())) {
                        hVar.hly = str4;
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        hVar.username = str2;
                        hVar.bA(true);
                        hVar.fDt = 31;
                        n.JQ().a(hVar);
                    }
                    af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str2);
                    if (WO == null) {
                        xVar = new x();
                    } else {
                        xVar = WO;
                    }
                    if (((int) xVar.gJd) == 0) {
                        xVar.setUsername(str2);
                        i3 = 1;
                    } else {
                        z2 = false;
                    }
                    if (!str3.equals(xVar.field_nickname)) {
                        xVar.dc(str3);
                        xVar.dd(com.tencent.mm.platformtools.c.om(str3));
                        xVar.de(com.tencent.mm.platformtools.c.ol(str3));
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().P(xVar);
                    }
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WxaAttrStorage", e, "flushContactInMainDB", new Object[0]);
            }
        }
        f.Zo().a(wxaAttributes.field_appId, wxaAttributes.acb());
        wxaAttributes.field_syncTimeSecond = bh.Wo();
        wxaAttributes.field_syncVersion = bh.by(bVar == null ? new byte[0] : bVar.oz);
        c(wxaAttributes, new String[]{"username"});
        return i2;
    }

    private static boolean a(WxaAttributes wxaAttributes, cbe com_tencent_mm_protocal_c_cbe) {
        if ("NickName".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = bh.ou(com_tencent_mm_protocal_c_cbe.pQt);
            return true;
        } else if ("BrandIconURL".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = com_tencent_mm_protocal_c_cbe.pQt;
            return true;
        } else if ("BigHeadImgUrl".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = com_tencent_mm_protocal_c_cbe.pQt;
            return true;
        } else if ("SmallHeadImgUrl".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = com_tencent_mm_protocal_c_cbe.pQt;
            return true;
        } else if (!"Signature".equals(com_tencent_mm_protocal_c_cbe.vNj) || aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(com_tencent_mm_protocal_c_cbe.vNj)) {
                int i = bh.getInt(com_tencent_mm_protocal_c_cbe.pQt, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    return true;
                }
            }
            if ("RegisterSource".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = com_tencent_mm_protocal_c_cbe.pQt;
                return true;
            } else if ("WxaAppInfo".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = com_tencent_mm_protocal_c_cbe.pQt;
                try {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_cbe.pQt);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    m.a(wxaAttributes.field_appId, n.g(jSONObject).vHK);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = com_tencent_mm_protocal_c_cbe.pQt;
                return true;
            } else if ("BindWxaInfo".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = com_tencent_mm_protocal_c_cbe.pQt;
                return true;
            } else if ("WxaAppDynamic".equals(com_tencent_mm_protocal_c_cbe.vNj) && !aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_dynamicInfo)) {
                wxaAttributes.field_dynamicInfo = com_tencent_mm_protocal_c_cbe.pQt;
                return true;
            } else if (!"MMBizMenu".equals(com_tencent_mm_protocal_c_cbe.vNj) || aW(com_tencent_mm_protocal_c_cbe.pQt, wxaAttributes.field_bizMenu)) {
                return false;
            } else {
                wxaAttributes.field_bizMenu = com_tencent_mm_protocal_c_cbe.pQt;
                return true;
            }
        } else {
            wxaAttributes.field_signature = com_tencent_mm_protocal_c_cbe.pQt;
            return true;
        }
    }

    private static boolean aW(String str, String str2) {
        return bh.ou(str).equals(bh.ou(str2));
    }

    private boolean a(WxaAttributes wxaAttributes, String... strArr) {
        if (!bh.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, strArr);
    }
}
