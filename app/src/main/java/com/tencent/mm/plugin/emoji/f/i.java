package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.h;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    private String lyT;

    public i(String str) {
        a aVar = new a();
        aVar.hmj = new abk();
        aVar.hmk = new abl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.hmi = ai.CTRL_BYTE;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyT = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            h hVar = com.tencent.mm.plugin.emoji.model.i.aBE().lwR;
            String str2 = this.lyT;
            abl aBQ = aBQ();
            if (bh.ov(str2) || aBQ == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + h.a.xAC.value;
                    gVar.field_content = aBQ.toByteArray();
                    ContentValues vI = gVar.vI();
                    new String[1][0] = str2 + h.a.xAC.value;
                    if (hVar.gJP.replace("EmotionDesignerInfo", "designerIDAndType", vI) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
        this.gOB.a(i2, i3, str, this);
    }

    public final abl aBQ() {
        return this.gJQ == null ? null : (abl) this.gJQ.hmh.hmo;
    }

    public final int getType() {
        return ai.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        ((abk) this.gJQ.hmg.hmo).vZM = this.lyT;
        return a(eVar, this.gJQ, this);
    }
}
