package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.hm;

public final class x extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public x(String str, String str2, hm hmVar, hm hmVar2, Object obj) {
        a aVar = new a();
        aVar.hmj = new bpc();
        aVar.hmk = new bpd();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        aVar.hmi = 1357;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bpc com_tencent_mm_protocal_c_bpc = (bpc) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpc.vNq = str;
        com_tencent_mm_protocal_c_bpc.vNk = str2;
        com_tencent_mm_protocal_c_bpc.wRt = hmVar;
        com_tencent_mm_protocal_c_bpc.wRu = hmVar2;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1357;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
