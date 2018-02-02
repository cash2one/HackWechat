package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b extends j {
    private Map<String, String> oWX;
    private Map<String, String> sEq;
    public boolean sEr;
    public Orders sEs;
    public Authen sEt;
    public String sEu;
    public String sEv;
    private String sEw;
    public int sEx;
    public String sEy;
    public int sEz;
    public String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b) {
        String str = null;
        this.sEr = false;
        this.sEs = null;
        this.token = null;
        this.sEu = null;
        this.sEv = null;
        this.sEw = null;
        this.sEx = 0;
        this.sEz = 0;
        this.sEt = authen;
        this.sEs = orders;
        if (authen == null) {
            throw new IllegalArgumentException("authen == null");
        }
        List list = orders.sNW;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fuI;
        }
        a(orders.fuH, str, authen.pCn.fCV, authen.pCn.fCR, authen.oZz, authen.oZA);
        if (authen.pCn == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.pCn.fCR);
        this.oWX = new HashMap();
        this.sEq = new HashMap();
        boolean z2 = (z || bh.ov(this.sEt.sKs)) ? false : true;
        x.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[]{Boolean.valueOf(z2)});
        a(authen.pCn, this.oWX, this.sEq, z2);
        if (z) {
            this.oWX.put("brief_reg", "1");
        } else {
            this.oWX.put("passwd", authen.sKs);
        }
        this.sOf = orders.sOf;
        this.oWX.put("default_favorcomposedid", authen.sKD);
        this.oWX.put("favorcomposedid", authen.sKE);
        this.oWX.put("arrive_type", authen.sKA);
        this.oWX.put("sms_flag", authen.sKF);
        this.oWX.put("ban_sms_bind_serial", authen.sKG);
        this.oWX.put("ban_sms_bank_type", authen.sKH);
        this.oWX.put("busi_sms_flag", authen.sKI);
        this.oWX.put("buttontype", authen.pCn.vzF);
        x.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s", new Object[]{Integer.valueOf(authen.pCn.vzF), Integer.valueOf(this.sOf)});
        switch (authen.fDt) {
            case 1:
                this.oWX.put("flag", "1");
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("true_name", authen.sKt);
                this.oWX.put("identify_card", authen.sKu);
                if (authen.sKv > 0) {
                    this.oWX.put("cre_type", authen.sKv);
                }
                this.oWX.put("mobile_no", authen.sIF);
                this.oWX.put("bank_card_id", authen.sKw);
                if (!bh.ov(authen.sKx)) {
                    this.oWX.put("cvv2", authen.sKx);
                }
                if (!bh.ov(authen.sKy)) {
                    this.oWX.put("valid_thru", authen.sKy);
                    break;
                }
                break;
            case 2:
                this.oWX.put("flag", "2");
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("h_bind_serial", authen.oZA);
                this.oWX.put("card_tail", authen.sKz);
                if (!bh.ov(authen.sKt)) {
                    this.oWX.put("true_name", authen.sKt);
                }
                if (!bh.ov(authen.sKu)) {
                    this.oWX.put("identify_card", authen.sKu);
                }
                this.oWX.put("cre_type", authen.sKv);
                this.oWX.put("mobile_no", authen.sIF);
                this.oWX.put("bank_card_id", authen.sKw);
                if (!bh.ov(authen.sKx)) {
                    this.oWX.put("cvv2", authen.sKx);
                }
                if (!bh.ov(authen.sKy)) {
                    this.oWX.put("valid_thru", authen.sKy);
                    break;
                }
                break;
            case 3:
                if (authen.sKr == 1) {
                    this.oWX.put("reset_flag", "1");
                    if (!bh.ov(authen.sIF)) {
                        this.oWX.put("mobile_no", authen.sIF);
                    }
                    if (!bh.ov(authen.sKx)) {
                        this.oWX.put("cvv2", authen.sKx);
                    }
                    if (!bh.ov(authen.sKy)) {
                        this.oWX.put("valid_thru", authen.sKy);
                    }
                }
                this.oWX.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("bind_serial", authen.oZA);
                break;
            case 4:
                this.oWX.put("flag", "4");
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("first_name", authen.sKB);
                this.oWX.put("last_name", authen.sKC);
                this.oWX.put("country", authen.country);
                this.oWX.put("area", authen.fWp);
                this.oWX.put("city", authen.fWq);
                this.oWX.put("address", authen.hxu);
                this.oWX.put("phone_number", authen.nBO);
                this.oWX.put("zip_code", authen.ilY);
                this.oWX.put("email", authen.fWi);
                this.oWX.put("bank_card_id", authen.sKw);
                if (!bh.ov(authen.sKx)) {
                    this.oWX.put("cvv2", authen.sKx);
                }
                if (!bh.ov(authen.sKy)) {
                    this.oWX.put("valid_thru", authen.sKy);
                    break;
                }
                break;
            case 5:
                this.oWX.put("flag", "5");
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("first_name", authen.sKB);
                this.oWX.put("last_name", authen.sKC);
                this.oWX.put("country", authen.country);
                this.oWX.put("area", authen.fWp);
                this.oWX.put("city", authen.fWq);
                this.oWX.put("address", authen.hxu);
                this.oWX.put("phone_number", authen.nBO);
                this.oWX.put("zip_code", authen.ilY);
                this.oWX.put("email", authen.fWi);
                this.oWX.put("bank_card_id", authen.sKw);
                if (!bh.ov(authen.sKx)) {
                    this.oWX.put("cvv2", authen.sKx);
                }
                if (!bh.ov(authen.sKy)) {
                    this.oWX.put("valid_thru", authen.sKy);
                }
                this.oWX.put("h_bind_serial", authen.oZA);
                this.oWX.put("card_tail", authen.sKz);
                break;
            case 6:
                if (authen.sKr == 1) {
                    this.oWX.put("reset_flag", "1");
                    if (!bh.ov(authen.sKx)) {
                        this.oWX.put("cvv2", authen.sKx);
                    }
                    if (!bh.ov(authen.sKy)) {
                        this.oWX.put("valid_thru", authen.sKy);
                    }
                }
                this.oWX.put("phone_number", authen.sIF);
                this.oWX.put("flag", "6");
                this.oWX.put("bank_type", authen.oZz);
                this.oWX.put("bind_serial", authen.oZA);
                break;
        }
        S(this.oWX);
        D(this.oWX);
        Map aKo = ((l) g.h(l.class)).aKo();
        if (aKo != null) {
            this.sEq.putAll(aKo);
        }
        if (o.cBs()) {
            this.sEq.put("uuid_for_bindcard", o.cBu());
            this.sEq.put("bindcard_scene", o.cBt());
        }
        aB(this.sEq);
    }

    protected void S(Map<String, String> map) {
    }

    public final boolean bhc() {
        super.bhc();
        this.oWX.put("is_repeat_send", "1");
        D(this.oWX);
        return true;
    }

    public int ayQ() {
        return 0;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        x.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        x.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[]{this.sEu});
        this.sEr = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.sEu = jSONObject.optString("balance_mobile");
        this.sEv = jSONObject.optString("balance_help_url");
        this.sEw = jSONObject.optString("modify_mobile_url");
        String optString = jSONObject.optString("bind_serial");
        if (!bh.ov(optString)) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.sFA = true;
            this.sEs = Orders.a(jSONObject, this.sEs);
        } else {
            this.sFA = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("verify_cre_tail_info");
        if (optJSONObject != null) {
            this.sEx = optJSONObject.optInt("is_can_verify_tail", 0);
            this.sEy = optJSONObject.optString("verify_tail_wording");
        }
        this.sEz = jSONObject.optInt("no_reset_mobile", 0);
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.sEt.pCn.fCV);
        if (i == 0 && this.sEt.pCn.fCV == 39) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            com.tencent.mm.plugin.wallet_core.e.b.ad(jSONObject);
            return;
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + i);
    }

    public final String bhV() {
        return this.token;
    }

    public String getUri() {
        if (this.sEt.pCn.fCV == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.sEt.pCn.fCV == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    public int Hr() {
        if (this.sEt.pCn.fCV == 11) {
            return 1610;
        }
        if (this.sEt.pCn.fCV == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean bJS() {
        return this.sEt.pCn.vzy == 1;
    }

    public final boolean bJT() {
        if (this.sEt.pCn.fCV == 11 || this.sEt.pCn.fCV == 21) {
            return true;
        }
        return false;
    }
}
