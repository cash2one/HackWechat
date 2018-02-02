package com.tencent.mm.bc;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.bew;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static bew hKD;

    public static bew QU() {
        if (hKD == null) {
            String QV = QV();
            hKD = new bew();
            QV = ac.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(QV, "");
            if (!bh.ov(QV)) {
                try {
                    hKD.aF(Base64.decode(QV.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hKD;
    }

    public static String QV() {
        return "key_pb_history_list" + q.FS();
    }

    public static String QW() {
        bew QU = QU();
        int size = QU.ksP.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (i < QU.ksP.size() && i < size) {
                bev com_tencent_mm_protocal_c_bev = (bev) QU.ksP.get(i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("word", com_tencent_mm_protocal_c_bev.wKh);
                jSONArray2.put(jSONObject3);
                i++;
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put(DownloadSettingTable$Columns.TYPE, 4);
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
