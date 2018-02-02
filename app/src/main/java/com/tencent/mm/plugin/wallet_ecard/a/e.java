package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public int liH = 0;
    public String liI = "";
    public auq sZA;
    public String token = null;

    public e(String str, String str2, int i, String str3) {
        a aVar = new a();
        aVar.hmj = new aup();
        aVar.hmk = new auq();
        aVar.hmi = 1958;
        aVar.uri = "/cgi-bin/mmpay-bin/openecardauth";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aup com_tencent_mm_protocal_c_aup = (aup) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aup.vLI = str;
        com_tencent_mm_protocal_c_aup.wCB = str2;
        com_tencent_mm_protocal_c_aup.fCy = i;
        com_tencent_mm_protocal_c_aup.token = str3;
        this.token = null;
        x.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[]{str, Integer.valueOf(i), str3, Boolean.valueOf(bh.ov(str2))});
        x.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[]{str, Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sZA = (auq) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[]{Integer.valueOf(this.sZA.kLO), this.sZA.kLP, Boolean.valueOf(this.sZA.wCD)});
        if (!bh.ov(this.sZA.wCC)) {
            x.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[]{this.sZA.wCC});
            try {
                JSONObject jSONObject = new JSONObject(this.sZA.wCC);
                this.liH = jSONObject.optInt("retcode", 0);
                this.liI = jSONObject.optString("retmsg", "");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", e, "", new Object[0]);
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1958;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
