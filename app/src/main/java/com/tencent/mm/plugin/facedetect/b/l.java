package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public LinkedList<ant> mfi = null;
    public ayb mfj = null;
    public String mfk = null;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new uf();
        aVar.hmk = new ug();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        aVar.hmi = 1147;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        uf ufVar = (uf) this.gJQ.hmg.hmo;
        ufVar.fFm = str;
        ufVar.wcf = str2;
    }

    public final int getType() {
        return 1147;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        ug ugVar = (ug) ((b) qVar).hmh.hmo;
        if (ugVar != null) {
            this.mfi = ugVar.vUe;
            this.mfj = ugVar.wcg;
            this.mfk = ugVar.wci;
            if (this.gJT != null) {
                this.gJT.a(i2, i3, str, this);
            }
        }
    }
}
