package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.l;

public final class o extends k implements com.tencent.mm.network.k {
    public static int lze = 0;
    public static int lzf = 1;
    public static int lzg = 1;
    public static int lzh = 2;
    public static int lzi = 256;
    private final b gJQ;
    private e gJT;
    private String lyx;
    private int lzj;

    public o(String str, int i) {
        a aVar = new a();
        aVar.hmj = new aca();
        aVar.hmk = new acb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        aVar.hmi = 822;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyx = str;
        this.lzj = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            if (this.lzj == lze) {
                l lVar = i.aBE().lwQ;
                String str2 = this.lyx;
                acb aBW = aBW();
                if (bh.ov(str2) || aBW == null) {
                    x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        com.tencent.mm.storage.emotion.k kVar = new com.tencent.mm.storage.emotion.k();
                        kVar.field_productID = str2;
                        kVar.field_content = aBW.toByteArray();
                        if (lVar.gJP.replace("EmotionRewardInfo", "productID", kVar.vI()) > 0) {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[]{str2});
                        } else {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[]{str2});
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bh.i(e)});
                    }
                }
            }
            if (aBW() == null || aBW().wkV == null) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                i.aBE().lwS.dd(this.lyx, lzi);
                i.aBF().be(this.lyx, lzi);
            } else {
                i.aBE().lwS.dd(this.lyx, aBW().wkV.vGN);
                i.aBF().be(this.lyx, aBW().wkV.vGN);
            }
        } else if (i3 == 1) {
            i.aBE().lwS.dd(this.lyx, lzi);
            i.aBF().be(this.lyx, lzi);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 822;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        aca com_tencent_mm_protocal_c_aca = (aca) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aca.vIR = this.lyx;
        com_tencent_mm_protocal_c_aca.vDW = this.lzj;
        return a(eVar, this.gJQ, this);
    }

    public final acb aBW() {
        return (acb) this.gJQ.hmh.hmo;
    }
}
