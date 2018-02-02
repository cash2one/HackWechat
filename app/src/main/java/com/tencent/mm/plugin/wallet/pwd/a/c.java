package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public int sGu;
    public String sGv;
    public int sGw;
    public String sGx;
    public String sGy;

    public c() {
        Map hashMap = new HashMap();
        hashMap.put("deviceid", q.getDeviceID(ac.getContext()));
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        x.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[]{jSONObject.toString()});
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", "0");
            if (!wP(optString)) {
                optString = "0";
            }
            this.sGu = Integer.valueOf(optString).intValue();
            this.sGv = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!wP(optString)) {
                optString = "84600";
            }
            this.sGw = Integer.valueOf(optString).intValue();
            this.sGx = jSONObject.optString("deduct_title", "");
            this.sGy = jSONObject.optString("realname_url", "");
            optString = jSONObject.optString("payway_select_wording", "");
            String optString2 = jSONObject.optString("payway_change_wording", "");
            com.tencent.mm.sdk.e.c zVar = new z();
            zVar.field_is_show = this.sGu;
            zVar.field_pref_key = "wallet_open_auto_pay";
            zVar.field_pref_title = this.sGx;
            zVar.field_pref_url = this.sGv;
            h bLp = o.bLp();
            String str2 = "wallet_open_auto_pay";
            if (!bh.ov(str2)) {
                bLp.gJP.fx("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str2 + "'");
            }
            x.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s", new Object[]{Integer.valueOf(this.sGw)});
            o.bLp().b(zVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject != null) {
                String optString3 = optJSONObject.optString("unreg_title", "");
                String optString4 = optJSONObject.optString("unreg_url", "");
                g.Dk();
                g.Dj().CU().a(a.xwJ, optString3);
                g.Dk();
                g.Dj().CU().a(a.xwK, optString4);
            } else {
                g.Dk();
                g.Dj().CU().a(a.xwJ, "");
                g.Dk();
                g.Dj().CU().a(a.xwK, "");
            }
            g.Dk();
            g.Dj().CU().a(a.xrk, Long.valueOf(new Date().getTime() / 1000));
            g.Dk();
            g.Dj().CU().a(a.xrl, Integer.valueOf(this.sGw));
            g.Dk();
            g.Dj().CU().a(a.xrr, this.sGy);
            if (!bh.ov(optString)) {
                g.Dk();
                g.Dj().CU().a(a.xry, optString);
            }
            if (!bh.ov(optString2)) {
                g.Dk();
                g.Dj().CU().a(a.xrz, optString2);
            }
            g.Dk();
            g.Dj().CU().lH(true);
        }
    }

    public static boolean bDH() {
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(a.xrk, Long.valueOf(0))).longValue();
        g.Dk();
        x.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[]{Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) g.Dj().CU().get(a.xrl, Integer.valueOf(0))).intValue()) + longValue)});
        if (longValue <= 0) {
            return true;
        }
        if (Long.valueOf(new Date().getTime() / 1000).longValue() > longValue + ((long) r0)) {
            return true;
        }
        return false;
    }

    private static boolean wP(String str) {
        if (bh.ov(str)) {
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            charAt = str.charAt(length);
            if (charAt < '0') {
                return false;
            }
        } while (charAt <= '9');
        return false;
    }

    public final int Hr() {
        return 1654;
    }

    public final int bKu() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
