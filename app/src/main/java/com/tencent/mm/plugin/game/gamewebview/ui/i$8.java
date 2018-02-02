package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;

class i$8 implements d {
    final /* synthetic */ i nai;

    i$8(i iVar) {
        this.nai = iVar;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case -1:
                Bundle bundle = new Bundle();
                bundle.putLong("fav_local_id", this.nai.getBundle().getLong("fav_local_id", -1));
                GWMainProcessTask favUrlTask = new FavUrlTask();
                favUrlTask.actionType = 4;
                favUrlTask.msB = bundle;
                GameWebViewMainProcessService.b(favUrlTask);
                if (favUrlTask.fnI) {
                    x.i("MicroMsg.OptionMenuBtnHelp", "del fav web url ok, finish webview ui");
                    this.nai.mYx.finish();
                    return;
                }
                return;
            default:
                x.i("MicroMsg.OptionMenuBtnHelp", "do del cancel");
                return;
        }
    }
}
