package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k, e {
    private b gJQ;
    private e gJT;
    private boolean mfl = false;
    public String mfm = null;
    public boolean mfn = false;
    private String mfo = "";

    public m(long j, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hmj = new uh();
        aVar.hmk = new ui();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.hmi = 1080;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        uh uhVar = (uh) this.gJQ.hmg.hmo;
        uhVar.fFm = str;
        uhVar.wck = j;
        uhVar.wcf = str2;
        uhVar.wcm = str3;
        uhVar.wcl = str4;
    }

    public final int getType() {
        return 1080;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        ui uiVar = (ui) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[]{uiVar.wcn});
        this.mfm = uiVar.wcn;
        this.mfn = uiVar.wco;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final String aGi() {
        return this.mfm;
    }

    public final boolean aGh() {
        return this.mfn;
    }
}
