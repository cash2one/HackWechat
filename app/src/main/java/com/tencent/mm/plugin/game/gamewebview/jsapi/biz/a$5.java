package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class a$5 implements OnClickListener {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;
    final /* synthetic */ a mWs;

    a$5(a aVar, d dVar, int i) {
        this.mWs = aVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        d dVar = this.mWr;
        int i2 = this.gOK;
        a aVar = this.mWs;
        dVar.E(i2, a.e("add_download_task:fail_network_not_wifi", null));
    }
}
