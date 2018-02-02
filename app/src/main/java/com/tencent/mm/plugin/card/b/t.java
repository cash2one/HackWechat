package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t {
    public static ArrayList<kj> xb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList<kj> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new kj();
                    obj.name = jSONObject.optString("name");
                    obj.descriptor = jSONObject.optString("descriptor");
                    obj.kKe = jSONObject.optString("phone");
                    obj.country = jSONObject.optString("country");
                    obj.fWp = jSONObject.optString("province");
                    obj.fWq = jSONObject.optString("city");
                    obj.hxu = jSONObject.optString("address");
                    obj.vRw = (float) jSONObject.optDouble("distance");
                    obj.fBc = (float) jSONObject.optDouble("longitude");
                    obj.fzt = (float) jSONObject.optDouble("latitude");
                    obj.kLB = jSONObject.optString("jump_url");
                    obj.vRx = jSONObject.optString("app_brand_user_name");
                    obj.vRy = jSONObject.optString("app_brand_pass");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
