package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ContactsSyncService$1 implements b {
    final /* synthetic */ ContactsSyncService ilb;

    ContactsSyncService$1(ContactsSyncService contactsSyncService) {
        this.ilb = contactsSyncService;
    }

    public final void bM(boolean z) {
        x.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            ar.CG().a(d.CTRL_INDEX, this.ilb);
            System.currentTimeMillis();
            ar.CG().a(new aa(m.NU(), m.NT()), 0);
            return;
        }
        ContactsSyncService.a(this.ilb);
    }
}
