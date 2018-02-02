package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
    public static LinkedList<kp> aZ(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                x.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                return null;
            }
            LinkedList<kp> linkedList = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                kp kpVar = new kp();
                kpVar.kJN = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
                kpVar.code = optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                linkedList.add(kpVar);
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
