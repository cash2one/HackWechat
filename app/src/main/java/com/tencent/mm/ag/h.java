package com.tencent.mm.ag;

import com.tencent.mm.ad.i;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h implements e {
    Object hpF = new Object();
    Set<String> hpG = new HashSet();
    public LinkedList<a> hpH = new LinkedList();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar) {
        synchronized (this.hpF) {
            if (!this.hpH.contains(aVar)) {
                Iterator it = this.hpH.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) it.next();
                    if (aVar != null && aVar2 != null && bh.ou(aVar.LX()).equals(bh.ou(aVar2.LX()))) {
                        x.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[]{aVar.LX()});
                        return;
                    }
                }
                this.hpH.add(aVar);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.hpF) {
            if (this.hpH.contains(aVar)) {
                this.hpH.remove(aVar);
            }
        }
    }

    public final void af(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[]{str, str2});
        } else if (this.hpG.contains(str2)) {
            x.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[]{str2});
        } else {
            this.hpG.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            k vVar = new v(str, linkedList);
            vVar.tag = str2;
            g.Di().gPJ.a(vVar, 0);
            x.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", new Object[]{str, str2, Integer.valueOf(this.hpH.size())});
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.e("MicroMsg.BizKFService", "scene == null");
            b(null);
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            i JQ = n.JQ();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            cai com_tencent_mm_protocal_c_cai;
            com.tencent.mm.ad.h hVar;
            if (kVar.getType() == 672) {
                if (((u) kVar).Mb() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[]{Integer.valueOf(kVar.getType())});
                    b(null);
                    return;
                }
                linkedList3 = ((u) kVar).Mb().wus;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_cai = (cai) it.next();
                    linkedList.add(new g(com_tencent_mm_protocal_c_cai.wZT, ((u) kVar).hqf, com_tencent_mm_protocal_c_cai.nfZ, com_tencent_mm_protocal_c_cai.wvW, 1, currentTimeMillis));
                    if (JQ != null) {
                        hVar = new com.tencent.mm.ad.h();
                        hVar.username = com_tencent_mm_protocal_c_cai.wZT;
                        hVar.hlx = com_tencent_mm_protocal_c_cai.nfZ;
                        hVar.bA(false);
                        hVar.fWe = 3;
                        JQ.a(hVar);
                        n.JS().iZ(com_tencent_mm_protocal_c_cai.wZT);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 675) {
                this.hpG.remove(((v) kVar).tag);
                if (((v) kVar).Mc() == null) {
                    x.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[]{Integer.valueOf(kVar.getType())});
                    b(null);
                    return;
                }
                linkedList3 = ((v) kVar).Mc().wus;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_cai = (cai) it.next();
                    x.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", new Object[]{com_tencent_mm_protocal_c_cai.wZT, ((v) kVar).tag});
                    linkedList.add(new g(com_tencent_mm_protocal_c_cai.wZT, ((v) kVar).hqf, com_tencent_mm_protocal_c_cai.nfZ, com_tencent_mm_protocal_c_cai.wvW, ((v) kVar).hqg, currentTimeMillis));
                    if (JQ != null) {
                        hVar = new com.tencent.mm.ad.h();
                        hVar.username = com_tencent_mm_protocal_c_cai.wZT;
                        hVar.hlx = com_tencent_mm_protocal_c_cai.nfZ;
                        hVar.bA(false);
                        hVar.fWe = 3;
                        JQ.a(hVar);
                        n.JS().iZ(com_tencent_mm_protocal_c_cai.wZT);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 674) {
                if (((t) kVar).Ma() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[]{Integer.valueOf(kVar.getType())});
                    b(null);
                    return;
                }
                linkedList3 = ((t) kVar).Ma().wus;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_cai = (cai) it.next();
                    linkedList.add(new g(com_tencent_mm_protocal_c_cai.wZT, ((t) kVar).hqf, com_tencent_mm_protocal_c_cai.nfZ, com_tencent_mm_protocal_c_cai.wvW, 2, currentTimeMillis));
                    if (JQ != null) {
                        hVar = new com.tencent.mm.ad.h();
                        hVar.username = com_tencent_mm_protocal_c_cai.wZT;
                        hVar.hlx = com_tencent_mm_protocal_c_cai.nfZ;
                        hVar.bA(false);
                        hVar.fWe = 3;
                        JQ.a(hVar);
                        n.JS().iZ(com_tencent_mm_protocal_c_cai.wZT);
                    }
                }
                linkedList2 = linkedList3;
            }
            x.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[]{Integer.valueOf(y.Me().d(linkedList))});
            b(linkedList2);
        } else {
            x.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            b(null);
            if (kVar.getType() == 675) {
                this.hpG.remove(((v) kVar).tag);
            }
        }
    }

    private void b(LinkedList<cai> linkedList) {
        synchronized (this.hpF) {
            ArrayList arrayList = new ArrayList(this.hpH);
            for (int i = 0; i < arrayList.size(); i++) {
                a aVar = (a) arrayList.get(i);
                if (aVar != null) {
                    aVar.c(linkedList);
                }
            }
        }
    }
}
