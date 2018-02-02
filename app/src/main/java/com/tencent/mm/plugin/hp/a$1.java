package com.tencent.mm.plugin.hp;

import com.tencent.mm.g.a.bd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<bd> {
    final /* synthetic */ a nAz;

    a$1(a aVar) {
        this.nAz = aVar;
        this.xen = bd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bd bdVar = (bd) bVar;
        if (29 == bdVar.fpq.fpm && bdVar.fpq.fpr == 0) {
            x.d("Tinker.HotPatchApplication", "hp_res received new hotpatch cache request");
            com.tencent.mm.plugin.hp.b.b.rh(0);
        }
        return false;
    }
}
