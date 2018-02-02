package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bdi();
        aVar.hmk = new bdj();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        aVar.hmi = 700;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bdi com_tencent_mm_protocal_c_bdi = (bdi) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bdi.wJt = str;
        com_tencent_mm_protocal_c_bdi.wJu = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 700;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
