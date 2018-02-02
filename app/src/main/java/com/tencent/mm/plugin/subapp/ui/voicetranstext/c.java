package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.protocal.c.brf;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class c extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String fGJ;
    private b hmb;
    private String mFileName;
    private e oPD;
    private String rYS;
    private bsx rYU;
    private int rYW;
    private String rYX;
    public brd rZc;

    public c(c cVar) {
        this.rYS = cVar.rYS;
        this.rYU = cVar.rYU;
        this.rZc = cVar.rZc;
        this.mFileName = cVar.mFileName;
        this.rYW = cVar.rYW;
        this.rYX = cVar.rYX;
        this.fGJ = cVar.fGJ;
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(cVar.rYW), cVar.rYX, cVar.fGJ);
        bEl();
    }

    public c(String str, brd com_tencent_mm_protocal_c_brd, int i, String str2) {
        Assert.assertTrue(str2 != null);
        this.rYS = str;
        this.rZc = com_tencent_mm_protocal_c_brd;
        this.rYU = d.aH(i, str2);
        this.mFileName = str2;
        bEl();
    }

    public c(String str, brd com_tencent_mm_protocal_c_brd, int i, String str2, int i2, String str3, String str4) {
        Assert.assertTrue(str2 != null);
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(i2), str3, str4);
        this.rYS = str;
        this.rZc = com_tencent_mm_protocal_c_brd;
        this.rYU = d.aH(i, str2);
        this.mFileName = str2;
        this.rYW = i2;
        this.rYX = str3;
        this.fGJ = str4;
        bEl();
    }

    public final int getType() {
        return 547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oPD = eVar2;
        Object obj = (bh.ov(this.mFileName) || bh.ov(this.rYS) || this.rZc == null || this.rYU == null) ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            return -1;
        }
        bre com_tencent_mm_protocal_c_bre = (bre) this.hmb.hmg.hmo;
        com_tencent_mm_protocal_c_bre.vWC = this.rYS;
        com_tencent_mm_protocal_c_bre.vWD = this.rYU;
        com_tencent_mm_protocal_c_bre.vWF = this.rZc;
        String str = this.mFileName;
        int i = this.rZc.vIC;
        int i2 = this.rZc.vID;
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com.tencent.mm.modelvoice.b nT = q.nT(str);
        if (nT != null) {
            com_tencent_mm_protocal_c_bdn = n.N(nT.bp(i, i2).buf);
        }
        com_tencent_mm_protocal_c_bre.vXz = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bre.rYW = this.rYW;
        com_tencent_mm_protocal_c_bre.nkp = this.rYX;
        com_tencent_mm_protocal_c_bre.nko = this.fGJ;
        return a(eVar, this.hmb, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bEm();
        if (i2 == 0 && i3 == 0) {
            this.rZc = ((brf) this.hmb.hmh.hmo).vWF;
        } else {
            x.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oPD.a(i2, i3, str, this);
        if (bEm()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.rZc != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        }
    }

    private void bEl() {
        a aVar = new a();
        aVar.hmj = new bre();
        aVar.hmk = new brf();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.hmi = 547;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hmb = aVar.JZ();
    }

    public final boolean bEm() {
        if (this.rZc == null || this.rZc.vID <= 0) {
            return true;
        }
        return false;
    }
}
