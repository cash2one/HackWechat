package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class z extends a {
    public static final int CTRL_BYTE = 277;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launchMiniProgram";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        int i = 1;
        x.i("MicroMsg.GameJsApiLaunchMiniProgram", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiLaunchMiniProgram", "data is null");
            aVar.sj(a.e(a.e("launchMiniProgram:fail_null_data", null), null));
            return;
        }
        String optString = sc.optString("targetAppId");
        String optString2 = sc.optString("current_url");
        String optString3 = sc.optString("current_appid");
        if (bh.ov(optString3)) {
            optString3 = sc.optString("referrerAppId");
        }
        if (bh.ov(optString)) {
            aVar.sj(a.e("launchMiniProgram:fail_invalid_targetAppId", null));
        } else if (bh.ov(optString3)) {
            aVar.sj(a.e("launchMiniProgram:fail_invalid_referrerAppId", null));
        } else {
            String ou = bh.ou(sc.optString("envVersion"));
            int i2 = -1;
            switch (ou.hashCode()) {
                case 110628630:
                    if (ou.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (ou.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    break;
                case 1:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
            ((c) g.h(c.class)).a(context, optString2, optString3, optString, i, sc.optString("path"));
            aVar.sj(a.e("launchMiniProgram:ok", null));
        }
    }
}
