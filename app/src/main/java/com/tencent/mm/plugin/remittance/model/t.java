package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t extends i {
    public String fEs;
    public a fHg;
    public String fuI;
    public String fwY = null;
    public String lie;
    public String ljT;
    public int nZd;
    public int pKI = 0;
    public String pKJ;
    public String pKK;
    public double pKL;
    public double pKM;
    public String pKN;
    public boolean pKO;
    public double pKP;
    public String pKQ;
    public double pKR;
    public double pKS;
    public String pKT;
    public String pKU;
    public String pKV;
    public double pKW = 0.0d;
    public String pKX = "";
    public String pKY = "";
    public String pKZ;
    public int pLa;
    public String pLb;
    public String pLc;
    private int pak;

    public t(double d, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, int i3, String str7) {
        x.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)});
        this.pKW = d;
        this.pak = i;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("transfer_scene", String.valueOf(i2));
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("receiver_openid", str7);
        hashMap.put("mask_truename", str3);
        try {
            long longValue;
            int i4;
            Map hashMap2;
            if (this.pak == 33 || this.pak == 32) {
                x.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[]{str4, str5});
                if (!bh.ov(str4)) {
                    hashMap.put("f2f_payer_desc", p.encode(str4, "UTF-8"));
                }
                if (!bh.ov(str5)) {
                    hashMap.put("desc", p.encode(str5, "UTF-8"));
                }
                hashMap.put("transfer_qrcode_id", str6);
                if (i2 == 0 || i2 == 2) {
                    g.Dk();
                    longValue = ((Long) g.Dj().CU().get(147457, Long.valueOf(0))).longValue();
                    i4 = 0;
                    if ((16 & longValue) != 0) {
                        i4 = 2;
                    } else if ((longValue & 32) != 0) {
                        i4 = 1;
                    }
                    hashMap.put("delay_confirm_flag", String.valueOf(i4));
                    x.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
                }
                D(hashMap);
                if (this.pak != 32 || this.pak == 33) {
                    hashMap2 = new HashMap();
                    hashMap2.put("channel", String.valueOf(i3));
                    aB(hashMap2);
                }
                return;
            }
            if (!bh.ov(str4)) {
                hashMap.put("desc", p.encode(str4, "UTF-8"));
            }
            hashMap.put("transfer_qrcode_id", str6);
            g.Dk();
            longValue = ((Long) g.Dj().CU().get(147457, Long.valueOf(0))).longValue();
            i4 = 0;
            if ((16 & longValue) != 0) {
                i4 = 2;
            } else if ((longValue & 32) != 0) {
                i4 = 1;
            }
            hashMap.put("delay_confirm_flag", String.valueOf(i4));
            x.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
            D(hashMap);
            if (this.pak != 32) {
            }
            hashMap2 = new HashMap();
            hashMap2.put("channel", String.valueOf(i3));
            aB(hashMap2);
        } catch (UnsupportedEncodingException e) {
            x.e("Micromsg.NetSceneTenpayRemittanceGen", e.getMessage(), new Object[]{e});
        }
    }

    public final int Hr() {
        if (this.pak == 32 || this.pak == 33) {
            return 1582;
        }
        return 1544;
    }

    public final int ayQ() {
        return 0;
    }

    public final String getUri() {
        if (this.pak == 32 || this.pak == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        x.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i + " errMsg: " + str);
        if (i == 0 || i == 2) {
            if (jSONObject.has("used_fee")) {
                this.pKS = jSONObject.optDouble("used_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.fwY = jSONObject.optString("req_key");
            this.pKI = jSONObject.optInt("tansfering_num", 0);
            this.pKJ = jSONObject.optString("transfer_interrupt_desc");
            this.pKK = jSONObject.optString("appmsgcontent");
            this.pKN = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") != 1) {
                z = false;
            }
            this.pKO = z;
            this.pKT = jSONObject.optString("receiver_true_name");
            this.pKU = jSONObject.optString("f2f_id", "");
            this.lie = jSONObject.optString("trans_id", "");
            this.ljT = jSONObject.optString("extend_str", "");
            this.pKV = jSONObject.optString("receiver_open_id", "");
            this.nZd = jSONObject.optInt("amount", 0);
            this.fEs = jSONObject.optString("transfer_id", "");
            this.fuI = jSONObject.optString("transaction_id", "");
            this.pKZ = jSONObject.optString("receiver_openid", "");
            if (bh.ov(this.pKT)) {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.pKP = jSONObject.optDouble("remain_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.pKR = jSONObject.optDouble("exceed_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.pKL = jSONObject.optDouble("charge_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.pKM = jSONObject.optDouble("free_limit");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                x.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("showmessage");
                aVar.odw = optJSONObject.optString("left_button_wording");
                aVar.odx = optJSONObject.optString("right_button_wording");
                aVar.liO = optJSONObject.optString("right_button_url");
                this.fHg = aVar;
                this.fHg.fyY = str;
            }
            if (jSONObject.has("fee")) {
                this.pKX = jSONObject.optString("fee");
            }
            if (jSONObject.has("double_check_wording")) {
                x.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
                this.pKY = jSONObject.optString("double_check_wording");
            }
            this.pLa = jSONObject.optInt("scan_scene", 0);
            this.pLb = jSONObject.optString("placeorder_suc_sign");
            this.pLc = jSONObject.optString("pay_suc_extend");
            if (TextUtils.isEmpty(this.pKK)) {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
        }
    }

    public final boolean bnA() {
        return true;
    }
}
