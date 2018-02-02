package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import org.json.JSONObject;

public class d {
    private static d sLt = null;

    public static d bKU() {
        if (sLt == null) {
            sLt = new d();
        }
        return sLt;
    }

    public Bankcard V(JSONObject jSONObject) {
        String str;
        int i = 1;
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object obj = jSONObject;
        }
        objArr[0] = str;
        x.i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[]{bankcard.field_bindSerial});
            bankcard.sLd = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 0)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.sKS;
            }
            if ("NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.sKT;
            }
            if ("QMF".equals(bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.sKY;
                JSONObject optJSONObject = jSONObject.optJSONObject("qmfCardInfo");
                if (optJSONObject != null) {
                    bankcard.sLo = optJSONObject.optLong("total_credit_line", 0);
                    bankcard.sLp = optJSONObject.optLong("use_credit_line", 0);
                    bankcard.sLq = optJSONObject.optLong("unuse_credit_line", 0);
                    bankcard.sLr = optJSONObject.optString("payer_username", "");
                    bankcard.sLs = optJSONObject.optInt("hide_credit_line", 0);
                }
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            if (bh.ov(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (bh.ov(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.sLa = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!bh.ov(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag != 2) {
                i = 0;
            }
            if (i != 0) {
                bankcard.field_cardType |= Bankcard.sKR;
            }
            CharSequence optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if ("0".equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            bankcard.field_support_lqt_turn_in = jSONObject.optInt("support_lqt_turn_in", 0);
            bankcard.field_support_lqt_turn_out = jSONObject.optInt("support_lqt_turn_out", 0);
            bankcard.field_is_hightlight_pre_arrive_time_wording = jSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            return null;
        } catch (Throwable e22) {
            x.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e22, "", new Object[0]);
            return null;
        }
    }

    public static Bankcard a(ku kuVar) {
        boolean z = true;
        x.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[]{kuVar});
        Bankcard bankcard = new Bankcard();
        try {
            boolean z2;
            bankcard.field_bankName = kuVar.nBM;
            bankcard.field_bankcardTypeName = kuVar.vKG;
            bankcard.field_bankcardType = kuVar.oZz;
            bankcard.field_bindSerial = kuVar.oZA;
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[]{bankcard.field_bindSerial});
            if (2 == bh.getInt(kuVar.vKE, 2)) {
                bankcard.field_cardType |= Bankcard.sKS;
            }
            if ("NORMAL".equals(kuVar.vTd)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.sKT;
            }
            if (!bh.ov(kuVar.fAf)) {
                bankcard.field_mobile = URLDecoder.decode(kuVar.fAf.replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            }
            bankcard.field_onceQuotaKind = bh.getDouble(kuVar.vSZ, 0.0d) / 100.0d;
            bankcard.field_onceQuotaVirtual = bh.getDouble(kuVar.vSX, 0.0d) / 100.0d;
            bankcard.field_dayQuotaKind = bh.getDouble(kuVar.vSV, 0.0d) / 100.0d;
            bankcard.field_dayQuotaVirtual = bh.getDouble(kuVar.vST, 0.0d) / 100.0d;
            bankcard.field_bankcardTail = kuVar.vKF;
            bankcard.field_forbidWord = kuVar.oZB;
            bankcard.field_repay_url = kuVar.tZm;
            bankcard.field_wxcreditState = 2;
            if (!bh.ov(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == bh.getInt(kuVar.vSW, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (bh.getInt(kuVar.sMB, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = kuVar.sMC;
            bankcard.field_fetchArriveTime = bh.getLong(kuVar.vTi, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = kuVar.vTu;
            bankcard.field_bankcardTag = bh.getInt(kuVar.vTa, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.sKR;
            }
            if (kuVar.vTf != 1) {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + kuVar.vTf);
            bankcard.field_arrive_type = kuVar.vTo;
            bankcard.field_avail_save_wording = kuVar.vTq;
            int i = kuVar.vTv;
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = kuVar.vTw;
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = kuVar.vTx;
            bankcard.field_tips = kuVar.kNs;
            bankcard.field_forbid_title = kuVar.vKx;
            bankcard.field_forbid_url = kuVar.vKy;
            bankcard.field_no_micro_word = kuVar.vTp;
            bankcard.field_card_bottom_wording = kuVar.vTD;
            bankcard.field_support_lqt_turn_in = kuVar.vTG;
            bankcard.field_support_lqt_turn_out = kuVar.vTH;
            bankcard.field_is_hightlight_pre_arrive_time_wording = kuVar.vTF;
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "parseFromBindQueryRecord() error:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void d(Bankcard bankcard) {
        if (bankcard != null) {
            if (bankcard.bKP()) {
                bankcard.field_desc = bankcard.field_bankName;
            } else if (bankcard.bKR()) {
                bankcard.field_desc = ac.getContext().getString(i.uRd, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else if (bankcard.bKO()) {
                bankcard.field_desc = ac.getContext().getString(i.uXU, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else {
                bankcard.field_desc = ac.getContext().getString(i.uRs, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            }
        }
    }
}
