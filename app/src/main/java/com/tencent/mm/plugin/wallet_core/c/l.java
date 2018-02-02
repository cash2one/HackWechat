package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends i {
    public l() {
        D(new HashMap());
    }

    public final int ayQ() {
        return 1631;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : " + i);
        if (i == 0) {
            o.bLt().gJP.fx("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                x.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        c ab = com.tencent.mm.plugin.wallet_core.model.x.ab(optJSONArray.optJSONObject(i2));
                        if (ab != null) {
                            o.bLt().b(ab);
                        }
                    }
                    return;
                }
                x.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                return;
            }
            x.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    public final int Hr() {
        return 1631;
    }
}
