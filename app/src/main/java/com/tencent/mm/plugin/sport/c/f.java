package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.TimeZone;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    private bqb rTT;

    public f(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        int i5;
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hmj = new bqb();
        aVar.hmk = new bqc();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.hmi = 1261;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.rTT = (bqb) this.gJQ.hmg.hmo;
        this.rTT.ffq = str;
        this.rTT.frg = str2;
        this.rTT.wRE = i;
        this.rTT.wRF = i2;
        this.rTT.blZ = i3;
        bqb com_tencent_mm_protocal_c_bqb = this.rTT;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        com_tencent_mm_protocal_c_bqb.wRG = String.valueOf(i5 + (rawOffset / 3600));
        this.rTT.wRI = str3;
        this.rTT.wRL = i4;
    }

    public final int getType() {
        return 1261;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
