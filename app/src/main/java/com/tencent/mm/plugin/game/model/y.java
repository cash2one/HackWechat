package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.gq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y {
    static void a(gq gqVar) {
        String str = gqVar.fwK.fwF;
        x.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[]{str});
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull(DownloadSettingTable$Columns.TYPE) || bh.getInt(jSONObject.optString(DownloadSettingTable$Columns.TYPE), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    SubCoreGameCenter.aRd().e(jArr);
                } else if (bh.getInt(jSONObject.optString(DownloadSettingTable$Columns.TYPE), 0) == 65536) {
                    SubCoreGameCenter.aRd().fx("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                }
            } catch (JSONException e) {
                x.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
