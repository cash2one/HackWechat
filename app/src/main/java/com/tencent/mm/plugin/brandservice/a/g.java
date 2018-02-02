package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.bbm;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private static long kEJ = 0;
    private b gJQ;
    private e gJT;

    public static boolean asj() {
        return System.currentTimeMillis() - kEJ > 3600000;
    }

    public final int getType() {
        return 456;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        kEJ = System.currentTimeMillis();
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new ajl();
        aVar.hmk = new ajm();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.hmi = 456;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            ajm com_tencent_mm_protocal_c_ajm = (ajm) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_ajm.wqH.wAO > 0) {
                x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ajm.wqH.wAO)});
                try {
                    byte[] toByteArray = com_tencent_mm_protocal_c_ajm.wqH.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.FC()).append("search_biz_recommend").toString(), toByteArray, toByteArray.length);
                    Iterator it = com_tencent_mm_protocal_c_ajm.wqH.wHR.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((bbl) it.next()).wHQ.iterator();
                        while (it2.hasNext()) {
                            bfd com_tencent_mm_protocal_c_bfd = (bfd) it2.next();
                            h hVar = new h();
                            hVar.username = n.a(com_tencent_mm_protocal_c_bfd.vYI);
                            hVar.hly = com_tencent_mm_protocal_c_bfd.vUU;
                            hVar.hlx = com_tencent_mm_protocal_c_bfd.vUV;
                            hVar.fDt = -1;
                            hVar.fWe = 3;
                            hVar.bA(true);
                            com.tencent.mm.ad.n.JQ().a(hVar);
                        }
                    }
                } catch (Throwable e) {
                    x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    x.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                ar.Hg();
                com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(c.FC()).append("search_biz_recommend").toString());
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public static LinkedList<bbl> ask() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            byte[] e = com.tencent.mm.a.e.e(stringBuilder.append(c.FC()).append("search_biz_recommend").toString(), 0, Integer.MAX_VALUE);
            if (e != null) {
                bbm com_tencent_mm_protocal_c_bbm = new bbm();
                com_tencent_mm_protocal_c_bbm.aF(e);
                x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbm.wAO)});
                return com_tencent_mm_protocal_c_bbm.wHR;
            }
        } catch (Throwable e2) {
            x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2.getMessage());
            x.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2, "", new Object[0]);
        }
        return new LinkedList();
    }
}
