package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class aq$2 implements OnClickListener {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;
    final /* synthetic */ aq mXd;

    aq$2(aq aqVar, d dVar, int i) {
        this.mXd = aqVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        d dVar = this.mWr;
        int i2 = this.gOK;
        aq aqVar = this.mXd;
        dVar.E(i2, a.e("add_download_task:fail_network_not_wifi", null));
    }
}
