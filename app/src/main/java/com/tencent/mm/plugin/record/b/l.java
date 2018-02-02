package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends c<mt> {
    public l() {
        this.xen = mt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mt mtVar = (mt) bVar;
        x.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", new Object[]{Integer.valueOf(mtVar.fEE.type)});
        switch (mtVar.fEE.type) {
            case 0:
                mtVar.fEF.fEO = h.Ik(mtVar.fEE.fEG);
                break;
            case 1:
                x.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", new Object[]{Long.valueOf(mtVar.fEE.fqm)});
                mtVar.fEF.fEQ = h.d(mtVar.fEE.fve, mtVar.fEE.fqm);
                mtVar.fEF.fEP = h.c(mtVar.fEE.fve, mtVar.fEE.fqm);
                mtVar.fEF.fER = h.e(mtVar.fEE.fve, mtVar.fEE.fqm);
                mtVar.fEF.fvC = h.f(mtVar.fEE.fve, mtVar.fEE.fqm);
                break;
            case 2:
                x.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", new Object[]{mtVar.fEE.toUser, mtVar.fEE.fvC, Integer.valueOf(mtVar.fEE.fEI)});
                h.a(mtVar.fEE.toUser, mtVar.fEE.fEH, mtVar.fEE.title, mtVar.fEE.desc, mtVar.fEE.fvC, mtVar.fEE.fEI, mtVar.fEE.fEM);
                break;
            case 3:
                x.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", new Object[]{Long.valueOf(mtVar.fEE.fqm)});
                h.ec(mtVar.fEE.fqm);
                break;
            case 4:
                x.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", new Object[]{mtVar.fEE.toUser, Long.valueOf(mtVar.fEE.fEJ.field_msgId)});
                h.a(mtVar.fEE.toUser, mtVar.fEE.fvw, mtVar.fEE.fEJ);
                break;
            case 5:
                x.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", new Object[]{mtVar.fEE.toUser});
                h.a(mtVar.fEE.context, mtVar.fEE.toUser, mtVar.fEE.fEL, mtVar.fEE.fEK, mtVar.fEE.fEg, mtVar.fEE.fEN);
                break;
            case 6:
                cf cfVar = new cf();
                h.a(mtVar.fEE.context, cfVar, mtVar.fEE.fEL, mtVar.fEE.fEK, true, true);
                d a = h.a(mtVar.fEE.context, cfVar, mtVar.fEE.fEL);
                mtVar.fEF.fEg = cfVar;
                mtVar.fEF.fEN = a;
                break;
            case 8:
                if (!bh.ov(mtVar.fEE.fvC)) {
                    h.b(mtVar.fEE.fve, mtVar.fEE.fqm, true);
                    break;
                }
                h.a(mtVar.fEE.fve, mtVar.fEE.fqm, true);
                break;
            case 9:
                mtVar.fEF.fEQ = h.g(mtVar.fEE.fve, mtVar.fEE.fqm);
                break;
        }
        return false;
    }
}
