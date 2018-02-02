package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l {
    public final b gJQ;
    private e gJT;
    public String lyH;
    public String taj;
    public String tak;

    public j(String str, String str2, String str3, int i, int i2, String str4) {
        a aVar = new a();
        aVar.hmj = new axx();
        aVar.hmk = new axy();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.hmi = 422;
        aVar.hml = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hmm = 1000000214;
        this.gJQ = aVar.JZ();
        axx com_tencent_mm_protocal_c_axx = (axx) this.gJQ.hmg.hmo;
        this.lyH = str;
        com_tencent_mm_protocal_c_axx.vIR = str;
        this.tak = str2;
        com_tencent_mm_protocal_c_axx.wEW = str2;
        this.taj = str3;
        com_tencent_mm_protocal_c_axx.wEX = str3;
        com_tencent_mm_protocal_c_axx.pbq = i2;
        com_tencent_mm_protocal_c_axx.wEY = i;
        com_tencent_mm_protocal_c_axx.nkB = str4;
        x.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.gJT.a(i, i2, str, this);
        } else {
            this.gJT.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return 422;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
