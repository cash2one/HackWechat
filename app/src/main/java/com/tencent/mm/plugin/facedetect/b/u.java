package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class u extends k implements com.tencent.mm.network.k, b {
    private b gJQ;
    private e gJT;
    private long mfw = -1;
    private byte[] mfx = null;

    public final long aGf() {
        return this.mfw;
    }

    public final byte[] aGg() {
        return this.mfx;
    }

    public u(int i) {
        a aVar = new a();
        aVar.hmj = new zb();
        aVar.hmk = new zc();
        aVar.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        aVar.hmi = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        zb zbVar = (zb) this.gJQ.hmg.hmo;
        zbVar.ktN = 1;
        zbVar.rYW = i;
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        zc zcVar = (zc) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            this.mfw = zcVar.wiY;
            this.mfx = zcVar.wiZ.oz;
            String str2 = "MicroMsg.NetSceneGetBioConfig";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.mfw);
            objArr[1] = Integer.valueOf(this.mfx == null ? 0 : this.mfx.length);
            x.i(str2, str3, objArr);
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
