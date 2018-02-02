package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.game.c;

class d$1 extends c {
    final /* synthetic */ d mZC;

    d$1(d dVar) {
        this.mZC = dVar;
    }

    protected final void A(Bundle bundle) {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 11;
        commonLogicTask.msB = bundle;
        GameWebViewMainProcessService.b(commonLogicTask);
    }
}
