package com.tencent.mm.plugin.y;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> gwY;
    private static volatile a oZD;
    private com.tencent.mm.pluginsdk.model.app.c oZE;
    private com.tencent.mm.pluginsdk.model.app.e oZF;
    private h oZG;
    private i oZH;
    private k oZI;
    private m oZJ;
    private com.tencent.mm.pluginsdk.model.app.d oZK;
    private com.tencent.mm.sdk.b.c oZL = new 4(this);

    private a() {
        com.tencent.mm.plugin.y.a.a.a.a(new 1(this));
    }

    public static a bik() {
        if (oZD == null) {
            synchronized (a.class) {
                if (oZD == null) {
                    oZD = new a();
                }
            }
        }
        return oZD;
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        return linkedList;
    }

    public static String Ft() {
        return g.Dj().gQi + "openapi/";
    }

    public static com.tencent.mm.pluginsdk.model.app.c aqd() {
        g.Dh().Ct();
        if (bik().oZE == null) {
            bik().oZE = new com.tencent.mm.pluginsdk.model.app.c(g.Dj().gQj);
        }
        return bik().oZE;
    }

    public static com.tencent.mm.pluginsdk.model.app.e bil() {
        g.Dh().Ct();
        if (bik().oZF == null) {
            bik().oZF = new com.tencent.mm.pluginsdk.model.app.e();
        }
        return bik().oZF;
    }

    public static h bim() {
        g.Dh().Ct();
        if (bik().oZG == null) {
            bik().oZG = new h();
        }
        return bik().oZG;
    }

    public static i bin() {
        g.Dh().Ct();
        if (bik().oZH == null) {
            bik().oZH = new i(g.Dj().gQj);
        }
        return bik().oZH;
    }

    public static k bio() {
        g.Dh().Ct();
        if (bik().oZI == null) {
            bik().oZI = new k(g.Dj().gQj);
        }
        return bik().oZI;
    }

    public static m bip() {
        g.Dh().Ct();
        if (bik().oZJ == null) {
            bik().oZJ = new m();
        }
        return bik().oZJ;
    }

    public static com.tencent.mm.pluginsdk.model.app.d aRi() {
        g.Dh().Ct();
        if (bik().oZK == null) {
            bik().oZK = new com.tencent.mm.pluginsdk.model.app.d();
        }
        return bik().oZK;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.z.ab.a.hfJ = bim();
        com.tencent.mm.sdk.b.a.xef.b(this.oZL);
    }

    public void onAccountRelease() {
        com.tencent.mm.ae.e eVar = bik().oZG;
        if (eVar != null) {
            g.Di().gPJ.b(231, eVar);
            aRi().b(7, eVar);
        }
        com.tencent.mm.pluginsdk.model.app.e eVar2 = bik().oZF;
        if (eVar2 != null) {
            eVar2.vec.clear();
            eVar2.qkX.clear();
            eVar2.iUO.clear();
        }
        t tVar = bik().oZJ;
        if (tVar != null) {
            x.d("MicroMsg.AppSettingService", "stop service");
            tVar.vez.clear();
            aRi().b(1, tVar);
        }
        if (this.oZK != null) {
            eVar = this.oZK;
            g.Di().gPJ.b(452, eVar);
            eVar.hmZ.clear();
        }
        if (bik().oZH != null) {
            bik().oZH.veq.clear();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.oZL);
        x.i("XPinOpenApi", "onAccountRelease");
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new 2());
        gwY.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new 3());
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return gwY;
    }

    public void onDataBaseOpened(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
    }

    public void onDataBaseClosed(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
        this.oZE = null;
        this.oZH = null;
        x.i("XPinOpenApi", "onDataBaseClosed");
    }
}
