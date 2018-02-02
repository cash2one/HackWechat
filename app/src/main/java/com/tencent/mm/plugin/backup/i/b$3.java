package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<ad> {
    final /* synthetic */ b kuy;

    b$3(b bVar) {
        this.kuy = bVar;
        this.xen = ad.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ad adVar = (ad) bVar;
        x.i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
        b aeVar = new ae();
        aeVar.fnV.fnX = new a(adVar.fnU.activity);
        com.tencent.mm.sdk.b.a.xef.m(aeVar);
        aeVar = new ae();
        aeVar.fnV.fnX = new com.tencent.mm.plugin.backup.backupui.a(adVar.fnU.activity);
        com.tencent.mm.sdk.b.a.xef.m(aeVar);
        return false;
    }
}
