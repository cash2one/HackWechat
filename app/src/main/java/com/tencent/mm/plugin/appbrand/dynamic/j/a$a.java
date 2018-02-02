package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.dynamic.launching.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c.a;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$a implements j<Bundle, WxaPkgWrappingInfo> {
    private a$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return p((Bundle) obj);
    }

    private static WxaPkgWrappingInfo p(Bundle bundle) {
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("pkgType");
        int i2 = bundle.getInt("pkgVersion");
        bundle.getInt("scene");
        String string3 = bundle.getString("searchId");
        ae a;
        String str;
        switch (i) {
            case 10000:
                return (WxaPkgWrappingInfo) ad.p(string2, i, i2).second;
            case 10001:
                if (new c(string2, "", "", (byte) 0).adc() == a.iUo - 1) {
                    ae a2 = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, i, new String[]{"downloadURL"});
                    if (a2 == null) {
                        x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string2, Integer.valueOf(i)});
                        return null;
                    }
                    try {
                        return new b(string, string2, string3, i, i2, b.iUh, a2.field_downloadURL).ada();
                    } catch (Exception e) {
                        x.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[]{string2, Integer.valueOf(i), e});
                        return null;
                    }
                }
                break;
            case 10100:
            case 10101:
                a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, i, new String[]{"downloadURL"});
                g.Dh();
                int Cg = com.tencent.mm.kernel.a.Cg();
                com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_aik = new aik();
                com_tencent_mm_protocal_c_aik.fFm = string2;
                com_tencent_mm_protocal_c_aik.wpH = Cg;
                caf com_tencent_mm_protocal_c_caf = new caf();
                switch (i) {
                    case 10100:
                        com_tencent_mm_protocal_c_caf.vOu = 1;
                        com_tencent_mm_protocal_c_caf.wZQ = 1;
                        break;
                    case 10101:
                        com_tencent_mm_protocal_c_caf.vOu = 2;
                        com_tencent_mm_protocal_c_caf.wZQ = 1;
                        break;
                    default:
                        com_tencent_mm_protocal_c_caf.vOu = 0;
                        com_tencent_mm_protocal_c_caf.wZQ = 0;
                        break;
                }
                if (a != null) {
                    com_tencent_mm_protocal_c_caf.fqR = a.field_versionMd5;
                } else {
                    com_tencent_mm_protocal_c_caf.fqR = "";
                }
                com_tencent_mm_protocal_c_aik.wpI = new LinkedList();
                com_tencent_mm_protocal_c_aik.wpI.add(com_tencent_mm_protocal_c_caf);
                aVar.hmj = com_tencent_mm_protocal_c_aik;
                aVar.hmk = new ail();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                aVar.hmi = 1186;
                com.tencent.mm.ae.a.a c = com.tencent.mm.plugin.appbrand.i.c.c(aVar.JZ());
                if (c.errType == 0 && c.errCode == 0) {
                    ail com_tencent_mm_protocal_c_ail = (ail) c.fJJ;
                    if (!(com_tencent_mm_protocal_c_ail == null || com_tencent_mm_protocal_c_ail.wpI == null || com_tencent_mm_protocal_c_ail.wpI.size() <= 0)) {
                        caf com_tencent_mm_protocal_c_caf2 = (caf) com_tencent_mm_protocal_c_ail.wpI.getFirst();
                        x.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_caf2.fqR, com_tencent_mm_protocal_c_caf2.url});
                        if (com_tencent_mm_protocal_c_caf2.url != null && com_tencent_mm_protocal_c_caf2.url.length() > 0) {
                            switch (i) {
                                case 10000:
                                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, 10000, com_tencent_mm_protocal_c_caf2.url, com_tencent_mm_protocal_c_caf2.fqR, 0, 0);
                                    break;
                                case 10001:
                                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, 10001, com_tencent_mm_protocal_c_caf2.url, com_tencent_mm_protocal_c_caf2.fqR, 0, 0);
                                    break;
                                case 10100:
                                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, 10100, com_tencent_mm_protocal_c_caf2.url, com_tencent_mm_protocal_c_caf2.fqR, 0, 0);
                                    break;
                                case 10101:
                                    ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, 10101, com_tencent_mm_protocal_c_caf2.url, com_tencent_mm_protocal_c_caf2.fqR, 0, 0);
                                    break;
                            }
                        }
                    }
                }
                x.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[]{Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.fnL, string2, Integer.valueOf(i)});
                return (WxaPkgWrappingInfo) ad.p(string2, i, i2).second;
            case 10102:
                try {
                    str = "";
                    a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, i, new String[]{"downloadURL", "version"});
                    if (a != null) {
                        str = a.field_downloadURL;
                        i2 = a.field_version;
                    }
                    return new b(string, string2, string3, i, i2, b.iUi, str).ada();
                } catch (Exception e2) {
                    x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e2});
                    break;
                }
            default:
                try {
                    str = "";
                    a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(string2, i, new String[]{"downloadURL", "version"});
                    if (a != null) {
                        str = a.field_downloadURL;
                        i2 = a.field_version;
                    }
                    return new b(string, string2, string3, i, i2, b.iUh, str).ada();
                } catch (Exception e22) {
                    x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e22});
                    break;
                }
        }
        return null;
    }
}
