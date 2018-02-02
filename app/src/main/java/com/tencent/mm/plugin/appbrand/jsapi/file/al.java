package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import org.json.JSONObject;

final class al extends d {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jjG = new int[j.values().length];

        static {
            try {
                jjG[j.iIz.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jjG[j.iIt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jjG[j.iIB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    al() {
    }

    final f$a a(com.tencent.mm.plugin.appbrand.j jVar, String str, JSONObject jSONObject) {
        boolean z = true;
        j pU = jVar.irP.iqz.pU(str);
        switch (AnonymousClass1.jjG[pU.ordinal()]) {
            case 1:
                return new f$a("fail no such file or directory \"%s\"", str);
            case 2:
            case 3:
                f$a com_tencent_mm_plugin_appbrand_jsapi_file_f_a = new f$a("ok", new Object[0]);
                String str2 = "result";
                if (pU != j.iIt) {
                    z = false;
                }
                return com_tencent_mm_plugin_appbrand_jsapi_file_f_a.s(str2, Boolean.valueOf(z));
            default:
                return new f$a("fail " + pU.name(), new Object[0]);
        }
    }
}
