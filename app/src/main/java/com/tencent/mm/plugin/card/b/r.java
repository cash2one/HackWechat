package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
    public static j wX(String str) {
        x.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.kNj = jSONObject.optString("consumed_box_id");
            jVar.kNk = jSONObject.optString("subscribe_wording");
            jVar.kNl = jSONObject.optString("subscribe_app_username");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                q qVar = new q();
                qVar.fGV = optJSONObject.optString("card_ext");
                qVar.kKS = f.y(optJSONObject.optJSONObject("card_tp_info"));
                arrayList.add(qVar);
            }
            jVar.kNi = arrayList;
            x.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + arrayList.size());
            if (TextUtils.isEmpty(jVar.kNj)) {
                x.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
            }
            if (TextUtils.isEmpty(jVar.kNk)) {
                x.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
            }
            return jVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + e.getMessage());
            x.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", e, "", new Object[0]);
            return null;
        }
    }
}
