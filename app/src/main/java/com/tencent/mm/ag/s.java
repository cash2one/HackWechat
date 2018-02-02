package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class s extends k implements com.tencent.mm.network.k {
    private Object data;
    public b gJQ;
    private e gJT;

    public static void a(e eVar) {
        g.Di().gPJ.b(1285, eVar);
    }

    public static boolean k(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            return g.Di().gPJ.a(new s(str, jSONObject.toString()), 0);
        } catch (Exception e) {
            return false;
        }
    }

    private s(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new zp();
        aVar.hmk = new zq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        aVar.hmi = 1285;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        zp zpVar = (zp) this.gJQ.hmg.hmo;
        zpVar.vYi = str;
        zpVar.pK = 1;
        zpVar.data = str2;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
