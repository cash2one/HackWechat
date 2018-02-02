package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public c(String str, String str2, int i) {
        this(str, str2, i, (byte) 0);
    }

    private c(String str, String str2, int i, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("realname_scene", String.valueOf(i));
        x.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        D(hashMap);
    }

    public final int ayQ() {
        return 1648;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    public final int Hr() {
        return 1648;
    }
}
