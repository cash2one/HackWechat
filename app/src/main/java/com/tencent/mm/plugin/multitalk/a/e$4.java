package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.g.a.jq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$4 extends c<jq> {
    final /* synthetic */ e oGz;

    e$4(e eVar) {
        this.oGz = eVar;
        this.xen = jq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jq jqVar = (jq) bVar;
        if (jqVar instanceof jq) {
            jq.b bVar2;
            boolean bct;
            switch (jqVar.fAq.action) {
                case 1:
                    bVar2 = jqVar.fAr;
                    bct = this.oGz.bct();
                    break;
                case 2:
                    bVar2 = jqVar.fAr;
                    e eVar = this.oGz;
                    if (eVar.oGq == null) {
                        bct = false;
                        break;
                    }
                    bct = eVar.oGq.bbT();
                    break;
            }
            bVar2.fAs = bct;
        }
        return false;
    }
}
