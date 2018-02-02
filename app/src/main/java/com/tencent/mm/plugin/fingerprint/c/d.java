package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.soter.c.b;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i implements k {
    public d() {
        Map hashMap = new HashMap();
        c bCP = b.bCP();
        String str = bCP.rSm;
        String str2 = bCP.rSn;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        D(hashMap);
    }

    public final int ayQ() {
        return 116;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            int optInt;
            if (jSONObject != null) {
                optInt = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                optInt = 0;
            }
            a.aJS();
            a.aJT();
            new Object[1][0] = Integer.valueOf(optInt);
            ((l) g.h(l.class)).aKl();
            return;
        }
        x.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        com.tencent.mm.plugin.report.service.g.pQN.h(13686, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            e.fj(false);
            x.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            return;
        }
        x.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
    }

    public final int Hr() {
        return 1597;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
