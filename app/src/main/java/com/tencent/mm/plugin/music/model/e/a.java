package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hFi;
    public nf oLM;

    public a(int i, com.tencent.mm.av.a aVar) {
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmi = 940;
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmusic";
        aVar2.hmj = new nf();
        aVar2.hmk = new ng();
        this.hFi = aVar2.JZ();
        this.oLM = (nf) this.hFi.hmg.hmo;
        this.oLM.rYW = i;
        this.oLM.ngo = aVar.field_appId;
        this.oLM.vWa = aVar.field_songAlbumUrl;
        this.oLM.vWb = aVar.field_songHAlbumUrl;
        this.oLM.vWd = aVar.field_songWifiUrl;
        this.oLM.vWe = aVar.field_songWapLinkUrl;
        this.oLM.vWc = aVar.field_songWebUrl;
        this.oLM.fon = aVar.field_songName;
        this.oLM.vVZ = aVar.field_musicId;
    }

    public final int getType() {
        return 940;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
