package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";
    public List<a> list = new LinkedList();

    public w() {
        g.Dk();
        String str = (String) g.Dj().CU().get(a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) "");
        this.list.clear();
        if (!bh.ov(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.sPw = jSONObject.optInt("paymenu_jump_type");
                    aVar.sPx = jSONObject.optString("paymenu_jump_url");
                    aVar.sPy = jSONObject.optString("paymenu_path");
                    aVar.sPz = jSONObject.optString("paymenu_title");
                    aVar.sPA = jSONObject.optString("paymenu_username");
                    this.list.add(aVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void MV(String str) {
        g.Dk();
        g.Dj().CU().a(a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) str);
    }
}
