package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.protocal.c.bpw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;

public final class o extends k implements com.tencent.mm.network.k {
    public String chatroomName = null;
    public int gBI = 0;
    private final b gJQ;
    private e gJT = null;
    public String kZo = null;
    public String kZy = null;
    public int kZz = 0;

    public o(String str) {
        a aVar = new a();
        aVar.hmj = new bpv();
        aVar.hmk = new bpw();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.hmi = 482;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.chatroomName = str;
        ((bpv) this.gJQ.hmg.hmo).vYJ = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bpw com_tencent_mm_protocal_c_bpw = (bpw) this.gJQ.hmh.hmo;
        x.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kZy = com_tencent_mm_protocal_c_bpw.wzg;
        if (!bh.ov(this.kZy)) {
            ar.Hg();
            com.tencent.mm.storage.q hD = c.Fh().hD(this.chatroomName);
            if (hD == null) {
                hD = new com.tencent.mm.storage.q();
            }
            hD.fC(com.tencent.mm.z.q.FS(), this.kZy);
            m.a(hD);
        }
        this.kZo = com_tencent_mm_protocal_c_bpw.wjS;
        this.gBI = com_tencent_mm_protocal_c_bpw.wjR;
        this.kZz = com_tencent_mm_protocal_c_bpw.wjT;
        this.gJT.a(i2, i3, str, this);
    }
}
