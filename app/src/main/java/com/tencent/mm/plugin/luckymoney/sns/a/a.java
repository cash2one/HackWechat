package com.tencent.mm.plugin.luckymoney.sns.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public int ofN = 0;

    public a(int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        this.ofN = i;
        D(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    public final int Hr() {
        return 1697;
    }

    public final int ayQ() {
        return 1697;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            x.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
        } else if (this.ofN == 1) {
            com.tencent.mm.plugin.luckymoney.sns.b.a.sc(1);
            x.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
        } else {
            com.tencent.mm.plugin.luckymoney.sns.b.a.sc(0);
            x.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
        }
    }
}
