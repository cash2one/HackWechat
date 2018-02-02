package com.tencent.mm.plugin.sns.model;

import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class ae$27 extends c<ni> {
    final /* synthetic */ ae qWL;

    ae$27(ae aeVar) {
        this.qWL = aeVar;
        this.xen = ni.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ni niVar = (ni) bVar;
        SnsAdClick snsAdClick = niVar.fFq.fFe;
        if (niVar.fFq.fFr == 1) {
            com.tencent.mm.modelsns.b iv;
            if (snsAdClick.hOA == 1) {
                Object[] objArr;
                int i;
                int bxU;
                i iVar;
                int i2;
                Object[] objArr2;
                e eK = ae.bvy().eK(snsAdClick.hOu);
                i bvp;
                if (eK == null || !eK.bwE()) {
                    bvp = ae.bvp();
                    objArr = new Object[7];
                    objArr[0] = com.tencent.mm.plugin.sns.data.i.eq(snsAdClick.hOu);
                    objArr[1] = snsAdClick.hOv;
                    objArr[2] = Integer.valueOf(snsAdClick.scene);
                    objArr[3] = Long.valueOf(snsAdClick.hOy);
                    objArr[4] = Long.valueOf(System.currentTimeMillis());
                    i = 5;
                    if (eK != null) {
                        bxU = eK.bxU();
                        iVar = bvp;
                        i2 = 13155;
                        objArr2 = objArr;
                    } else {
                        bxU = -1;
                        iVar = bvp;
                        i2 = 13155;
                        objArr2 = objArr;
                    }
                } else {
                    bvp = ae.bvp();
                    objArr = new Object[7];
                    objArr[0] = com.tencent.mm.plugin.sns.data.i.eq(snsAdClick.hOu);
                    objArr[1] = snsAdClick.hOv;
                    objArr[2] = Integer.valueOf(snsAdClick.scene);
                    objArr[3] = Long.valueOf(snsAdClick.hOy);
                    objArr[4] = Long.valueOf(System.currentTimeMillis());
                    i = 5;
                    bxU = eK.bxU();
                    iVar = bvp;
                    i2 = 14647;
                    objArr2 = objArr;
                }
                objArr[i] = Integer.valueOf(bxU);
                objArr2[6] = "";
                iVar.h(i2, objArr2);
                iv = com.tencent.mm.modelsns.b.iv(750);
                iv.mB(com.tencent.mm.plugin.sns.data.i.eq(snsAdClick.hOu)).mB(snsAdClick.hOv).ix(snsAdClick.scene).mB(snsAdClick.hOy).mB(System.currentTimeMillis());
                iv.Sx();
            } else {
                e eK2 = ae.bvy().eK(snsAdClick.hOu);
                long lS = !bh.ov(snsAdClick.hOw) ? com.tencent.mm.plugin.sns.data.i.lS(snsAdClick.hOw) : snsAdClick.hOu;
                String str = !bh.ov(snsAdClick.hOw) ? snsAdClick.hOw : snsAdClick.hOu;
                String str2 = (f.a(lS, new Object[]{str, snsAdClick.hOv, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.hOy), Long.valueOf(System.currentTimeMillis())}) + String.format(",%s", new Object[]{snsAdClick.hOB})) + String.format(",%s", new Object[]{((System.currentTimeMillis() - snsAdClick.hOy) - snsAdClick.hOD)});
                if (eK2 == null || !eK2.bwE()) {
                    ae.bvp().h(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED, new Object[]{str2});
                } else {
                    ae.bvp().h(14643, new Object[]{str2});
                }
                iv = com.tencent.mm.modelsns.b.iv(733);
                iv.mB(com.tencent.mm.plugin.sns.data.i.eq(snsAdClick.hOu)).mB(snsAdClick.hOv).ix(snsAdClick.scene).mB(snsAdClick.hOy).mB(System.currentTimeMillis());
                iv.Sx();
            }
        }
        return false;
    }
}
