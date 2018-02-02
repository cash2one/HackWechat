package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.protocal.c.ash;

public final class g extends k implements com.tencent.mm.network.k {
    private final String fFm;
    private e gJT;
    public final String qgb;
    public final int qgc;
    private final int scene;

    public g(String str, String str2, int i, int i2) {
        this.fFm = str;
        this.qgb = str2;
        this.qgc = i;
        this.scene = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ash com_tencent_mm_protocal_c_ash = (ash) ((b) qVar).hmh.hmo;
        this.gJT.a(i2, com_tencent_mm_protocal_c_ash.vYS.fts, com_tencent_mm_protocal_c_ash.vYS.ftt, this);
    }

    public final int getType() {
        return 1144;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_asg = new asg();
        com_tencent_mm_protocal_c_asg.fFm = this.fFm;
        com_tencent_mm_protocal_c_asg.wzL = this.qgb;
        com_tencent_mm_protocal_c_asg.wzM = this.qgc;
        aVar.hmj = com_tencent_mm_protocal_c_asg;
        aVar.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        aVar.hmk = new ash();
        aVar.hmi = 1144;
        aVar.hml = 0;
        aVar.hmm = 0;
        return a(eVar, aVar.JZ(), this);
    }
}
