package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;

class GameWebViewMainProcessService$2 extends a {
    final /* synthetic */ GameWebViewMainProcessService mVZ;

    GameWebViewMainProcessService$2(GameWebViewMainProcessService gameWebViewMainProcessService) {
        this.mVZ = gameWebViewMainProcessService;
    }

    public final void s(Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        GameWebViewMainProcessService.a(this.mVZ).send(obtain);
    }

    public final void t(Bundle bundle) {
        GameWebViewMainProcessService.e(bundle, false).Yr();
    }
}
