package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g$a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;
    private int mqB = 0;
    private int mqx = 0;
    String pEW = "";
    g pEX = null;
    private SparseArray<uq> pEY = new SparseArray();
    private SparseBooleanArray pEZ = new SparseBooleanArray();

    public a(g gVar) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new gg();
        aVar.hmk = new gh();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.hmi = 632;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.pEX = gVar;
    }

    private void bmO() {
        this.pEW = g$a.a(h.a(this.pEX.field_title, this.pEX.field_desc, this.pEX.field_dataProto), null, null);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mqB), Integer.valueOf(this.mqx), str});
        if (i2 == 3 && this.mqB == -100) {
            bmO();
            this.gJT.a(0, 0, str, this);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((gh) ((b) qVar).hmh.hmo).ksP.iterator();
            while (it.hasNext()) {
                bof com_tencent_mm_protocal_c_bof = (bof) it.next();
                uq uqVar = (uq) this.pEY.get(com_tencent_mm_protocal_c_bof.wQM);
                if (uqVar != null) {
                    if (this.pEZ.get(com_tencent_mm_protocal_c_bof.wQM)) {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bof.wQM), uqVar.mvG, uqVar.hbj, com_tencent_mm_protocal_c_bof.vQE, Long.valueOf(uqVar.wdp), Long.valueOf(com_tencent_mm_protocal_c_bof.wQO)});
                        uqVar.Ts(com_tencent_mm_protocal_c_bof.vQE);
                        uqVar.Tt(com_tencent_mm_protocal_c_bof.vZO);
                        if (bh.ov(com_tencent_mm_protocal_c_bof.vQE) || bh.ov(com_tencent_mm_protocal_c_bof.vZO) || com_tencent_mm_protocal_c_bof.wQO <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            uqVar.fx(com_tencent_mm_protocal_c_bof.wQO);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bof.wQM), uqVar.mvG, uqVar.wcJ, com_tencent_mm_protocal_c_bof.vQE, Long.valueOf(uqVar.wde), Long.valueOf(com_tencent_mm_protocal_c_bof.wQO)});
                        uqVar.Tu(com_tencent_mm_protocal_c_bof.vQE);
                        uqVar.Tv(com_tencent_mm_protocal_c_bof.vZO);
                        if (bh.ov(com_tencent_mm_protocal_c_bof.vQE) || bh.ov(com_tencent_mm_protocal_c_bof.vZO) || com_tencent_mm_protocal_c_bof.wQO <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            uqVar.fw(com_tencent_mm_protocal_c_bof.wQO);
                        }
                    }
                }
            }
            x.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(this.mqx < this.pEX.field_dataProto.weU.size())});
            if (this.mqx < this.pEX.field_dataProto.weU.size()) {
                obj = a(this.hmA, this.gJT) == -100 ? 1 : null;
            } else {
                int i4 = 1;
            }
            if (obj != null) {
                x.i("MicroMsg.NetSceneTransCDN", "do callback");
                bmO();
                this.gJT.a(i2, i3, str, this);
            }
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 632;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        gg ggVar = (gg) this.gJQ.hmg.hmo;
        this.pEY.clear();
        this.pEZ.clear();
        if (this.pEX.field_dataProto.weU.size() == 0) {
            x.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.mqB = -100;
            return -100;
        }
        Collection linkedList = new LinkedList();
        int i = this.mqx;
        while (i < this.pEX.field_dataProto.weU.size()) {
            uq uqVar = (uq) this.pEX.field_dataProto.weU.get(i);
            if (this.pEX.field_type != 14 || uqVar.bjS != 3) {
                if (uqVar.wdb && bh.ov(uqVar.wcJ)) {
                    Object obj = null;
                    break;
                }
                bof com_tencent_mm_protocal_c_bof;
                if (!bh.ov(uqVar.wcJ)) {
                    com_tencent_mm_protocal_c_bof = new bof();
                    com_tencent_mm_protocal_c_bof.vQE = uqVar.wcJ;
                    com_tencent_mm_protocal_c_bof.vZO = uqVar.wcL;
                    com_tencent_mm_protocal_c_bof.wQN = uqVar.bjS;
                    com_tencent_mm_protocal_c_bof.wQO = (long) ((int) uqVar.wde);
                    com_tencent_mm_protocal_c_bof.wQM = bh.az(uqVar.mvG, "").hashCode();
                    x.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bof.wQM), uqVar.mvG, Integer.valueOf(com_tencent_mm_protocal_c_bof.wQN), uqVar.wcJ, Long.valueOf(uqVar.wde)});
                    linkedList.add(com_tencent_mm_protocal_c_bof);
                    this.pEY.put(com_tencent_mm_protocal_c_bof.wQM, uqVar);
                    this.pEZ.put(com_tencent_mm_protocal_c_bof.wQM, false);
                }
                if (!bh.ov(uqVar.hbj)) {
                    com_tencent_mm_protocal_c_bof = new bof();
                    com_tencent_mm_protocal_c_bof.vQE = uqVar.hbj;
                    com_tencent_mm_protocal_c_bof.vZO = uqVar.wcF;
                    com_tencent_mm_protocal_c_bof.wQN = 2;
                    com_tencent_mm_protocal_c_bof.wQO = (long) ((int) uqVar.wdp);
                    com_tencent_mm_protocal_c_bof.wQM = (bh.az(uqVar.mvG, "") + "@thumb").hashCode();
                    x.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bof.wQM), uqVar.mvG, Integer.valueOf(com_tencent_mm_protocal_c_bof.wQN), uqVar.hbj, Long.valueOf(uqVar.wdp)});
                    linkedList.add(com_tencent_mm_protocal_c_bof);
                    this.pEY.put(com_tencent_mm_protocal_c_bof.wQM, uqVar);
                    this.pEZ.put(com_tencent_mm_protocal_c_bof.wQM, true);
                }
                if (linkedList.size() >= 20) {
                    break;
                }
            } else {
                x.w("MicroMsg.NetSceneTransCDN", "match voice type, clear cdn info");
                uqVar.Tv("");
                uqVar.Tu("");
                uqVar.Tt("");
                uqVar.Ts("");
            }
            i++;
        }
        int i2 = 1;
        this.mqx = i + 1;
        ggVar.ksO = linkedList.size();
        ggVar.ksP.clear();
        ggVar.ksP.addAll(linkedList);
        x.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[]{Integer.valueOf(this.pEX.field_dataProto.weU.size()), Integer.valueOf(this.pEY.size()), Integer.valueOf(this.mqx)});
        if (ggVar.ksO > 0 && r1 != null) {
            return a(eVar, this.gJQ, this);
        }
        bmO();
        x.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.mqB = -100;
        return -100;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }
}
