package com.tencent.mm.plugin.wallet_core.e;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import org.json.JSONObject;

public final class b {
    public static void ad(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            return;
        }
        x.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        int optInt = jSONObject.optInt("is_open_sns_pay", 0);
        int optInt2 = jSONObject.optInt("can_open_sns_pay", 0);
        int optInt3 = jSONObject.optInt("is_white_user", 0);
        if (optInt2 == 1) {
            str = jSONObject.optString("open_sns_pay_title");
            str2 = jSONObject.optString("open_sns_pay_wording");
            g.Dk();
            g.Dj().CU().a(a.xqV, str);
            g.Dk();
            g.Dj().CU().a(a.xqW, str2);
        }
        x.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        x.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str + ", open_sns_pay_wording:" + str2);
        g.Dk();
        g.Dj().CU().a(a.xqS, Integer.valueOf(optInt));
        g.Dk();
        g.Dj().CU().a(a.xqT, Integer.valueOf(optInt2));
        g.Dk();
        g.Dj().CU().a(a.xqU, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str = jSONObject.optString("set_sns_pay_title");
            str2 = jSONObject.optString("set_sns_pay_wording");
            g.Dk();
            g.Dj().CU().a(a.xqX, str);
            g.Dk();
            g.Dj().CU().a(a.xqY, str2);
        } else {
            str2 = str4;
            str = str3;
        }
        x.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str + ", set_sns_pay_wording:" + str2);
        g.Dk();
        g.Dj().CU().lH(true);
    }
}
