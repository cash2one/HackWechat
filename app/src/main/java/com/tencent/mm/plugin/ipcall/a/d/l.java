package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT;
    private ayo nFL = null;
    private ayp nFM = null;

    public l(int i, long j, boolean z) {
        a aVar = new a();
        aVar.hmj = new ayo();
        aVar.hmk = new ayp();
        aVar.hmi = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFL = (ayo) this.gJQ.hmg.hmo;
        this.nFL.wbh = i;
        this.nFL.wFs = j;
        this.nFL.wFL = z ? 1 : 0;
        x.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[]{Integer.valueOf(this.nFL.wbh), Long.valueOf(this.nFL.wFs), Integer.valueOf(this.nFL.wFL)});
        ayo com_tencent_mm_protocal_c_ayo = this.nFL;
        com.tencent.mm.plugin.ipcall.a.c.b aTz = i.aTz();
        x.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[]{aTz.nDx + "," + aTz.nDy + "," + aTz.nEX + "," + aTz.ikY + "," + aTz.nEY + "," + aTz.nEN + "," + aTz.nEO + "," + aTz.nEP + "," + aTz.nEQ + "," + aTz.nER + "," + aTz.nES + "," + aTz.nET + "," + aTz.nEU + "," + aTz.nEV + "," + aTz.nEW + "," + aTz.nEZ + "," + c.aUN() + "," + aTz.nFi + "," + aTz.countryCode + "," + aTz.nFj + "," + aTz.nFk + "," + aTz.nFl + aTz.nFg + "," + aTz.nFn});
        com_tencent_mm_protocal_c_ayo.wFI = n.os(r3);
        com_tencent_mm_protocal_c_ayo = this.nFL;
        aTz = i.aTz();
        x.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[]{aTz.nDx + "," + aTz.nDy + "," + aTz.nEX + aTz.nFf});
        com_tencent_mm_protocal_c_ayo.wFJ = n.os(r3);
        com_tencent_mm_protocal_c_ayo = this.nFL;
        aTz = i.aTz();
        x.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[]{aTz.nDx + "," + aTz.nDy + "," + aTz.nEX + aTz.nFe});
        com_tencent_mm_protocal_c_ayo.wFK = n.os(r3);
    }

    public final int getType() {
        return GameJsApiGetOpenDeviceId.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFM = (ayp) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
