package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

class a$3 implements b {
    final /* synthetic */ a ikX;

    a$3(a aVar) {
        this.ikX = aVar;
    }

    public final void bM(boolean z) {
        x.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            return;
        }
        if (m.NU().size() > 0) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
            ar.CG().a(d.CTRL_INDEX, this.ikX);
            System.currentTimeMillis();
            ar.CG().a(new aa(m.NU(), m.NT()), 0);
            return;
        }
        x.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        String[] strArr = (String[]) this.ikX.ikU.toArray(new String[0]);
        this.ikX.ikU.clear();
        List arrayList = new ArrayList();
        for (String kR : strArr) {
            com.tencent.mm.modelfriend.b kR2 = af.OD().kR(kR);
            if (kR2 == null || bh.ov(kR2.Nz())) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[]{kR});
            } else {
                arrayList.add(kR2.Nz());
                x.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[]{kR2.Nz(), kR});
            }
        }
        ar.CG().a(32, this.ikX);
        if (arrayList.size() == 0) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
            ar.CG().a(new v(), 0);
            return;
        }
        x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[]{Integer.valueOf(arrayList.size())});
        ar.CG().a(new v(arrayList, null), 0);
    }
}
