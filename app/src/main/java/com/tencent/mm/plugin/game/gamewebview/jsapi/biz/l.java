package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_BYTE = 300;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "clearGameData";

    public final void a(Context context, String str, GameJsApiMMTask$a gameJsApiMMTask$a) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            gameJsApiMMTask$a.sj(a.e("clearGameData:fail_null_data", null));
            return;
        }
        String optString = sc.optString("current_appid");
        if (bh.ov(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            gameJsApiMMTask$a.sj(a.e("clearGameData:fail_appid_null", null));
            return;
        }
        JSONArray optJSONArray = sc.optJSONArray("keys");
        boolean optBoolean = sc.optBoolean("clearAllData", false);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            b.bPa().b(optString, optJSONArray);
            gameJsApiMMTask$a.sj(a.e("clearGameData:ok", null));
        } else if (optBoolean) {
            b.bPa().NV(optString);
            gameJsApiMMTask$a.sj(a.e("clearGameData:ok", null));
        } else {
            x.i("MicroMsg.GameJsApiSetGameData", "keys is null");
            gameJsApiMMTask$a.sj(a.e("clearGameData:fail", null));
        }
    }
}
