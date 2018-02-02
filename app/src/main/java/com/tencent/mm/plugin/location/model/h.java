package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public String fnL;
    public int fut;
    public final b gJQ;
    private e gJT;
    private Runnable hOe;
    public String iRN;
    public boolean kMn = false;
    public List<f> list = new ArrayList();
    public byte[] nQM;
    public byte[] nQN = null;
    public String nQO = "";
    public int nQP;

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new ady();
        aVar.hmk = new adz();
        aVar.hmk = new adz();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.hmi = 457;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ady com_tencent_mm_protocal_c_ady = (ady) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ady.wlO = bArr == null ? new bdn() : new bdn().bj(bArr);
        com_tencent_mm_protocal_c_ady.wgS = str2;
        com_tencent_mm_protocal_c_ady.vNP = d;
        com_tencent_mm_protocal_c_ady.vNO = d2;
        com_tencent_mm_protocal_c_ady.rYW = i;
        com_tencent_mm_protocal_c_ady.vDW = i2;
        com_tencent_mm_protocal_c_ady.wmu = d4;
        com_tencent_mm_protocal_c_ady.wmt = d3;
        com_tencent_mm_protocal_c_ady.wlQ = 1;
        this.fut = com_tencent_mm_protocal_c_ady.vDW;
        this.nQO = str;
        this.nQM = bArr;
        x.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f" + bArr, new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.fnL = str;
        adz com_tencent_mm_protocal_c_adz = (adz) this.gJQ.hmh.hmo;
        this.list.clear();
        x.d("MicroMsg.NetSceneGetPoiList", "url " + com_tencent_mm_protocal_c_adz.wlX + " " + com_tencent_mm_protocal_c_adz.weY + " " + com_tencent_mm_protocal_c_adz.nfX + " " + com_tencent_mm_protocal_c_adz.vPs);
        x.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adz.wlY)});
        this.iRN = com_tencent_mm_protocal_c_adz.vPs;
        this.nQP = com_tencent_mm_protocal_c_adz.wlY;
        if (com_tencent_mm_protocal_c_adz.wmw != null) {
            x.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adz.wmw.size())});
            if (com_tencent_mm_protocal_c_adz.wmw.size() > 0) {
                x.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[]{((avf) com_tencent_mm_protocal_c_adz.wmw.get(0)).wCR, ((avf) com_tencent_mm_protocal_c_adz.wmw.get(0)).hvu, ((avf) com_tencent_mm_protocal_c_adz.wmw.get(0)).vYz, ((avf) com_tencent_mm_protocal_c_adz.wmw.get(0)).hvv});
            }
            Iterator it = com_tencent_mm_protocal_c_adz.wmw.iterator();
            while (it.hasNext()) {
                this.list.add(new f((avf) it.next(), this.iRN));
            }
        }
        if (com_tencent_mm_protocal_c_adz.wlO != null) {
            this.nQN = n.a(com_tencent_mm_protocal_c_adz.wlO);
        }
        this.kMn = com_tencent_mm_protocal_c_adz.wmx == 1;
        this.gJT.a(i2, i3, str, this);
        if (this.hOe != null) {
            this.hOe.run();
        }
    }

    public final boolean isFirst() {
        return this.nQM == null;
    }
}
