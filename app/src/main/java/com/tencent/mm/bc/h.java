package com.tencent.mm.bc;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public int fDl;
    private e gJT;
    private b hFi;
    private int hKS;
    public aqa hKX;
    public int hKY;
    public String hKZ;
    public int scene;

    public h(int i, int i2, int i3, int i4, String str, long j, String str2) {
        this.scene = i;
        this.hKS = i3;
        this.fDl = i4;
        this.hKY = i2;
        this.hKZ = str2;
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hmi = 1048;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.hmj = new apz();
        aVar.hmk = new aqa();
        this.hFi = aVar.JZ();
        apz com_tencent_mm_protocal_c_apz = (apz) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_apz.rYW = i;
        com_tencent_mm_protocal_c_apz.wwH = i3;
        com_tencent_mm_protocal_c_apz.wwI = g.Je();
        com_tencent_mm_protocal_c_apz.wwJ = i2;
        com_tencent_mm_protocal_c_apz.lOo = str;
        com_tencent_mm_protocal_c_apz.wwK = j;
    }

    public final int getType() {
        return 1048;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hKX = (aqa) this.hFi.hmh.hmo;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
