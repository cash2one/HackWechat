package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class at extends a {
    public static final int CTRL_BYTE = 298;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "setGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.sj(a.e("setGameData:fail_null_data", null));
            return;
        }
        String optString = sc.optString("current_appid");
        if (bh.ov(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.sj(a.e("setGameData:fail_appid_null", null));
            return;
        }
        String optString2 = sc.optString("key");
        String optString3 = sc.optString(DownloadSettingTable$Columns.VALUE);
        String optString4 = sc.optString("weight", "1");
        String optString5 = sc.optString("expireTime");
        boolean optBoolean = sc.optBoolean("autoClean", true);
        if (bh.ov(optString2) || bh.ov(optString3)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key or value is null");
            aVar.sj(a.e("setGameData:fail_null_key", null));
        } else if (b.bPa().a(optString, optString2, optString3, optString4, optString5, optBoolean)) {
            aVar.sj(a.e("setGameData:ok", null));
        } else {
            aVar.sj(a.e("setGameData:fail_exceed_size", null));
        }
    }
}
