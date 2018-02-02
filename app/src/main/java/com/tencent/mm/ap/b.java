package com.tencent.mm.ap;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    private LinkedList<aln> hzb;
    public String hzc;

    public b(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.hmj = new alo();
        aVar.hmk = new alp();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        aVar.hmi = 489;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.hzb = new LinkedList();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                aln com_tencent_mm_protocal_c_aln = new aln();
                com_tencent_mm_protocal_c_aln.vLO = (String) arrayList.get(i);
                this.hzb.add(com_tencent_mm_protocal_c_aln);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.gJT = eVar2;
        alo com_tencent_mm_protocal_c_alo = (alo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_alo.ksO = this.hzb.size();
        com_tencent_mm_protocal_c_alo.ksP = this.hzb;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final alp Pa() {
        return (alp) this.gJQ.hmh.hmo;
    }

    public final int getType() {
        return 489;
    }
}
