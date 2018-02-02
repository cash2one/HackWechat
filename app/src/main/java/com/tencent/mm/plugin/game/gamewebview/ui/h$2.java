package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;

class h$2 implements OnCancelListener {
    final /* synthetic */ h mZZ;

    h$2(h hVar) {
        this.mZZ = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.mZZ.juW != null) {
            GWMainProcessTask qBarLogicTask = new QBarLogicTask();
            qBarLogicTask.type = 1;
            qBarLogicTask.fzs = this.mZZ.juW.tvd;
            GameWebViewMainProcessService.a(qBarLogicTask);
            this.mZZ.juW.bRG();
        }
    }
}
