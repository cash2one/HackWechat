package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ag extends a {
    public static final int CTRL_BYTE = 250;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "openWeApp";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeApp", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiOpenWeApp", "data is null");
            aVar.sj(a.e("openWeApp:fail_null_data", null));
            return;
        }
        b qpVar = new qp();
        qpVar.fIi.context = context;
        qpVar.fIi.userName = sc.optString("userName");
        qpVar.fIi.appId = sc.optString("appId");
        qpVar.fIi.fIk = sc.optString("relativeURL");
        qpVar.fIi.fIm = sc.optInt("appVersion", 0);
        qpVar.fIi.scene = sc.optInt("scene", 1018);
        qpVar.fIi.fnp = sc.optString("sceneNote");
        if (bh.ov(qpVar.fIi.fnp)) {
            qpVar.fIi.fnp = p.encode(bh.ou(sc.optString("current_url")));
        }
        qpVar.fIi.fvR = sc.optString("downloadURL");
        qpVar.fIi.fIl = sc.optInt("openType", 0);
        qpVar.fIi.fIn = sc.optString("checkSumMd5");
        qpVar.fIi.fIp = false;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        if (qpVar.fIj.fIu) {
            aVar.sj(a.e("openWeApp:ok", null));
        } else {
            aVar.sj(a.e("openWeApp:fail:" + bh.ou(qpVar.fIj.fIv), null));
        }
    }
}
