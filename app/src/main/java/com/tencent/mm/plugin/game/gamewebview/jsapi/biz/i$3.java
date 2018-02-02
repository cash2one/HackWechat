package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class i$3 implements OnCancelListener {
    final /* synthetic */ int gOK;
    final /* synthetic */ i mWH;
    final /* synthetic */ d mWr;

    i$3(i iVar, d dVar, int i) {
        this.mWH = iVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d dVar = this.mWr;
        int i = this.gOK;
        i iVar = this.mWH;
        dVar.E(i, a.e("doChooseMedia:cancel", null));
    }
}
