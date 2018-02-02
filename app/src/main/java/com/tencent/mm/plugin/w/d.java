package com.tencent.mm.plugin.w;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g$a;

public final class d extends k implements com.tencent.mm.network.k {
    private String aeskey;
    private String fzR;
    private b gJQ;
    private e gJT;
    private String gze;
    private int oFw;

    public d(String str, String str2, int i, String str3) {
        this.fzR = str;
        this.aeskey = str2;
        this.oFw = i;
        this.gze = str3;
        a aVar = new a();
        aVar.hmj = new bfn();
        aVar.hmk = new bfo();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.hmi = 222;
        aVar.hml = 107;
        aVar.hmm = 1000000107;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[]{str, Integer.valueOf(i), str3, bh.cgy()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        g$a com_tencent_mm_y_g_a = new g$a();
        com_tencent_mm_y_g_a.title = "PCSYNC";
        com_tencent_mm_y_g_a.description = "ANDROID_PCSYNC";
        com_tencent_mm_y_g_a.type = 35;
        com_tencent_mm_y_g_a.url = this.fzR;
        com_tencent_mm_y_g_a.hbp = this.aeskey;
        com_tencent_mm_y_g_a.hbb = this.oFw;
        com_tencent_mm_y_g_a.hbq = this.aeskey;
        com_tencent_mm_y_g_a.showType = 0;
        bfn com_tencent_mm_protocal_c_bfn = (bfn) this.gJQ.hmg.hmo;
        cx cxVar = new cx();
        cxVar.nkp = this.gze;
        cxVar.vHT = com_tencent_mm_y_g_a.sdkVer;
        cxVar.ktN = 35;
        cxVar.nko = this.gze;
        cxVar.nje = g$a.a(com_tencent_mm_y_g_a, null, null, 0, 0);
        cxVar.pbl = (int) bh.Wo();
        com_tencent_mm_protocal_c_bfn.wKx = cxVar;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 222;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }
}
