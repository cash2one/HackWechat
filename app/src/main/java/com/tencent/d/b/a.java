package com.tencent.d.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.e.e;
import com.tencent.d.b.f.d;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.h;
import com.tencent.d.b.f.j;
import com.tencent.d.b.f.k;

public final class a {
    public static void a(b<c> bVar, boolean z, e eVar) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        d jVar = new j(eVar, z);
        jVar.Ada = bVar;
        if (!f.cGi().a(jVar, new c())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
    }

    public static void a(b<c> bVar, boolean z, int i, e eVar, e eVar2) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", new Object[]{Integer.valueOf(i)});
        d kVar = new k(i, eVar, eVar2, z, true);
        kVar.Ada = bVar;
        if (!f.cGi().a(kVar, new c())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
        }
    }

    public static void a(b<com.tencent.d.b.a.a> bVar, com.tencent.d.b.f.b bVar2) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", new Object[]{Integer.valueOf(bVar2.irz)});
        d hVar = new h(bVar2);
        hVar.Ada = bVar;
        if (!f.cGi().a(hVar, new com.tencent.d.b.a.a())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add requestAuthorizeAndSign task failed.", new Object[0]);
        }
    }

    public static boolean cFW() {
        return com.tencent.d.b.b.a.cFX().isInit() && com.tencent.d.b.b.a.cFX().cFW();
    }

    public static boolean Ia(int i) {
        boolean isInit = com.tencent.d.b.b.a.cFX().isInit();
        String str = (String) com.tencent.d.b.b.a.cFX().cFZ().get(i);
        if (isInit && !com.tencent.d.a.c.f.ov(str)) {
            return com.tencent.d.a.a.bs(str, false).errCode == 0;
        } else {
            if (isInit) {
                com.tencent.d.a.c.c.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
                return false;
            }
            com.tencent.d.a.c.c.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
            return false;
        }
    }
}
