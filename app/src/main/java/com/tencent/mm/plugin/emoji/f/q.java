package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    public String lyH;
    private int lzj;

    public q(String str, int i) {
        this.lyH = str;
        if (!bh.ov(str) && str.equals(String.valueOf(EmojiGroupInfo.xAb))) {
            this.lyH = "com.tencent.xin.emoticon.tusiji";
        }
        this.lzj = i;
        a aVar = new a();
        aVar.hmj = new ars();
        aVar.hmk = new art();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.hmi = 413;
        aVar.hml = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hmm = 1000000212;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 413;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        ars com_tencent_mm_protocal_c_ars = (ars) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ars.vIR = this.lyH;
        com_tencent_mm_protocal_c_ars.vDW = this.lzj;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.lzj == 1) {
                g.pQN.a(165, 2, 1, false);
            } else {
                g.pQN.a(165, 4, 1, false);
            }
            this.gOB.a(i2, i3, str, this);
            return;
        }
        this.gOB.a(i2, i3, str, this);
        if (this.lzj == 1) {
            g.pQN.a(165, 3, 1, false);
            x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            return;
        }
        g.pQN.a(165, 5, 1, false);
        x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[]{this.lyH});
    }
}
