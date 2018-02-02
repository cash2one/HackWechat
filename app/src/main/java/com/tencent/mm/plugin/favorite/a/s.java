package com.tencent.mm.plugin.favorite.a;

import android.util.SparseArray;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;
    private List<Integer> mqS;
    private a mqT = null;
    private SparseArray<String> mqU = new SparseArray();
    private int scene;
    private String toUser;

    public s(String str, List<Integer> list, a aVar) {
        a aVar2 = new a();
        aVar2.hmj = new bie();
        aVar2.hmk = new bif();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.hmi = 608;
        aVar2.hml = 246;
        aVar2.hmm = 1000000246;
        this.gJQ = aVar2.JZ();
        this.toUser = str;
        this.scene = 2;
        this.mqS = list;
        this.mqT = aVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.mqU.clear();
        if (i2 == 0 && i3 == 0) {
            bif com_tencent_mm_protocal_c_bif = (bif) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bif.wok != this.mqS.size()) {
                x.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", Integer.valueOf(this.mqS.size()), Integer.valueOf(com_tencent_mm_protocal_c_bif.wok));
            }
            int i4 = 0;
            while (i4 < com_tencent_mm_protocal_c_bif.wLI.size() && i4 < this.mqS.size()) {
                x.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", this.mqS.get(i4), com_tencent_mm_protocal_c_bif.wLI.get(i4));
                this.mqU.put(((Integer) this.mqS.get(i4)).intValue(), ((bdo) com_tencent_mm_protocal_c_bif.wLI.get(i4)).wJF);
                i4++;
            }
        }
        this.gJT.a(i2, i3, str, this);
        if (this.mqT != null) {
            this.mqT.a(this.mqU);
        }
    }

    public final int getType() {
        return 608;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bie com_tencent_mm_protocal_c_bie = (bie) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bie.wLH = this.toUser;
        com_tencent_mm_protocal_c_bie.rYW = this.scene;
        com_tencent_mm_protocal_c_bie.vLf = new LinkedList(this.mqS);
        com_tencent_mm_protocal_c_bie.ksO = com_tencent_mm_protocal_c_bie.vLf.size();
        x.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", com_tencent_mm_protocal_c_bie.wLH, Integer.valueOf(com_tencent_mm_protocal_c_bie.rYW), com_tencent_mm_protocal_c_bie.vLf, Integer.valueOf(com_tencent_mm_protocal_c_bie.ksO));
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
