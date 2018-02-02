package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public static int rYY = 1;
    public static int rYZ = 2;
    public static int rZa = 3;
    private String fGJ;
    private b hmb;
    private String mFileName;
    public int mState = -1;
    private e oPD;
    private String rYS;
    private int rYT;
    private bsx rYU;
    private long rYV;
    private int rYW;
    private String rYX;
    public btc rZb;
    public brd rZc;
    public baa rZd;
    int rZe;

    public a(String str, int i, String str2) {
        a(str, i, -1, -1, str2, 0, "", "");
    }

    public a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, j, str2, 0, "", "");
    }

    public a(String str, int i, String str2, int i2, String str3, String str4) {
        a(str, i, -1, -1, str2, i2, str3, str4);
    }

    public a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        a(str, i, i2, j, str2, i3, str3, str4);
    }

    private void a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new nv();
        aVar.hmk = new nw();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.hmi = 546;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.mFileName = str2;
        this.hmb = aVar.JZ();
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.rYU = d.aH(i2, str2);
        }
        if (j > 0) {
            this.rYV = j;
        }
        this.rYS = str;
        this.rYT = i;
        this.rYW = i3;
        this.rYX = str3;
        this.fGJ = str4;
    }

    public final int getType() {
        return 546;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oPD = eVar2;
        nv nvVar = (nv) this.hmb.hmg.hmo;
        nvVar.vWC = this.rYS;
        nvVar.vIB = this.rYT;
        nvVar.vWD = this.rYU;
        nvVar.vHe = this.rYV;
        nvVar.rYW = this.rYW;
        nvVar.nkp = this.rYX;
        nvVar.nko = this.fGJ;
        return a(eVar, this.hmb, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            nw nwVar = (nw) this.hmb.hmh.hmo;
            if (nwVar != null) {
                this.rZb = nwVar.vWE;
                this.mState = nwVar.ktm;
                this.rZc = nwVar.vWF;
                this.rZd = nwVar.vWG;
                this.rZe = nwVar.vWH;
            } else {
                return;
            }
        }
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.rYS);
        this.oPD.a(i2, i3, str, this);
    }

    public final boolean bEk() {
        return (this.rZb == null || bh.ov(this.rZb.wUh)) ? false : true;
    }
}
