package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private final b gJQ;
    private e gJT = null;
    public String kZo;
    public int kZp;
    public int kZq;
    public int status;

    public h(String str) {
        a aVar = new a();
        aVar.hmj = new aau();
        aVar.hmk = new aav();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.hmi = 519;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.chatroomName = str;
        ((aau) this.gJQ.hmg.hmo).vYJ = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 519;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aav com_tencent_mm_protocal_c_aav = (aav) this.gJQ.hmh.hmo;
        x.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.status = com_tencent_mm_protocal_c_aav.ktm;
        this.kZo = com_tencent_mm_protocal_c_aav.wjS;
        this.kZq = com_tencent_mm_protocal_c_aav.wjT;
        this.kZo = com_tencent_mm_protocal_c_aav.wjS;
        this.kZp = com_tencent_mm_protocal_c_aav.wjR;
        this.gJT.a(i2, i3, str, this);
    }
}
