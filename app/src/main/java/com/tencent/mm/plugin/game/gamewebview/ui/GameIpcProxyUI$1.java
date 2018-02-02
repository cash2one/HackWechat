package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.sdk.platformtools.x;

class GameIpcProxyUI$1 implements a {
    final /* synthetic */ String jbj;
    final /* synthetic */ GameProcessActivityTask mYq;
    final /* synthetic */ GameIpcProxyUI mYr;

    GameIpcProxyUI$1(GameIpcProxyUI gameIpcProxyUI, GameProcessActivityTask gameProcessActivityTask, String str) {
        this.mYr = gameIpcProxyUI;
        this.mYq = gameProcessActivityTask;
        this.jbj = str;
    }

    public final void afh() {
        x.i("MicroMsg.GameIpcProxyUI", "onResult");
        Intent intent = new Intent();
        intent.putExtra("task_object", this.mYq);
        intent.putExtra("task_id", this.jbj);
        this.mYr.setResult(-1, intent);
        this.mYr.finish();
    }
}
