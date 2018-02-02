package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ad.a;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.Closeable;
import java.io.File;
import org.json.JSONArray;

public final class f {
    public static WxaPkgWrappingInfo sZ(String str) {
        int i = 1;
        int[] pM = com.tencent.mm.plugin.appbrand.app.f.Zo().pM(str);
        if (pM != null && pM.length > 1) {
            while (true) {
                int i2 = i + 1;
                Pair p = ad.p(str, 0, pM[i]);
                if (p != null && p.first == a.iFU && p.second != null) {
                    return (WxaPkgWrappingInfo) p.second;
                }
                if (i2 >= pM.length) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }

    static boolean bq(String str, String str2) {
        boolean z = true;
        if (bh.ov(str) || !e.bO(str)) {
            return false;
        }
        z zVar = new z(new File(str));
        if (!zVar.ZX()) {
            zVar.close();
            return false;
        } else if (bh.ov(str2)) {
            zVar.close();
            return false;
        } else {
            Closeable pI = zVar.pI(l.uB(str2));
            if (pI != null) {
                bh.d(pI);
            } else {
                String convertStreamToString = c.convertStreamToString(zVar.pI("app-config.json"));
                if (!bh.ov(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = g.fy(convertStreamToString).getJSONArray("pages");
                        String py = com.tencent.mm.plugin.appbrand.appcache.a.py(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (string.equals(str2) || string.equals(py)) {
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", new Object[]{str, str2, e});
                    }
                }
                z = false;
            }
            zVar.close();
            return z;
        }
    }
}
