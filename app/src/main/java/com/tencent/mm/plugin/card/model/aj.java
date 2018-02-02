package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.sdk.platformtools.x;

public final class aj extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;
    public com.tencent.mm.bq.b kMm;
    public boolean kMn;

    public aj(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.bq.b bVar) {
        a aVar = new a();
        aVar.hmj = new yh();
        aVar.hmk = new yi();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        aVar.hmi = 664;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        yh yhVar = (yh) this.gJQ.hmg.hmo;
        yhVar.kJT = str;
        yhVar.kUc = i;
        yhVar.kUd = str2;
        yhVar.kUe = str3;
        yhVar.time_stamp = i2;
        yhVar.kUf = str4;
        yhVar.kJN = str5;
        yhVar.kUg = str6;
        yhVar.kMm = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            yhVar.wiB = 1;
        } else {
            yhVar.wiB = 0;
        }
    }

    public final int getType() {
        return 664;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            yi yiVar = (yi) this.gJQ.hmh.hmo;
            this.kLN = yiVar.kLN;
            this.kMm = yiVar.kMm;
            this.kMn = yiVar.wiC != 0;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
