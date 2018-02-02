package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public static final int CTRL_BYTE = 299;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getGameData";

    public final void a(Context context, String str, GameJsApiMMTask$a gameJsApiMMTask$a) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            gameJsApiMMTask$a.sj(a.e("getGameData:fail_null_data", null));
            return;
        }
        String optString = sc.optString("current_appid");
        if (bh.ov(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            gameJsApiMMTask$a.sj(a.e("getGameData:fail_appid_null", null));
            return;
        }
        String optString2 = sc.optString("key");
        if (bh.ov(optString2)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key is null");
            gameJsApiMMTask$a.sj(a.e("getGameData:fail_null_key", null));
            return;
        }
        com.tencent.mm.plugin.webview.b.a eH = b.bPa().eH(optString, optString2);
        if (bh.ov(eH.field_value)) {
            gameJsApiMMTask$a.sj(a.e("getGameData:ok", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.VALUE, eH.field_value);
        hashMap.put("weight", eH.field_weight);
        hashMap.put("expireTime", Long.valueOf(eH.field_expireTime - (System.currentTimeMillis() / 1000)));
        gameJsApiMMTask$a.sj(e("getGameData:ok", hashMap));
    }
}
