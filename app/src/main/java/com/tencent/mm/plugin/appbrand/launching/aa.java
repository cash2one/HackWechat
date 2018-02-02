package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.v.g;
import java.util.List;
import org.json.JSONObject;

public class aa extends x<WxaPkgWrappingInfo> implements j {
    public static volatile boolean jym = false;
    private final j jyn;

    public /* synthetic */ Object call() {
        return ada();
    }

    aa(String str, int i, String str2, int i2, d dVar) {
        Object obj;
        List list;
        String str3;
        int i3;
        Object obj2 = 1;
        List list2 = null;
        if (d$a.jv(i)) {
            obj = (dVar.iPJ || (jym && !bh.cA(dVar.iPI))) ? 1 : null;
            list = dVar.iPI;
            str3 = dVar.iPK;
            i3 = dVar.iPH;
        } else {
            JSONObject fy;
            String str4;
            try {
                fy = g.fy(((i) f.u(i.class)).aE(str, i));
            } catch (Exception e) {
                fy = null;
            }
            if (fy == null) {
                str4 = null;
                obj2 = null;
            } else {
                list2 = e.rc(fy.optString("module_list"));
                if (bh.cA(list2)) {
                    obj2 = null;
                }
                str4 = obj2 != null ? fy.optString("entrance_module") : "";
            }
            list = list2;
            str3 = str4;
            i3 = 0;
            obj = obj2;
        }
        if (obj == null || bh.cA(list) || !h.ZI()) {
            this.jyn = new 2(this, str, i, dVar.fIm, i2, dVar);
        } else {
            this.jyn = new 1(this, str, i, str2, i2, dVar.fIm, i3, str3, list);
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
    }

    public void ahO() {
    }

    public void ahQ() {
    }

    public void kO(int i) {
    }

    public final WxaPkgWrappingInfo ada() {
        return (WxaPkgWrappingInfo) this.jyn.call();
    }
}
