package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    ip pKn;
    public iq pKo;
    public c pKp;
    public d pKq;
    public boolean pKr = false;
    public String pKs = "";
    public boolean pKt = false;
    public int pKu = 0;

    public g(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, c cVar, d dVar) {
        this.pKs = System.currentTimeMillis() + i;
        a aVar = new a();
        this.pKu = i;
        aVar.hmj = new ip();
        aVar.hmk = new iq();
        aVar.hmi = 2677;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.pKn = (ip) this.hNJ.hmg.hmo;
        this.pKn.nZd = i;
        this.pKn.fCR = i2;
        this.pKn.pKd = i3;
        this.pKn.vOS = str;
        this.pKn.pLk = str2;
        this.pKn.pKe = str3;
        this.pKn.pLn = str4;
        this.pKn.vHu = str5;
        this.pKn.pKf = str6;
        this.pKn.vOT = i4;
        this.pKp = cVar;
        this.pKq = dVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", new Object[]{Integer.valueOf(this.pKn.nZd)}));
        stringBuffer.append(String.format("request.channel %s", new Object[]{Integer.valueOf(this.pKn.fCR)}));
        stringBuffer.append(String.format("request.scan_scene %s", new Object[]{Integer.valueOf(this.pKn.pKd)}));
        stringBuffer.append(String.format("request.receiver_desc %s", new Object[]{this.pKn.vOS}));
        stringBuffer.append(String.format("request.mch_name %s", new Object[]{this.pKn.pLk}));
        stringBuffer.append(String.format("request.favor_req_sign %s", new Object[]{this.pKn.pKe}));
        stringBuffer.append(String.format("request.receiver_openid %s", new Object[]{this.pKn.pLn}));
        stringBuffer.append(String.format("request.receiver_username %s", new Object[]{this.pKn.vHu}));
        stringBuffer.append(String.format("request.favor_req_extend %s", new Object[]{this.pKn.pKf}));
        stringBuffer.append(String.format("request.fail_click_cell %s", new Object[]{Integer.valueOf(this.pKn.vOT)}));
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[]{stringBuffer.toString()});
    }

    public final int getType() {
        return 2677;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKo = (iq) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[]{Integer.valueOf(this.pKo.kLO), this.pKo.kLP, a.a(this.pKo.pKh)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
