package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.bui;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends n<bui, buj> {
    public e(int i, long j, String str) {
        a aVar = new a();
        aVar.hmj = new bui();
        aVar.hmk = new buj();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.hmi = 303;
        aVar.hml = 119;
        aVar.hmm = 1000000119;
        this.gJQ = aVar.JZ();
        bui com_tencent_mm_protocal_c_bui = (bui) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bui.wbh = i;
        com_tencent_mm_protocal_c_bui.wbi = j;
        com_tencent_mm_protocal_c_bui.wVt = str;
        com_tencent_mm_protocal_c_bui.ktN = 1;
        com_tencent_mm_protocal_c_bui.wUq = System.currentTimeMillis();
    }

    public final int getType() {
        return 303;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((buj) bHN()) != null) {
                x.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[]{Integer.valueOf(((buj) bHN()).wbh), Long.valueOf(((buj) bHN()).wbi), Integer.valueOf(((buj) bHN()).kZx), Integer.valueOf(((buj) bHN()).wVl)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    }

    public final com.tencent.mm.ae.e bHJ() {
        return new 1(this);
    }
}
