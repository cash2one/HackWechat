package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class r extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public int mqN;
    public com.tencent.mm.plugin.fav.a.e mqO;
    private LinkedList<arx> mqP;
    private LinkedList<aru> mqQ;
    public String mqR;
    private int scene;
    public int type;

    private r(int i, LinkedList<aru> linkedList, LinkedList<arx> linkedList2, int i2) {
        this.gJT = null;
        a aVar = new a();
        aVar.hmj = new arv();
        aVar.hmk = new arw();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.hmi = 426;
        aVar.hml = f.CTRL_INDEX;
        aVar.hmm = 1000000216;
        this.gJQ = aVar.JZ();
        this.mqP = linkedList2;
        this.mqQ = linkedList;
        this.mqN = i;
        this.type = i2;
    }

    public r(int i, LinkedList<aru> linkedList, LinkedList<arx> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public r(int i, com.tencent.mm.plugin.fav.a.e eVar) {
        this(i, eVar.field_modItem.mqQ, eVar.field_modItem.weD, 1);
        this.mqO = eVar;
    }

    public r(int i, LinkedList<aru> linkedList, LinkedList<arx> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mqR = str;
    }

    public r(int i, LinkedList<aru> linkedList, LinkedList<arx> linkedList2, String str, byte b) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mqR = str;
        this.scene = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.scene == 0 && (this.mqQ == null || this.mqQ.size() == 0)) {
            return -1;
        }
        arv com_tencent_mm_protocal_c_arv = (arv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_arv.wzB = this.mqQ.size();
        if (this.mqP != null) {
            com_tencent_mm_protocal_c_arv.wzD = this.mqP.size();
            com_tencent_mm_protocal_c_arv.vLo = this.mqP;
        } else {
            com_tencent_mm_protocal_c_arv.wzD = 0;
            com_tencent_mm_protocal_c_arv.vLo = new LinkedList();
        }
        if (!bh.ov(this.mqR)) {
            com_tencent_mm_protocal_c_arv.wzE = this.mqR;
        }
        com_tencent_mm_protocal_c_arv.wzB = this.mqQ.size();
        com_tencent_mm_protocal_c_arv.wzC = this.mqQ;
        com_tencent_mm_protocal_c_arv.vGM = this.mqN;
        com_tencent_mm_protocal_c_arv.rYW = this.scene;
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final long aIV() {
        if (this.mqO == null) {
            return -1;
        }
        return this.mqO.field_localId;
    }

    public final int aIW() {
        if (this.mqO == null) {
            return -1;
        }
        return this.mqO.field_type;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.mqN + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
        j.z(h.getFavItemInfoStorage().dc((long) this.mqN));
    }

    public final int getType() {
        return 426;
    }
}
