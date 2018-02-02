package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.ui.snackbar.b.b;

class i$9 implements b {
    i$9() {
    }

    public final void aPO() {
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 2;
        GameWebViewMainProcessService.a(favUrlTask);
    }
}
