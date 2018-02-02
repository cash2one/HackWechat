package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private e gOB = null;
    public b lMW = null;
    String lNf;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i)});
        this.lNf = str2;
        a aVar = new a();
        aVar.hmj = new bft();
        aVar.hmk = new bfu();
        aVar.hmi = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        bft com_tencent_mm_protocal_c_bft = (bft) this.lMW.hmg.hmo;
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.vJA = str;
        com_tencent_mm_protocal_c_ajr.ksX = str2;
        com_tencent_mm_protocal_c_bft.vLR = com_tencent_mm_protocal_c_ajr;
        ajv com_tencent_mm_protocal_c_ajv = new ajv();
        com_tencent_mm_protocal_c_ajv.wrb = j2;
        com_tencent_mm_protocal_c_ajv.pbl = (int) j3;
        com_tencent_mm_protocal_c_ajv.vKf = new bdn().bj(bArr);
        com_tencent_mm_protocal_c_ajv.ktN = i;
        com_tencent_mm_protocal_c_bft.wKD = com_tencent_mm_protocal_c_ajv;
        if (j != 0) {
            com_tencent_mm_protocal_c_bft.wqW = new bdn().bj(u.aEL().l(j, 2));
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b zg = ad.aEk().zg(str2);
        if (zg != null) {
            com_tencent_mm_protocal_c_bft.wqW = new bdn().bj(zg.field_sessionBuf);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 538;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.lMW, this);
    }
}
