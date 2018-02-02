package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaf;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ab extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;
    public int kLZ;
    public String kMa;
    public int kMb;
    public String kMc;

    public ab(LinkedList<kh> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        a aVar = new a();
        aVar.hmj = new aaf();
        aVar.hmk = new aag();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        aVar.hmi = 690;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aaf com_tencent_mm_protocal_c_aaf = (aaf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aaf.vEL = linkedList;
        com_tencent_mm_protocal_c_aaf.fGW = i;
        com_tencent_mm_protocal_c_aaf.vHA = str;
        com_tencent_mm_protocal_c_aaf.sign = str2;
        com_tencent_mm_protocal_c_aaf.vEH = str3;
        com_tencent_mm_protocal_c_aaf.vEG = str4;
        com_tencent_mm_protocal_c_aaf.wjt = str5;
        com_tencent_mm_protocal_c_aaf.vEI = i2;
    }

    public final int getType() {
        return 690;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.kLN = ((aag) this.gJQ.hmh.hmo).kLN;
            if (TextUtils.isEmpty(this.kLN)) {
                x.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.kLN);
                    this.kLZ = jSONObject.optInt("accept_button_status", 0);
                    this.kMa = jSONObject.optString("accept_button_wording");
                    this.kMb = jSONObject.optInt("private_status", 0);
                    this.kMc = jSONObject.optString("private_wording");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    x.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
