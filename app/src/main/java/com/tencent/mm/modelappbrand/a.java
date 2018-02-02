package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean it(String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject == null || optJSONObject.optInt("openWxaByBizQRCode", 0) <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static void a(qp qpVar, com.tencent.mm.y.g.a aVar) {
        qpVar.fIi.appId = aVar.hdy;
        qpVar.fIi.userName = aVar.hdx;
        qpVar.fIi.fIk = aVar.hdw;
        qpVar.fIi.fIl = aVar.hdE;
        qpVar.fIi.fIn = aVar.hdA;
        qpVar.fIi.fIm = aVar.hdF;
        qpVar.fIi.fIo = aVar.hdE != 0;
    }

    public static void a(String str, String str2, boolean z, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        b qpVar = new qp();
        a(qpVar, aVar);
        qpVar.fIi.scene = z ? 1008 : 1007;
        qpVar.fIi.fnp = str + (z ? ":" + str2 : "") + ":" + aVar.hdC;
        qpVar.fIi.fqh = bundle;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    public static void a(String str, int i, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        b qpVar = new qp();
        a(qpVar, aVar);
        qpVar.fIi.scene = i;
        if (i == 1074) {
            qpVar.fIi.fnp = str;
        }
        qpVar.fIi.fqh = bundle;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    public static void b(String str, String str2, boolean z, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        b qpVar = new qp();
        a(qpVar, aVar);
        qpVar.fIi.scene = 1044;
        qpVar.fIi.fnp = aVar.hdC;
        qpVar.fIi.fIs = z ? 2 : 1;
        com.tencent.mm.g.a.qp.a aVar2 = qpVar.fIi;
        if (z) {
            str2 = str;
        }
        aVar2.fIt = str2;
        qpVar.fIi.fIq.hjA = aVar.hdD;
        if (bh.ov(aVar.hdD)) {
            qpVar.fIi.fIq.hjz = null;
        } else {
            qpVar.fIi.fIq.hjz = str;
        }
        qpVar.fIi.fqh = bundle;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    public static boolean IT() {
        if (!g.Dh().Cy()) {
            return false;
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100360");
        if (fn.isValid() && "1".equals(fn.chI().get("isOpenFTSSearchMiniGameEntry"))) {
            return true;
        }
        return false;
    }
}
