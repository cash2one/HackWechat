package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hFi;
    public String hHQ = "";
    private aft oLP;
    public String oLQ = "";

    public c(String str) {
        a aVar = new a();
        aVar.hmi = 769;
        aVar.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
        aVar.hmj = new aft();
        aVar.hmk = new afu();
        this.hFi = aVar.JZ();
        this.oLP = (aft) this.hFi.hmg.hmo;
        this.oLP.wnD = str;
        this.hHQ = str;
        x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[]{str});
    }

    public final int getType() {
        return 769;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            afu com_tencent_mm_protocal_c_afu = (afu) this.hFi.hmh.hmo;
            this.gJT.a(i2, i3, str, this);
            if (com_tencent_mm_protocal_c_afu != null) {
                this.oLQ = com_tencent_mm_protocal_c_afu.wnD;
                x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[]{this.oLQ});
                return;
            }
            x.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
