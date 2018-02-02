package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;

public final class h extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    public int hyU;
    private int lyO;
    public byte[] lyP;
    private int lyQ;
    private String lyR;
    private int lyS;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        a aVar = new a();
        aVar.hmj = new abi();
        aVar.hmk = new abj();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        aVar.hmi = 821;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.hyU = i;
        this.lyO = i2;
        this.lyQ = i3;
        this.lyR = str;
        this.lyP = bArr;
        this.lyS = i4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.lyP == null || this.lyP.length <= 0) && this.hyU != 3)) {
            com.tencent.mm.storage.emotion.h hVar = i.aBE().lwR;
            String str2 = this.lyO;
            abj aBP = aBP();
            if (bh.ov(str2) || aBP == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + com.tencent.mm.storage.emotion.h.a.xAE.value;
                    gVar.field_content = aBP.toByteArray();
                    ContentValues vI = gVar.vI();
                    new String[1][0] = str2 + com.tencent.mm.storage.emotion.h.a.xAE.value;
                    if (hVar.gJP.replace("EmotionDesignerInfo", "designerIDAndType", vI) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
        abj com_tencent_mm_protocal_c_abj = (abj) ((b) qVar).hmh.hmo;
        if (com_tencent_mm_protocal_c_abj.wkp != null) {
            this.lyP = n.a(com_tencent_mm_protocal_c_abj.wkp);
        }
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 821;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        abi com_tencent_mm_protocal_c_abi = (abi) this.gJQ.hmg.hmo;
        if (this.lyP != null) {
            com_tencent_mm_protocal_c_abi.wkp = n.N(this.lyP);
        } else {
            com_tencent_mm_protocal_c_abi.wkp = new bdn();
        }
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", com_tencent_mm_protocal_c_abi.wkp == null ? "Buf is NULL" : com_tencent_mm_protocal_c_abi.wkp.toString());
        com_tencent_mm_protocal_c_abi.wko = this.lyO;
        com_tencent_mm_protocal_c_abi.vDW = this.hyU;
        com_tencent_mm_protocal_c_abi.vZS = this.lyQ;
        com_tencent_mm_protocal_c_abi.wkq = this.lyR;
        com_tencent_mm_protocal_c_abi.wkr = this.lyS;
        return a(eVar, this.gJQ, this);
    }

    public final abj aBP() {
        return this.gJQ == null ? null : (abj) this.gJQ.hmh.hmo;
    }
}
