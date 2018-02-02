package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhb;
import com.tencent.mm.protocal.c.bhc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public m(String str, String str2) {
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bhb = new bhb();
        com_tencent_mm_protocal_c_bhb.vYJ = str;
        com_tencent_mm_protocal_c_bhb.wjE = str2;
        aVar.hmj = com_tencent_mm_protocal_c_bhb;
        aVar.hmk = new bhc();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.hmi = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
