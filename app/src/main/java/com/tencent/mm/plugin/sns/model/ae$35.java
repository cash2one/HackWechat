package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class ae$35 extends c<nr> {
    final /* synthetic */ ae qWL;

    ae$35(ae aeVar) {
        this.qWL = aeVar;
        this.xen = nr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nr nrVar = (nr) bVar;
        final ArrayList arrayList = nrVar.fFH.fFI;
        final String str = nrVar.fFH.fFJ;
        x.i("MicroMsg.SnsCore", "ResendSnsByUpdateXmlEvent, try resend sns");
        ag.y(new Runnable(this) {
            final /* synthetic */ ae$35 qWS;

            public final void run() {
                ArrayList arrayList = arrayList;
                String str = str;
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int i = bh.getInt((String) it.next(), 0);
                        if (i != 0) {
                            m xo = ae.bvv().xo(i);
                            if (xo != null) {
                                bnp bxV = xo.bxV();
                                if (!(bxV == null || bxV.wQo == null || bxV.wQo.vYc != 26)) {
                                    bxV.wQo.vYf = str;
                                    ae.bvv().b(i, xo);
                                    b nsVar = new ns();
                                    nsVar.fFK.fFL = i;
                                    a.xef.m(nsVar);
                                }
                            }
                        }
                    }
                }
            }
        });
        return false;
    }
}
