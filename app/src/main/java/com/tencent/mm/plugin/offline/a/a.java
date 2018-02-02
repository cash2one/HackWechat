package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends l {
    private final b gJQ;
    private e gJT;
    private ArrayList<String> jpU;
    private String oWk;
    private String oWl;

    public final int getType() {
        return 606;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        adv com_tencent_mm_protocal_c_adv = (adv) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_adv.wmn)) {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_adv.wmn);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.oWl = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.c.a.ur(optInt);
                    com.tencent.mm.plugin.offline.c.a.us(optInt2);
                    x.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_adv.wmo)) {
                    L(new JSONObject(com_tencent_mm_protocal_c_adv.wmo));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ac.getContext().getString(i.uRf);
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    private void L(JSONObject jSONObject) {
        this.oWk = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.jpU.add((String) jSONArray.get(i));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
        }
    }
}
