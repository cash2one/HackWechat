package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.t;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.protocal.c.kl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class v extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLV;
    public ArrayList<kj> kLW;

    public v(String str, float f, float f2, String str2) {
        this.kLV = str;
        a aVar = new a();
        aVar.hmj = new kk();
        aVar.hmk = new kl();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        aVar.hmi = 563;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        kk kkVar = (kk) this.gJQ.hmg.hmo;
        kkVar.kJN = str;
        kkVar.fBc = f;
        kkVar.fzt = f2;
        kkVar.fGU = str2;
        x.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), str2});
    }

    public final int getType() {
        return 563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bh.ov(((kk) this.gJQ.hmg.hmo).kJN)) {
            x.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            return -1;
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((kl) this.gJQ.hmh.hmo).kLN;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.kLW = t.xb(obj);
            if (this.kLW != null) {
                x.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[]{Integer.valueOf(this.kLW.size())});
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
