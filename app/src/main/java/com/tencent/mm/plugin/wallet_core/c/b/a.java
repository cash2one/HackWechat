package com.tencent.mm.plugin.wallet_core.c.b;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    private boolean sJb;

    public a() {
        this("");
    }

    public a(String str) {
        this(str, true);
    }

    public a(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        D(hashMap);
        this.sJb = z;
    }

    public final int bKL() {
        return 1;
    }

    public final int a(e eVar, com.tencent.mm.ae.e eVar2) {
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            try {
                Bankcard bankcard;
                long optLong = jSONObject.optLong("time_stamp");
                if (optLong > 0) {
                    n.setTimeStamp(String.valueOf(optLong));
                } else {
                    x.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                af afVar = new af();
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    afVar = null;
                } else {
                    afVar.field_is_reg = bh.getInt(jSONObject2.optString("is_reg"), 0);
                    afVar.field_true_name = jSONObject2.optString("true_name");
                    afVar.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                    afVar.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                    o.bLq();
                    ag.MY(afVar.field_main_card_bind_serialno);
                }
                afVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
                ArrayList t = t(jSONObject.optJSONArray("Array"));
                jSONObject2 = jSONObject.optJSONObject("balance_info");
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    bankcard = null;
                } else {
                    bankcard = new Bankcard((byte) 0);
                    bankcard.sLf = ((double) jSONObject2.optInt("avail_balance")) / 100.0d;
                    bankcard.sLh = ((double) jSONObject2.optInt("fetch_balance")) / 100.0d;
                    bankcard.field_bankcardType = jSONObject2.optString("balance_bank_type");
                    bankcard.field_bindSerial = jSONObject2.optString("balance_bind_serial");
                    bankcard.field_forbidWord = jSONObject2.optString("balance_forbid_word");
                    bankcard.field_desc = ac.getContext().getString(i.uRO);
                    bankcard.field_cardType |= Bankcard.sKU;
                }
                o.bLq().a(afVar, t, null, bankcard, null, null, null, null, 0, 0, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", e, "", new Object[0]);
            }
            if (this.sJb && !o.bLq().bLM()) {
                this.gJT.a(1000, -100869, "", this);
                this.zHv = true;
            }
        }
    }

    private static ArrayList<Bankcard> t(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("extra_bind_flag", "NORMAL");
                Bankcard V = com.tencent.mm.plugin.wallet_core.model.a.a.bMj().V(jSONObject);
                if (V != null) {
                    arrayList.add(V);
                }
            }
        }
        return arrayList;
    }
}
