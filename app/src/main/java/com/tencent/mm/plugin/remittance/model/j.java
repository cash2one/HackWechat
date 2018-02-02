package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public iw pKx;

    public j(cd cdVar, String str) {
        a aVar = new a();
        aVar.hmj = new iv();
        aVar.hmk = new iw();
        aVar.hmi = 2504;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        iv ivVar = (iv) this.hNJ.hmg.hmo;
        ivVar.vOU = cdVar;
        ivVar.vPc = str;
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", new Object[]{str, a.a(cdVar)});
    }

    public final int getType() {
        return 2504;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKx = (iw) ((b) qVar).hmh.hmo;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.pKx.sOJ != null) {
            stringBuffer.append("response: " + this.pKx.vPf);
            stringBuffer.append("is_show_btn: " + this.pKx.sOJ.wbu);
            if (this.pKx.sOJ.wbt != null) {
                stringBuffer.append("single_exposure_info_list " + this.pKx.sOJ.wbt.size());
            }
        }
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[]{Integer.valueOf(this.pKx.kLO), this.pKx.kLP, stringBuffer.toString()});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
