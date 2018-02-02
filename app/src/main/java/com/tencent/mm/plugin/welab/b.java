package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.plugin.welab.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b tPw = new b();
    public a tPx;
    public Map<String, com.tencent.mm.plugin.welab.a.a.b> tPy = new HashMap();
    public com.tencent.mm.plugin.welab.a.a.b tPz;
    public c tlo;

    public b() {
        c.a aVar = new c.a();
        aVar.hDA = true;
        aVar.hDz = true;
        this.tlo = aVar.PK();
    }

    public static b bVu() {
        return tPw;
    }

    public static String a(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b Qv = tPw.Qv(aVar.field_LabsAppId);
        if (Qv != null) {
            str = aVar.field_LabsAppId;
            str = Qv.bVD();
            x.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.QD("field_Title");
        }
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b Qv = tPw.Qv(aVar.field_LabsAppId);
        if (Qv != null) {
            str = aVar.field_LabsAppId;
            str = Qv.bVC();
            x.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.field_Icon;
        }
        return str;
    }

    private com.tencent.mm.plugin.welab.a.a.b Qv(String str) {
        return (com.tencent.mm.plugin.welab.a.a.b) this.tPy.get(str);
    }

    public static void L(boolean z, boolean z2) {
        f.M(z, z2);
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bVv() {
        List<com.tencent.mm.plugin.welab.c.a.a> bVE = this.tPx.bVE();
        Iterator it = bVE.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = (com.tencent.mm.plugin.welab.c.a.a) it.next();
            if (!aVar.isRunning() || (!(aVar.field_Switch == 2 || aVar.field_Switch == 1) || "labs1de6f3".equals(aVar.field_LabsAppId))) {
                it.remove();
            }
        }
        return bVE;
    }

    public final com.tencent.mm.plugin.welab.c.a.a Qw(String str) {
        a aVar = this.tPx;
        com.tencent.mm.sdk.e.c aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = str;
        aVar.b(aVar2, new String[0]);
        return aVar2;
    }
}
