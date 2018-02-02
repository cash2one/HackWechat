package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;
import com.tencent.mm.plugin.webview.modeltools.g$c;

class h$1 implements g$c {
    final /* synthetic */ h mZZ;

    h$1(h hVar) {
        this.mZZ = hVar;
    }

    public final void sT(String str) {
        GWMainProcessTask qBarLogicTask = new QBarLogicTask();
        qBarLogicTask.type = 1;
        qBarLogicTask.fzs = str;
        GameWebViewMainProcessService.a(qBarLogicTask);
    }
}
