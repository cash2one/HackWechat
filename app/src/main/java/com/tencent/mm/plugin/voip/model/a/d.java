package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bug;
import com.tencent.mm.protocal.c.buh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends n<bug, buh> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        a aVar = new a();
        aVar.hmj = new bug();
        aVar.hmk = new buh();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.hmi = az.CTRL_INDEX;
        aVar.hml = az.CTRL_INDEX;
        aVar.hmm = 1000000249;
        this.gJQ = aVar.JZ();
        bug com_tencent_mm_protocal_c_bug = (bug) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bug.wbh = i;
        com_tencent_mm_protocal_c_bug.wbi = j;
        com_tencent_mm_protocal_c_bug.wFB = i2;
        com_tencent_mm_protocal_c_bug.wVn = i3;
        com_tencent_mm_protocal_c_bug.wVo = i4;
        com_tencent_mm_protocal_c_bug.wVp = i5;
        com_tencent_mm_protocal_c_bug.wVq = i6;
        com_tencent_mm_protocal_c_bug.wVr = 1;
        com_tencent_mm_protocal_c_bug.vKf = new bdn().N(bArr, i7);
    }

    public final int getType() {
        return az.CTRL_INDEX;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((buh) bHN()) != null) {
                x.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((buh) bHN()).wbh), Long.valueOf(((buh) bHN()).wbi), Integer.valueOf(((buh) bHN()).wFB)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    }

    public final e bHJ() {
        return new 1(this);
    }
}
