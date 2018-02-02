package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends a {
    public n(String str, String str2, int i, long j, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("recv_username", str);
        hashMap.put("qrcodeid", str2);
        hashMap.put("currency", String.valueOf(i));
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", String.valueOf(i2));
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", new Object[]{str2, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", new Object[]{jSONObject.toString()});
        x.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
    }

    public final int getType() {
        return 1257;
    }

    public final int ayO() {
        return 1257;
    }
}
