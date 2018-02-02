package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.x;
import java.text.DecimalFormat;

public final class b extends k implements com.tencent.mm.network.k {
    public static int lyu = 6;
    public static int lyv = 7;
    public static int lyw = 10;
    private final com.tencent.mm.ae.b gJQ;
    private e gOB;
    private String lyx;
    private sm lyy;

    public b(String str, sm smVar) {
        a aVar = new a();
        aVar.hmj = new dr();
        aVar.hmk = new ds();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        aVar.hmi = 830;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyx = str;
        this.lyy = smVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 830;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        dr drVar = (dr) this.gJQ.hmg.hmo;
        drVar.vIR = this.lyx;
        sm smVar = new sm();
        smVar.njX = this.lyy.njX;
        smVar.waP = this.lyy.waP;
        smVar.waO = new DecimalFormat("0.00").format(Float.valueOf(this.lyy.waO));
        drVar.vIS = smVar;
        return a(eVar, this.gJQ, this);
    }

    public final ds aBN() {
        return (ds) this.gJQ.hmh.hmo;
    }
}
