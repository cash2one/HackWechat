package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.e.c;

class j$1 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ int iJO;
    final /* synthetic */ long iJP;
    final /* synthetic */ j iJQ;

    public j$1(j jVar, String str, int i, long j) {
        this.iJQ = jVar;
        this.gIT = str;
        this.iJO = i;
        this.iJP = j;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (!(i == 0 && i2 == 0 && ((bpu) bVar.hmh.hmo).vVA.lOr == 0) && j.a(this.iJQ).isOpen()) {
            c com_tencent_mm_plugin_appbrand_appusage_j_a = new j$a();
            com_tencent_mm_plugin_appbrand_appusage_j_a.field_username = this.gIT;
            com_tencent_mm_plugin_appbrand_appusage_j_a.field_versionType = this.iJO;
            com_tencent_mm_plugin_appbrand_appusage_j_a.field_updateTime = this.iJP;
            j.b(this.iJQ).a(com_tencent_mm_plugin_appbrand_appusage_j_a, false, new String[]{"updateTime", "username", "versionType"});
            if (!this.iJQ.an(this.gIT, this.iJO)) {
                this.iJQ.b("single", 3, com_tencent_mm_plugin_appbrand_appusage_j_a);
            }
        }
        return 0;
    }
}
