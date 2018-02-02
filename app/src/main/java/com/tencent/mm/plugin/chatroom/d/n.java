package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String username;

    public n(String str, String str2) {
        a aVar = new a();
        this.username = str2;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_boi = new boi();
        com_tencent_mm_protocal_c_boi.vYJ = str;
        com_tencent_mm_protocal_c_boi.wQQ = str2;
        aVar.hmj = com_tencent_mm_protocal_c_boi;
        aVar.hmk = new boj();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        this.gJQ = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
