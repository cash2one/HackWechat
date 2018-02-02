package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class j extends l {
    private static int zIn = 0;
    public RealnameGuideHelper oWt;
    private String oWu;
    private String oWv;
    private String oWw;
    private String oWx;
    private String oWy;
    protected int pak;
    public int sOf = 0;
    protected Map<String, String> zIl = new HashMap();
    public int zIm = 0;
    private boolean zIo = false;
    public int zIp = 0;
    public int zIq = 0;
    public String zIr = null;
    public JSONObject zIs = null;
    private boolean zIt = false;

    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        zIn++;
        this.zIl.put("req_key", str);
        this.zIl.put("transaction_id", str2);
        this.zIl.put("pay_scene", String.valueOf(i));
        this.zIl.put("bank_type", str3);
        this.zIl.put("channel", String.valueOf(i2));
        this.zIl.put("bind_serial", str4);
    }

    public final Map<String, String> cBR() {
        return this.zIl;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        if (!this.zIo) {
            this.zIq = i;
            this.zIr = str;
            this.zIs = jSONObject;
            this.zIo = true;
            if (jSONObject != null) {
                this.zIm = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject != null && jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.oWu = optJSONObject.optString("guide_flag");
            this.oWv = optJSONObject.optString("guide_wording");
            this.oWw = optJSONObject.optString("left_button_wording");
            this.oWx = optJSONObject.optString("right_button_wording");
            this.oWy = optJSONObject.optString("upload_credit_url");
            i2 = 1;
        }
        SetPwdInfo setPwdInfo = null;
        if (jSONObject != null && jSONObject.has("set_pwd_info")) {
            optJSONObject = jSONObject.optJSONObject("set_pwd_info");
            setPwdInfo = new SetPwdInfo();
            setPwdInfo.odv = optJSONObject.optString("guide_wording");
            setPwdInfo.odw = optJSONObject.optString("left_button_wording");
            setPwdInfo.odx = optJSONObject.optString("right_button_wording");
            setPwdInfo.sKq = optJSONObject.optInt("send_pwd_msg");
            i2 = 1;
        }
        if (i2 != 0 && ("1".equals(this.oWu) || "2".equals(this.oWu) || setPwdInfo != null)) {
            this.oWt = new RealnameGuideHelper();
            this.oWt.a(this.oWu, setPwdInfo, this.oWv, this.oWw, this.oWx, this.oWy, this.pak);
        }
        this.zIt = true;
        super.a(i, str, jSONObject);
    }

    public final boolean cBS() {
        return this.zIm == 1;
    }

    public final void a(c cVar, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(cVar.errCode), cVar.fnL);
        if (!this.zIt && !this.zIo) {
            this.zIp = cVar.errType;
            this.zIq = cVar.errCode;
            this.zIr = cVar.fnL;
            if (jSONObject != null) {
                this.zIm = jSONObject.optInt("query_order_flag", 0);
                this.zIs = jSONObject;
            }
            this.zIo = true;
        }
    }

    public boolean bJT() {
        return false;
    }

    public final boolean cBH() {
        return false;
    }
}
