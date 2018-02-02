package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public String appId;
    public int fut = 1;
    b gJQ;
    private e gJT;
    public int hlp;
    public int hlq;
    public int mbO;
    public com.tencent.mm.bq.b mbP;
    public String mbQ;
    public di mbR;
    public dc mbS;
    int mbT = 5000;
    long mbU = 0;
    public int vo;

    public a(int i, String str, int i2, String str2, di diVar) {
        boolean z = true;
        this.appId = str;
        this.mbO = i;
        this.vo = 1;
        this.hlp = i2;
        this.mbR = diVar;
        this.mbS = null;
        this.mbQ = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (diVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(false);
        x.i(str3, str4, objArr);
    }

    public a(int i, String str, dc dcVar, long j) {
        this.appId = str;
        this.mbO = i;
        this.vo = 1;
        this.mbR = null;
        this.mbS = dcVar;
        this.mbU = j;
        x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[]{Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0 && qVar != null) {
            x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        }
    }

    public final int getType() {
        return 985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.hmj = new dd();
        aVar.hmk = new de();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        dd ddVar = (dd) this.gJQ.hmg.hmo;
        ddVar.vDW = this.fut;
        ddVar.ngo = this.appId;
        ddVar.vIn = this.mbO;
        ddVar.vIo = this.vo;
        ddVar.vIp = this.mbR;
        ddVar.vIq = this.mbS;
        return a(eVar, this.gJQ, this);
    }
}
