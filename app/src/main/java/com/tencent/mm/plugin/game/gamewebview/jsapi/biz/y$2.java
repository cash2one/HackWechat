package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class y$2 implements a {
    final /* synthetic */ y mWN;
    final /* synthetic */ GameJsApiMMTask.a mWu;

    y$2(y yVar, GameJsApiMMTask.a aVar) {
        this.mWN = yVar;
        this.mWu = aVar;
    }

    public final void cG(boolean z) {
        GameJsApiMMTask.a aVar = this.mWu;
        y yVar = this.mWN;
        aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launch_3rdApp:ok", null));
    }
}
