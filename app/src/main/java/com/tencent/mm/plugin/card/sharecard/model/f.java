package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kJA;
    public int kJB = 0;
    public String kJC;
    public int kJD;
    public String kJE;
    public String kNg;

    public f(String str, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hmj = new aqk();
        aVar.hmk = new aql();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.hmi = 907;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aqk com_tencent_mm_protocal_c_aqk = (aqk) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aqk.fGU = str;
        com_tencent_mm_protocal_c_aqk.wxh = i2;
        com_tencent_mm_protocal_c_aqk.wxg = i;
        com_tencent_mm_protocal_c_aqk.scene = i3;
        this.kNg = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aql com_tencent_mm_protocal_c_aql = (aql) this.gJQ.hmh.hmo;
            x.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + com_tencent_mm_protocal_c_aql.kLN);
            Object obj = com_tencent_mm_protocal_c_aql.kLN;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    this.kJA = jSONObject.optString("mark_user");
                    this.kJB = jSONObject.optInt("mark_succ", 0);
                    this.kJC = jSONObject.optString("mark_card_id");
                    this.kJD = jSONObject.optInt("expire_time", 0);
                    this.kJE = jSONObject.optString("pay_qrcode_wording");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 907;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
