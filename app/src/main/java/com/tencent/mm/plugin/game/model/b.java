package com.tencent.mm.plugin.game.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    public static a qL(int i) {
        a aVar = new a();
        c fn = com.tencent.mm.z.c.c.IF().fn("100001");
        if (fn.isValid()) {
            Map chI = fn.chI();
            aVar.fDt = bh.getInt((String) chI.get("game_homepage_jump"), 0);
            String str = (String) chI.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(fn, i, aVar.url, aVar.fDt);
            x.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", new Object[]{fn.field_layerId, fn.field_expId, Integer.valueOf(aVar.fDt), aVar.url});
            return aVar;
        }
        x.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fn.field_startTime), Long.valueOf(fn.field_endTime)});
        return aVar;
    }

    public static a br(String str, int i) {
        a aVar = new a();
        if (bh.ov(str)) {
            x.e(TAG, "appid is null");
            return aVar;
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100002");
        if (fn.isValid()) {
            x.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[]{fn.field_layerId});
            Map chI = fn.chI();
            aVar.fDt = bh.getInt((String) chI.get("game_detail_jump"), 0);
            String str2 = (String) chI.get("game_detail_url");
            aVar.url = str2 == null ? "" : str2 + str;
            a(fn, i, aVar.url, aVar.fDt);
            return aVar;
        }
        x.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fn.field_startTime), Long.valueOf(fn.field_endTime)});
        return aVar;
    }

    public static a aPQ() {
        a aVar = new a();
        c fn = com.tencent.mm.z.c.c.IF().fn("100003");
        if (fn.isValid()) {
            x.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[]{fn.field_layerId});
            Map chI = fn.chI();
            aVar.fDt = bh.getInt((String) chI.get("game_library_jump"), 0);
            String str = (String) chI.get("game_library_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(fn, 1005, aVar.url, aVar.fDt);
            return aVar;
        }
        x.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fn.field_startTime), Long.valueOf(fn.field_endTime)});
        return aVar;
    }

    public static a aPR() {
        a aVar = new a();
        c fn = com.tencent.mm.z.c.c.IF().fn("100022");
        if (!fn.isValid()) {
            return aVar;
        }
        Map chI = fn.chI();
        aVar.fDt = bh.getInt((String) chI.get("game_message_jump"), 0);
        String str = (String) chI.get("game_message_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        a(fn, 1001, aVar.url, aVar.fDt);
        return aVar;
    }

    private static void a(c cVar, int i, String str, int i2) {
        if (cVar == null) {
            x.i(TAG, "ABTestItem is null");
            return;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (!bh.ov(str)) {
                jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
            }
            jSONObject.put("jumpType", i2);
            str2 = p.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
        } catch (UnsupportedEncodingException e2) {
        }
        x.i(TAG, "reportABTest : " + cVar.field_layerId + " , " + cVar.field_business + " , " + cVar.field_expId + " , " + cVar.field_sequence + " , " + cVar.field_prioritylevel + " , " + cVar.field_startTime + " , " + cVar.field_endTime + " , " + i + " , " + str2);
        g.pQN.h(14841, new Object[]{cVar.field_layerId, cVar.field_business, cVar.field_expId, Long.valueOf(cVar.field_sequence), Integer.valueOf(cVar.field_prioritylevel), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), Integer.valueOf(i), str2});
    }
}
