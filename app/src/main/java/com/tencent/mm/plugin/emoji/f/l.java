package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.j;

public final class l extends k implements com.tencent.mm.network.k {
    private int aIt;
    private final b gJQ;
    private e gJT;
    private int irz;
    public String lyH;

    public l(String str, int i, int i2) {
        this.lyH = str;
        this.irz = i;
        this.aIt = i2;
        a aVar = new a();
        aVar.hmj = new abu();
        aVar.hmk = new abv();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.hmi = 412;
        aVar.hml = h.CTRL_INDEX;
        aVar.hmm = 1000000211;
        this.gJQ = aVar.JZ();
    }

    public l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[]{this.lyH, Integer.valueOf(this.irz), Integer.valueOf(this.aIt)});
        this.gJT = eVar2;
        abu com_tencent_mm_protocal_c_abu = (abu) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_abu.vIR = this.lyH;
        com_tencent_mm_protocal_c_abu.rYW = this.irz;
        com_tencent_mm_protocal_c_abu.ktM = this.aIt;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                j jVar = i.aBE().lwP;
                String str2 = this.lyH;
                abv com_tencent_mm_protocal_c_abv = (abv) this.gJQ.hmh.hmo;
                String eL = w.eL(ac.getContext());
                if (bh.ov(str2) || com_tencent_mm_protocal_c_abv == null) {
                    x.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    com.tencent.mm.storage.emotion.i iVar = new com.tencent.mm.storage.emotion.i();
                    iVar.field_productID = str2;
                    iVar.field_content = com_tencent_mm_protocal_c_abv.toByteArray();
                    iVar.field_lan = eL;
                    if (jVar.gJP.replace("EmotionDetailInfo", "productID", iVar.vI()) > 0) {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bh.i(e)});
                }
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final sk aBS() {
        sk skVar = new sk();
        return ((abv) this.gJQ.hmh.hmo).wkD;
    }
}
