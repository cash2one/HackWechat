package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements e {
    boolean hOj = false;
    b huW = new 3(this);
    Set<String> ikU = Collections.synchronizedSet(new HashSet());
    public c ikV = new 1(this);
    af ikW = new 2(this);

    public a() {
        com.tencent.mm.sdk.b.a.xef.b(this.ikV);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == d.CTRL_INDEX) {
            ar.CG().b(d.CTRL_INDEX, this);
            if (i == 0 && i2 == 0) {
                ar.CG().a(32, this);
                aa aaVar = (aa) kVar;
                ar.CG().a(new v(aaVar.hwE, aaVar.hwF), 0);
            } else {
                x.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.hOj = false;
            }
        }
        if (kVar.getType() == 32) {
            this.hOj = false;
            ar.CG().b(32, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                com.tencent.mm.modelsimple.d.bs(ac.getContext());
                return;
            }
            x.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
    }
}
