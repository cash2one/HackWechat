package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.av.a;
import com.tencent.mm.av.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public a fAA;
    private e gJT;
    private com.tencent.mm.ae.b hFi;
    public afb oLN;
    public boolean oLO;

    public b(a aVar, boolean z) {
        int i;
        this.fAA = aVar;
        this.oLO = z;
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new afa();
        aVar2.hmk = new afb();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.hmi = 520;
        this.hFi = aVar2.JZ();
        afa com_tencent_mm_protocal_c_afa = (afa) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_afa.wmR = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            com_tencent_mm_protocal_c_afa.wmS = n.N(aVar.field_songWebUrl.getBytes());
        }
        if (c.Qz()) {
            i = 0;
        } else {
            i = 1;
        }
        com_tencent_mm_protocal_c_afa.wmT = i;
        if (c.Qy()) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_afa.wmU = i;
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[]{Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(com_tencent_mm_protocal_c_afa.wmT), Integer.valueOf(com_tencent_mm_protocal_c_afa.wmU)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.oLN = (afb) this.hFi.hmh.hmo;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }
}
