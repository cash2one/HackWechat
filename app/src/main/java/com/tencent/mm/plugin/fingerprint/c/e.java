package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends i implements k {
    public String fxa = "";
    public String mzM = "";
    public String mzq = "";

    public e(String str) {
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            x.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        D(hashMap);
    }

    public final int ayQ() {
        return 118;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mzq = jSONObject.optString("encrypted_device_info");
            this.fxa = jSONObject.optString("encrypted_rsa_sign");
            this.mzM = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.mzq)) {
                x.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                x.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.fxa)) {
                x.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                x.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.mzM)) {
                x.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
            } else {
                x.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    public final int Hr() {
        return 1598;
    }
}
