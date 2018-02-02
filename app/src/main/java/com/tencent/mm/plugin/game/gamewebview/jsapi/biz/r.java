package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends a {
    public static final int CTRL_BYTE = -2;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getLocalWePkgInfo";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiGetLocalWePkgInfo", "invoke");
        ag.y(new 1(this, aVar));
    }
}
