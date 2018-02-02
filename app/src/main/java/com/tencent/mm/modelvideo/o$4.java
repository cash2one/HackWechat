package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$4 implements Runnable {
    final /* synthetic */ o hVy;

    o$4(o oVar) {
        this.hVy = oVar;
    }

    public final void run() {
        if (g.Dh().Cy()) {
            s TU = o.TU();
            x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[]{"UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status" + " = 200"});
            TU.hhp.fx("videoinfo2", r1);
            o.TY().gJP.fx("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
            l TY = o.TY();
            if (1209600000 <= 0) {
                x.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                TY.gJP.fx("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
            } else {
                x.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[]{Long.valueOf(bh.Wp() - 1209600000)});
                TY.gJP.fx("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + r2);
            }
            for (j jVar : o.TY().TP()) {
                x.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[]{jVar.field_fileName});
                b.deleteFile(k.nk(jVar.field_fileName));
                b.deleteFile(k.nl(jVar.field_fileName));
            }
        }
    }
}
