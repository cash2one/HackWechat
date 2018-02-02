package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.av.a.a;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

class ae$32 extends c<jr> {
    final /* synthetic */ ae qWL;

    ae$32(ae aeVar) {
        this.qWL = aeVar;
        this.xen = jr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jr jrVar = (jr) bVar;
        if (jrVar instanceof jr) {
            switch (jrVar.fAt.action) {
                case -6:
                    List<m> aH = ae.bvv().aH(jrVar.fAt.fAv.wAy, q.FS().equals(jrVar.fAt.fAv.wAy));
                    jrVar.fAu.fvF = new ArrayList();
                    for (m bxV : aH) {
                        jrVar.fAu.fvF.add(((a) g.h(a.class)).a(ae.FC(), bxV.bxV(), 8));
                    }
                    break;
                case -5:
                    n bvv = ae.bvv();
                    Cursor a = bvv.gJP.a("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + n.roZ, null, 2);
                    List<m> arrayList = new ArrayList();
                    while (a.moveToNext()) {
                        m mVar = new m();
                        mVar.b(a);
                        arrayList.add(mVar);
                    }
                    a.close();
                    jrVar.fAu.fvF = new ArrayList();
                    for (m bxV2 : arrayList) {
                        jrVar.fAu.fvF.add(((a) g.h(a.class)).a(ae.FC(), bxV2.bxV(), 1));
                    }
                    break;
            }
        }
        return false;
    }
}
