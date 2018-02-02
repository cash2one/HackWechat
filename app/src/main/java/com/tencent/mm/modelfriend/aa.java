package com.tencent.mm.modelfriend;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bqn;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aa extends k implements com.tencent.mm.network.k {
    private int fuL;
    private e gJT;
    public final List<String> hwE;
    public final List<String> hwF;
    private final String hwG = ((String) c.CU().get(6, null));
    private int hwH = 0;
    private int hwI = 0;

    public aa(List<String> list, List<String> list2) {
        ar.Hg();
        this.hwE = list;
        this.hwF = list2;
        this.fuL = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.gJT = eVar2;
        if ((this.hwE == null || this.hwE.size() == 0) && (this.hwF == null || this.hwF.size() == 0)) {
            x.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            return -1;
        }
        a aVar = new a();
        aVar.hmj = new bqn();
        aVar.hmk = new bqo();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.hmi = d.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        q JZ = aVar.JZ();
        bqn com_tencent_mm_protocal_c_bqn = (bqn) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bqn.vMb = this.hwG;
        com_tencent_mm_protocal_c_bqn.ksU = com.tencent.mm.z.q.FS();
        com_tencent_mm_protocal_c_bqn.vJL = this.fuL;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.hwE != null && this.hwH < this.hwE.size()) {
                if (this.hwE.get(this.hwH) != null) {
                    arf com_tencent_mm_protocal_c_arf = new arf();
                    com_tencent_mm_protocal_c_arf.v = (String) this.hwE.get(this.hwH);
                    linkedList.add(com_tencent_mm_protocal_c_arf);
                }
                this.hwH++;
                i2--;
            }
            if (this.hwF != null && this.hwI < this.hwF.size()) {
                if (this.hwF.get(this.hwI) != null) {
                    apf com_tencent_mm_protocal_c_apf = new apf();
                    com_tencent_mm_protocal_c_apf.v = (String) this.hwF.get(this.hwI);
                    linkedList2.add(com_tencent_mm_protocal_c_apf);
                }
                this.hwI++;
                i2--;
            }
            if ((this.hwF == null || this.hwI >= this.hwF.size()) && (this.hwE == null || this.hwH >= this.hwE.size())) {
                break;
            }
        }
        com_tencent_mm_protocal_c_bqn.wvB = linkedList;
        com_tencent_mm_protocal_c_bqn.wRV = linkedList.size();
        com_tencent_mm_protocal_c_bqn.wRX = linkedList2;
        com_tencent_mm_protocal_c_bqn.wRW = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.hwF == null ? 0 : this.hwF.size()).append(",");
        if (this.hwE != null) {
            i = this.hwE.size();
        }
        x.v(str, append.append(i).append("] index:[").append(this.hwI).append(",").append(this.hwH).append("] req:[").append(com_tencent_mm_protocal_c_bqn.wRX.size()).append(",").append(com_tencent_mm_protocal_c_bqn.wvB.size()).append("]").toString());
        return a(eVar, JZ, this);
    }

    public final boolean Kd() {
        return true;
    }

    protected final int a(q qVar) {
        bqn com_tencent_mm_protocal_c_bqn = (bqn) ((b) qVar).hmg.hmo;
        int size = com_tencent_mm_protocal_c_bqn.wRX.size() + com_tencent_mm_protocal_c_bqn.wvB.size();
        if (size == 0 || size > 200) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            return b.hmQ;
        } else if (com_tencent_mm_protocal_c_bqn.vMb == null || com_tencent_mm_protocal_c_bqn.vMb.length() <= 0) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            return b.hmQ;
        } else if (com_tencent_mm_protocal_c_bqn.ksU != null && com_tencent_mm_protocal_c_bqn.ksU.length() > 0) {
            return b.hmP;
        } else {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            return b.hmQ;
        }
    }

    protected final int Bh() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bqn com_tencent_mm_protocal_c_bqn = (bqn) ((b) qVar).hmg.hmo;
            m.M(O(com_tencent_mm_protocal_c_bqn.wRX));
            m.M(P(com_tencent_mm_protocal_c_bqn.wvB));
            if ((this.hwF == null || this.hwI >= this.hwF.size()) && (this.hwE == null || this.hwH >= this.hwE.size())) {
                this.gJT.a(i2, i3, str, this);
                return;
            } else if (a(this.hmA, this.gJT) < 0) {
                this.gJT.a(i2, i3, str, this);
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    private static List<String> O(List<apf> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            return arrayList;
        }
        for (apf com_tencent_mm_protocal_c_apf : list) {
            arrayList.add(com_tencent_mm_protocal_c_apf.v);
        }
        return arrayList;
    }

    private static List<String> P(List<arf> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            return arrayList;
        }
        for (arf com_tencent_mm_protocal_c_arf : list) {
            arrayList.add(g.s(com.tencent.mm.pluginsdk.a.Id(com_tencent_mm_protocal_c_arf.v).getBytes()));
        }
        return arrayList;
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }
}
